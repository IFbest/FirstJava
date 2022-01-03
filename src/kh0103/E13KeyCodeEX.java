package kh0103;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class E13KeyCodeEX extends JFrame {
    //JLabel 객체 생성
    private JLabel la = new JLabel("Start!!");

    public E13KeyCodeEX(){
        //JFrame 객체 기본 설정
        setTitle("key code에서 f1키 : 초록색, %키 노란색");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        //addkeyListener 메소드를 통해 키보드 이벤트 추가
        c.addKeyListener(new MyKeyListener());
        //후 JLabel 객체 JFrame 에 입력
        c.add(la);

        //JFrame 크기 등 설정
        setSize(300,150);
        setVisible(true);

        c.setFocusable(true);

        //이거 없어도 동작에 무리가 없다다
        //requestFoucus : 키 이벤트를 받을 컴포넌트를 강제로 설정한다고 하는데 없어도 동작한다
        //setFocusable : 키 이벤트 포커스를 받을 컴포넌트가 여러개 일 때 우선순위 지정
        //c.requestFocus();
    }
    //키 이벤트 관련 클래스
    //KeyAdapter 클래스를 활용해 코드 간략화
    class MyKeyListener extends KeyAdapter{
        //키가 눌렸을 때
        public void keyPressed(KeyEvent e){
            //입력된 키보드 키의 코드 번호값을 획득
            //키값 그대로를 획득 하려면 getKeyChar() 메소드 활용
            la.setText(e.getKeyText(e.getKeyCode()));
            //조건에 따른 배경화면 조정을 위해 컨테이너 객체에 contentPane 객체 생성
            Container contentPane = (Container) e.getSource();
            if (e.getKeyChar() == '%')
                contentPane.setBackground(Color.YELLOW);
            else if (e.getKeyCode() == KeyEvent.VK_F1)
                contentPane.setBackground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        new E13KeyCodeEX();
    }
}
