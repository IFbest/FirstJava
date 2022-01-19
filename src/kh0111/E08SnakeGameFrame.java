package kh0111;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class E08SnakeGameFrame extends JFrame {
    Thread snakeThread;
    GroundPanel p;
    //생성자로 부터 시작
    public E08SnakeGameFrame() {
        super("스내이크 움지기기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JFrame 객체 설정 및 JPanel 객체 배치
        p = new GroundPanel();
        //ContentPane 에 JPanel 객체 추가
        setContentPane(p);
        setSize(400,400);//사이즈 설정
        setVisible(true);//보이게 설정
        p.requestFocus();//p를 이벤트 수용 가능 상태로 변환, 포커스를 받는 상태
        snakeThread = new Thread(p);//p객체를 쓰레드화 하고
        snakeThread.start();//쓰레드 시작
    }
    //패널 객체이자 Runnable 인터페이스를 구현해 쓰레드를 실행하는 클래스
    class GroundPanel extends JPanel implements Runnable{
        static final int LEFT = 0;
        static final int RIGHT = 1;
        static final int UP = 2;
        static final int DOWN = 3;//switch-case의 case로 사용됨
        int direction;//방향
        Image img; // 이미지 객체 변수
        //뱀 몸통 객체 생성
        SnakeBody snakeBody;
        //딜레이 시간 0.2초
        final int delay = 200;
        //JFrame이 실행되면서 동작
        public GroundPanel() {
            setLayout(null);
            //snakeBody 객체를 생성하고
            snakeBody = new SnakeBody();
            //코딩된 addIn 메소드를 활용해 바디를 추가함
            snakeBody.addIn(this);
            //초기 이동 방향은 LEFT
            direction = LEFT;
            //addKeyListener 이벤트 생성
            this.addKeyListener(new MyKeyListener());
            //배경화면 이미지 아이콘 객체 생성
            ImageIcon icon = new ImageIcon("bg.jpg");
            //ImageIcon 객체로 부터 이미지 획득
            img = icon.getImage();
        }
        //이미지를 그리는 메소드
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img,0,0,getWidth(),getHeight(),null);
        }
        //실질적으로 동작이 진행되는 메인 부분
        public void run(){
            while (true){
                try{
                    Thread.sleep(delay);
                    //move 메소드를 통해 방향대로 이동함
                    snakeBody.move(direction);
                }catch (InterruptedException e){
                    return;
                }
            }
        }
        //KeyAdapter 클래스를 활용해 키보드 입력 이벤트 처리
        class MyKeyListener extends KeyAdapter {
            //키보드 버튼에 따라 direction 을 결정함
            public void keyPressed(KeyEvent e){
                //switch-case 문을 활용해 분류
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        direction = LEFT;
                        break;
                    case KeyEvent.VK_RIGHT:
                        direction = RIGHT;
                        break;
                    case KeyEvent.VK_UP:
                        direction = UP;
                        break;
                    case KeyEvent.VK_DOWN:
                        direction = DOWN;
                        break;
                }
            }
        }
    }
    //뱀의 형상을 결정하는 클래스
    class SnakeBody {
        //JLabel 객체가 많이 있어 Vector를 활용해 묶음으로 처리
        Vector<JLabel> v = new Vector<JLabel>();

        public SnakeBody() {
            //head객체 생성
            ImageIcon head = new ImageIcon("head.jpg");
            //JLabel 객체로 생성
            JLabel la = new JLabel(head);
            la.setSize(head.getIconWidth(), head.getIconHeight());
            //객체 정보를 벡터 변수에 저장 이미지 크기만큼 크기 설정함
            v.add(la);
            la.setLocation(80,100);//헤드와 시작위치가 달라 처음 시작시 이상하지 않아 위치 설정

            ImageIcon body = new ImageIcon("body.jpg");
            //뱀의 몸통은 10개
            for (int i =0;i<10;i++){
                la = new JLabel(body);//라벨을 총 10개 만들겠다
                la.setSize(body.getIconWidth(),body.getIconHeight());//사이즈는 이미지 사이즈를 따라감
                la.setLocation(100 + i * 20,100);//초기값x에 i를 더하여 1칸씩 연결된 것처럼 위치
                //몸통도 같은 방법으로 저장
                v.add(la);//라벨 추가
            }
        }
        //블럭객체를 JPanel 에 추가하는 메소드
        public void addIn(JPanel p) {
            for (int i=0;i<v.size();i++)
                p.add(v.get(i));
        }
        //키보드 입력에 따라 뱀을 이동시키는 메소드
        public void move(int direction) {
            //아래의 for문을 통해 뒤의 객체는 앞의 객체 위치로 이동하게 됨
            for (int i = v.size() -1; i>0;i--){
                JLabel b = v.get(i);//앞의 객체
                JLabel a = v.get(i -1);//앞의 객체를 따라가는 뒤의 객체
                //동작이 완료된 후 setLocation 메소드를 활용해 객체의 위치를 재지정
                b.setLocation(a.getX(),a.getY());
                //다음 블럭을 이전 블럭의 위치를 이동
            }
            JLabel head = v.get(0);
            switch (direction){
                case GroundPanel.LEFT:
                    head.setLocation(head.getX() -20,head.getY());
                    break;
                case GroundPanel.RIGHT:
                    head.setLocation(head.getX() + 20,head.getY());
                    break;
                case GroundPanel.UP:
                    head.setLocation(head.getX(), head.getY() - 20);
                    break;
                case GroundPanel.DOWN:
                    head.setLocation(head.getX(),head.getY() +20);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new E08SnakeGameFrame();
    }
}
