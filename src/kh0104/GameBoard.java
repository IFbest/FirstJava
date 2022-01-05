package kh0104;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class GameBoard extends JPanel implements KeyListener {
    Ball ball;//Ball클래스를 ball 변수로
    Racquet racquet1;//Racuet클래스를 racquet1로
    Racquet racquet2;//Racuet클래스를 racquet2로

    public GameBoard(){
        ball = new Ball(this, Color.red);//Ball은 this(game)에 빨간색으로
        this.setBackground(Color.green);//배경색 초록
        racquet1 = new Racquet(this, 10,150, Color.blue);//라켓1은 왼쪽으로 객체생성
        racquet2 = new Racquet(this, 560, 150, Color.yellow);//라켓2는 오른쪽으로 객체생성
        setFocusable(true);//키리스너를 사용하기 위해서 포커스셋
        addKeyListener(this);//키리스너 추가
    }
    @Override
    public void keyTyped(KeyEvent e){//키어댑터를 사용하는 이유
    }
    @Override
    public void keyReleased(KeyEvent e){//키를 떼었을 때를 재정의
        racquet1.keyReleased(e);//키를떼었을 때 라켓1에 이벤트 발생
        racquet2.keyReleased(e);//키를떼었을 때 라켓2에 이벤트 발생
    }
    @Override
    public void keyPressed(KeyEvent e){//키를 눌렀을 때를 재정의
        racquet1.keyPressed(e);
        racquet2.keyPressed(e);
    }
    private void move(){//볼 라켓1,2의 이동 재정의(묶는 느낌)
        ball.move();
        racquet1.move();
        racquet2.move();
    }
    @Override
    public void paint(Graphics g){//패인트 재정의(묶는 느낌)
        super.paint(g);//부모클래스도 사용할 수 있게
        Graphics2D g2d = (Graphics2D) g;//g를 2d로 캐스팅
        ball.draw(g2d);
        racquet1.draw(g2d);
        racquet2.draw(g2d);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PingPong");//프레임 객체생성(제목 핑퐁)
        frame.setSize(600,400);//프레임 사이즈 설정
        frame.setVisible(true);//프레임 보이게 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//닫을 시 프로세스 같이 종료

        GameBoard game = new GameBoard();//게임보드 객체생성
        frame.add(game);//프레임에 게임보드 추가!

        while(true){//반복반복
            game.move();//묶어둔 볼 라켓1,2 움직이게
            game.repaint();//이벤트가 있을 때마다 수정
            try {
                Thread.sleep(10);//쓰레드 0.01초간 정지(단위millis)
            }catch (InterruptedException e ) {
                //일시 정지 상태에서 주어진 시간이 되기전에 interrupt() 메소드가 호출되면 InterruptedException이 발생하기 때문에 예외 처리가 필요
                e.printStackTrace();
            }
        }
    }
}