package kh0111;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class E04Game369singleFrame extends JFrame {
    //JFrame 객체의 기본설정
    public E04Game369singleFrame() {
        setTitle("369 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JPanel 객체인 GamePanel 객체를 콘텐츠팬에 추가함
        setContentPane(new GamePanel());
        setSize(300,300);
        setVisible(true);
    }
    class GamePanel extends JPanel{
        //Thread 클래스를 상속받는 TimerThread 객체 생성
        TimerThread th;
        //JLabel 카드 객체 생성
        JLabel card = new JLabel();
        //JButton 버튼 객체 생성 (시작버튼)
        JButton startBtn = new JButton("start");
        //카드에 표시될 숫자 생성
        int n = 1;
        //369 게임의 승패를 판단할 singleClicked doubleClicked 변수 생성
        boolean singleClicked = false;
        boolean doubleClicked = false;

        //JPanel 객체의 동작
        GamePanel(){
            //setLayout을 사용하지 않음
            setLayout(null);
            //card 객체 정보를 입력한 후
            card.setOpaque(true);
            card.setBackground(Color.ORANGE);
            card.setFont(new Font("Arial", Font.ITALIC, 30));
            card.setHorizontalAlignment(JLabel.CENTER);
            card.setText(Integer.toString(n));
            card.setSize(100,50);
            card.setLocation(100,100);
            //addMouseListener 마우스 핸들러 사용
            card.addMouseListener(new MouseHandler());
            //JPanel에 저장
            add(card);

            //버튼 객체 설정
            startBtn.setLocation(100,200);
            startBtn.setSize(100,30);
            //addActionListener 액션 리스너 메소드를 활용해 이벤트 입력
            startBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //클릭하면 n=1로 시작
                    n = 1;
                    //setText 메소드로 1을 출력
                    card.setText(Integer.toString(n));
                    singleClicked = false;
                    doubleClicked = false;
                    //위에서 생성된 th 객체를 실행시킴
                    th = new TimerThread();
                    th.start();
                    //JButton 객체를 만든 후 버튼을 비활성화 시킴
                    JButton b = (JButton) e.getSource();
                    b.setEnabled(false);
                }
            });
            add(startBtn);
        }
        //synchronized 키워드를 활용해 쓰레드들이 조화롭게 동작하도록 함
        synchronized void setSingleClicked(boolean b){
            singleClicked = b;
        }
        synchronized void setDoubleClicked(boolean b){
            doubleClicked = b;
        }
        //th쓰레드를 실행하면
        class TimerThread extends Thread {
            //run 메소드가 실행됨
            public void run() {
                while (true){
                    try {
                        //1.4초 간격으로 동작
                        sleep(1400);
                        //클릭 횟수 콘솔창에 출력
                        System.out.println(n + "----------");
                        System.out.println("SingleClicked" + "singleClicked");
                        System.out.println("DoubleClicked" + "DoubleClicked");
                        //int 타입을 활용해 각 자릿수 획득
                        int x = n % 10;
                        int y = n / 10;
                        //두 자리 숫자가 모두 3의 배수이면 더블클릭을 해야 한다
                        //본 예제에서는 24까지만 있으므로 의미 없다
                        if ((x==3 || x==6 || x==9) && (y ==3 || y == 6 || y == 9)){
                            if (doubleClicked == true){
                                setDoubleClicked(false);
                            }else{
                                msg("Fall^^");
                                break;
                            }
                        }
                        //두 자릿 수 중 하나만 3의 배수일 경우 한 번만 클릭해야 한다
                        else if ((x==3 | x ==6 || x ==9) || (y ==3 | y ==6 | y ==9)){
                            if (singleClicked == true){
                                setSingleClicked(false);
                            }
                            else {
                                msg("Fall^^");
                                break;
                            }
                        }
                        else{
                            //그 밖의 클릭 행위가 발생하면 에러다
                            if (singleClicked == true || doubleClicked == true){
                                msg("Fail^^");
                                break;
                            }
                        }
                        //번호는 1.4초 당 1씩 증가하며
                        n++;
                        //24까지 버티면 승리한다(25는 뜨지 않는다)
                        if (n == 25){
                            msg("Win!");
                            break;
                        }else
                            //25까지 버티지 못했을 경우 card에 실패한 숫자를 출력한다
                        //이전에 모든 실패 동작이 완료되므로 else 문은 의미가 없다
                        card.setText(Integer.toString(n));
                    }catch (InterruptedException e){
                        return;
                    }
                }
                startBtn.setEnabled(true);
            }
            void msg(String s){
                card.setText(s);
            }
        }
        //MouseAdapter 클래스를 ㅅ아속받아 간결하게 표현
        class MouseHandler extends MouseAdapter{
            public void mousePressed(MouseEvent e){
                //싱글클릭과 더블클릭 구분
                //결과를 각각의 메소드에 전송
                if (e.getClickCount() == 2){
                    setDoubleClicked(true);
                    setSingleClicked(false);
                }else {
                    setSingleClicked(true);
                }
                //마우스를 누를 때 card 객체의 배경색을 녹색으로
                JLabel card = (JLabel) e.getSource();
                card.setBackground(Color.GREEN);
            }
            //뗄 때 색을 다시 오랜지 색으로 변경
            public void mouseReleased(MouseEvent e){
                JLabel card = (JLabel) e.getSource();
                card.setBackground(Color.ORANGE);
            }
        }
    }

    public static void main(String[] args) {
        //코드시작
        new E04Game369singleFrame();
    }
}
