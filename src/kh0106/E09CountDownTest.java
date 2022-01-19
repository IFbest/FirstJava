package kh0106;

import javax.swing.*;
import java.awt.*;

public class E09CountDownTest extends JFrame {
    private JLabel label;
    //내부 클래스에 Thread 객체 상속
    class MyThread extends Thread{
        //start 메소드에 의해 실행됨
        public void run() {
            for (int i=10;i>=0;i--){
                try {
                    Thread.sleep(1000);
                    //sleep()은 도중에 예외가 발생할 가능성이 있다.
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                label.setText(i + " ");//1초가 지나가면 레이블의 텍스트를 변경한다.
            }//스레드 내부클래스로 만들면 필드에 접근하기 쉬워진다
        }
    }
    E09CountDownTest() {
        setTitle("카운트 다운");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //초기 JLabel 객체 상태 지정
        label = new JLabel("Start");
        label.setFont(new Font("Serif",Font.BOLD,100));
        add(label);
        //후 JFrame 에 입력
        setVisible(true);
        Thread t = new MyThread();
        t.start();
        setLocation(800,800);
    }
    public static void main(String[] args) {
        new E09CountDownTest();
    }
}
