package kh0104;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyPanel extends JPanel implements ActionListener{
    boolean flag = false;//논리값 flag
    private int light_number = 0;//버튼 클릭시 색을 변경해줄 변수

    public MyPanel(){
        setLayout(new BorderLayout());//BorderLayout 형식
        JButton b = new JButton("신호등");//색을 변경해줄 버튼객체
        b.addActionListener(this);//작동을 감지를 버튼에 추가
        add(b,BorderLayout.SOUTH);//버튼 위치는 보더레이아웃형식의 하단위치
    }
    @Override
    protected void paintComponent(Graphics g){//재정의
        super.paintComponent(g);//그래픽 컴포넌트를 상속받을 때 부모클래스도 그릴 수 있게 설정
        g.setColor(Color.BLACK);//그리기 색 설정
        g.drawOval(100,100,100,100);//외부원그리기 위치와 크기
        g.drawOval(100,200,100,100);//외부원그리기 위치와 크기
        g.drawOval(100,300,100,100);//외부원그리기 위치와 크기
        if (light_number == 0){//신호등0일때 빨,1일때 녹,외엔 노
            g.setColor(Color.RED);//내부원 빨간색
            g.fillOval(100,100,100,100);//위치와 크기
        }else if (light_number == 1){
            g.setColor(Color.GREEN);
            g.fillOval(100,200,100,100);
        }else {
            g.setColor(Color.YELLOW);
            g.fillOval(100,300,100,100);
        }
    }
    @Override
    public void actionPerformed(ActionEvent arg0){//재정의
        if (++light_number >= 3)//전위연산자 n = n + 1 에서 앞의 n값
            light_number = 0;
        repaint();
    }
}

public class MyFrame extends JFrame{
    public MyFrame(){//프레임 만들기
        add(new MyPanel());//프레임에 패널을 추가
        setSize(300,500);//패널사이즈 설정
        setVisible(true);//보이게 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창 종료시 프로세스 종료
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}
