package kh0110;

import javax.swing.*;
import java.awt.*;

class E12Ball{
    //볼 객체의 기본 정보 설정
    private int x = 100;
    private int y = 100;
    private int size = 30;
    private int xSpeed = 10;
    private int ySpeed = 10;

    public void draw(Graphics g){//공을 화면에 그려주는 메소드
        g.setColor(Color.red);
        g.fillOval(x,y,size,size);
        //(100,100,30,30)채운 원을 그린다
    }
    public void update() {
        //볼 객체의 좌표정보를 변경하고
        x += xSpeed;
        y += ySpeed;
        //벽에 부딪힐 경우 속도를 역으로 변경한다
        if ((x+size) > E12BallUpdate_Thread.BOARD_WIDTH - size || x <0){
            xSpeed =- xSpeed;//공의 반사
        }
        if ((y+size)> E12BallUpdate_Thread.BOARD_HEIGHT - size || y <0){
            ySpeed =- ySpeed;//공의 반사
        }

    }
}
public class E12BallUpdate_Thread extends JPanel {
    static final int BOARD_WIDTH = 600;
    static final int BOARD_HEIGHT = 300;
    //E12Ball 객체를 생성하고
    private E12Ball ball = new E12Ball();

    private E12BallUpdate_Thread() {
        //JPanel 기본 설정
        //배경색은 노란색으로
        this.setBackground(Color.YELLOW);
        //JPanel 클래스를 상속받고 있기 때문에 인터페이스를 활용해 쓰레드 생성
        Runnable task = () -> {//람다식을 이용한 스레드 작성
            while (true){
                //볼 객체 정보를 업데이트하는 update 메소드 발생
                ball.update();
                //업데이트가 완료된 후 정보를 repaint 메소드를 통해 업데이트 한다
                //repain 메소드가 실행되면 paintComponent 메소드가 실행된다
                repaint();
                //paint() : 프로그래머가 직접 호출할 수 없는 메소드
                //repaint() : 프로그래머가 호출할 수 있는 메소드
                try {
                    //쓰레드는 0.05초 간격으로 실행
                    Thread.sleep(50);
                }catch (InterruptedException e){}
            }
        };
        new Thread(task).start();
    }
    @Override
    //paintComponent : 스윙 컴포넌트 그리기 기능 제공
    //JComponent의 내장 메소드인데 모든 스윙 컴포넌트가 이 메소드를 오버라이딩 함
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        ball.draw(g);
    }

    public static void main(String[] args) {
        //JFrame 객체를 생성하고
        JFrame frame = new JFrame();
        //기본 설정을 함, E12BallUpdate_Thread 객체를 생성하지 않았지만
        //static 상수이므로 활용 가능
        frame.setSize(E12BallUpdate_Thread.BOARD_WIDTH,E12BallUpdate_Thread.BOARD_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //JPanel 클래스 객체인 E12BallUpdate_Thread를 JFrame 객체에 추가
        frame.add(new E12BallUpdate_Thread());
    }
}
