package kh0111;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Vector;

public class E07SnowFrame extends JFrame {
    //여기서 부터 시작
    public E07SnowFrame(){
        //JFrame 객체 초기 설정
        super("눈 내리는 샤갈의 마을");//프레임 제목
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ContentPane : JFrame 객체에는 직접적으로 컴포넌트를 추가할 수 없기 때문에 할용하는 객체
        //JPanel 객체인 SnowPanel 클래스를 컴포넌트로 추가함
        setContentPane(new SnowPanel());
        setSize(300,300);
        setResizable(false);//사이즈변경불가
        setVisible(true);//보이게설정
    }
    class SnowPanel extends JPanel {
        //ImageIcon 객체 생성
        ImageIcon icon = new ImageIcon("back.jpg");
        //Image객체 생성
        Image img = icon.getImage();
        //눈 정보 상수로 선언(개수와 사이즈)
        final int SNOWS = 50;
        final int SNOW_SIZE = 10;
        //int xDir;
        //Vector 객체에 눈 추가
        //객체를 저장하는 자료형, 일반형으로 저장해도 자동 박싱 된다.
        //Point : 좌표를 표시하는 클래스
        //snowVector는 눈의 좌표정보를 저장하는 클래스
        Vector<Point> snowVector = new Vector<Point>();

        public SnowPanel() {
            //addComponentListnener : 컴포넌트를 추가하는 메소드
            this.addComponentListener(new ComponentAdapter() {
                @Override
                //컴포넌트의 크기가 변경될 때 실행
                public void componentResized(ComponentEvent e) {
                    //addSnow 메소드를 실행해 눈을 추가
                    addSnow();
                    //SnowThread 객체를 실행시켜 눈 객체들을 동시에 동작시킴
                    new SnowThread().start();
                    //removeComponentListener : 삭제되면 실행되는 메소드
                    SnowPanel.this.removeComponentListener(this);
                }
            });
        }
        @Override
        //repaint 메소드에 의해 실행 paintComponent
        public void paintComponent(Graphics g){
            //이미지 정보가 갱신됨
            super.paintComponent(g);
            g.drawImage(img, 0,0,this.getWidth(),this.getHeight(),this);
            drawSnow(g);
        }
        void addSnow() {
            for (int i =0;i<SNOWS;i++){
                //int xDir = Math.random() > 0.5 ? 1: -1;
                //changeSnowPosition(xDir);
                //랜덤으로 눈의 위치를 결정한 후
                Point p = new Point((int)(Math.random()*getWidth()),(int)(Math.random()*getHeight()));
                //생성된 좌표를 snowVector 에 저장
                snowVector.add(p);
            }
        }
        //눈을 그리는 메소드
        //paintComponent 메소드 안에 있다
        void drawSnow(Graphics g){
            //색상은 흰색
            g.setColor(Color.WHITE);
            //snowVector 에 저장된 눈의 상태를 표현한다
            for (int i=0;i<snowVector.size();i++){
                Point p = snowVector.get(i);
                g.fillOval(p.x,p.y,SNOW_SIZE,SNOW_SIZE);
            }
        }
        //랜덤 메소드를 활용해 눈의 이동 속도를 조절하는 메소드
        void changeSnowPosition() {
            for (int i=0;i<SNOWS;i++){
                Point p = snowVector.get(i);
                int xDir = Math.random() > 0.5 ? 1 : -1;
                //눈의 방향은 x축으로만 변경
                int offsetX = (int)(Math.random() * 3) * xDir;
                int offsetY = (int)(Math.random() * 7);
                //포인트 객체에 저장된 x축과 y축의 좌표정보를 업데이트
                p.x += offsetX;
                if (p.x < 0) p.x = 0;
                p.y += offsetY;
                if (p.y > getHeight()){
                    p.x = (int)(Math.random()*getWidth());
                    p.y = 5;
                }
            }
        }
        //해당 쓰레드가 계속 동작 하면서 눈의 상태를 표현한다
        class SnowThread extends Thread {
            public void run(){
                while (true){
                    try {
                        sleep(100);
                    }catch (InterruptedException e){return;}
                    changeSnowPosition();
                    //repaint 메소드를 활용해 디스플레이 갱신
                    repaint();
                }
            }
        }
    }
    public static void main(String[] args) {
     new E07SnowFrame();
    }
}
