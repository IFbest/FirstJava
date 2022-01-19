package kh0107;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TimerRunnable implements Runnable {
    private JLabel tiemrLabel;

    public TimerRunnable(JLabel timerLabel){
        this.tiemrLabel = timerLabel;//입력받은 값을 필드에 저장
   }
    @Override
    public void run() {
        int n = 0;
        while (true) {
            tiemrLabel.setText(Integer.toString(n));//라벨에 문자타입으로 셋
            n++;//1씩 증가
            try {
                Thread.sleep(1000);//1초 슬립
            }catch (InterruptedException e){
                return;
            }
        }
    }
}

public class E03ThreadInterruptEx extends JFrame{
    private Thread th;
    public E03ThreadInterruptEx() {
        setTitle("ThreadInterruptEx 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();//프레임에 연결된 컨텐트팬을 알아냄
        c.setLayout(new FlowLayout());//플로우 레이아웃 형식으로 셋

        JLabel timerLabel = new JLabel();//타이머로쓸 라벨
        timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));//폰트설정

        TimerRunnable runnable = new TimerRunnable(timerLabel);//쓰레드 사용을위한 객체생성
        th = new Thread(runnable); //스레드 생성
        c.add(timerLabel);//컨테이너에 타이머라벨 추가

        //버튼을 생성하고 Action 리스너 등록
        JButton btn = new JButton("kill Timer");
        btn.addActionListener(new ActionListener() {
            @Override
            //버튼 이벤트 리스너를 활용해 쓰레드를 강제종료 하는 과정을 수행
            public void actionPerformed(ActionEvent e) {
                th.interrupt();//스레드 강제 종료
                JButton btn = (JButton) e.getSource();
                btn.setEnabled(false);//버튼 비활성화
            }
        });
        //컨테이너에 버튼 추가
        c.add(btn); setSize(300,170); setVisible(true);
        th.start();//스레드 실행
    }
    public static void main(String[] args) {
        new E03ThreadInterruptEx();
    }
}
