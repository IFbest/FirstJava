package kh0110;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class E13VibrationFrame extends JFrame implements Runnable {
    //Runnable 인터페이스를 활용했으므로 Thread 객체를 별도로 생성
    Thread th;

    public E13VibrationFrame() {
        //JFrame 객체 기본 설정
        setTitle("진동하는 프레임 만들기");
        setSize(E12BallUpdate_Thread.BOARD_WIDTH,E12BallUpdate_Thread.BOARD_HEIGHT);
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!th.isAlive()) return;//isAlive() : 해당 스레드의 실행여부 반환
                //근데 만약 스레드가 실행중에도 한 번도 sleep()을 호출하지 않는다면
                //Interrupted Exception을 받지 못한다
                //이런 경우에는 무한루프 중간에 다음과 같이 인터럽트 검사해주는 것이 좋다.
                th.interrupt();//interrupt하나의 스레드가 실행되고 있는 작업을 중지
            }
        });
        th = new Thread(this); //진동하는 스레드 객체 생성
        //run 메소드 실행
        th.start();
    }
    public void run(){
        //프레임의 진동을 일으키기 위해 20ms마다 프레임 위치를 랜덤하게 이동
        Random r = new Random();
        while (true){//무한 루프
            try {
                Thread.sleep(20);//20ms sleep 상태로 변경
            }catch (InterruptedException e){return;}
            int x = getX() + r.nextInt() % 50;
            int y = getY() + r.nextInt() % 50;//새위치 0~5 사이의 값
            setLocation(x,y);
        }//에러를 잡아내기 위한 try catch문
    }

    public static void main(String[] args) {
        new E13VibrationFrame();
    }
}
