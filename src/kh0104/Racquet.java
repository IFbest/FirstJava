package kh0104;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Racquet {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 80;
    int x = 0;
    int y = 0;
    Color color;
    int xspeed = 0;
    int yspeed = 0;
    private GameBoard game;//GameBoard 클래스를 private로 game변수에 지정
    private static final int RADIUS = 20;//전역변수 상수 뤠디어스
    //라켓 생성자
    public Racquet(GameBoard game, int x, int y,Color color){
        this.game = game;//게임보드 클래스 셋
        this.x = x;//전역변수x에 x 셋
        this.y = y;//전역변수y에 y 셋
        this.color = color;//전역 컬러에 color셋
    }
    void move() {//move생성자
        if (y + yspeed <0)//y+yspeed값이 0보다 작다면
            yspeed = 1;//yspeed에 1 대입 (아랫면에 닿기 전에 올라가게 만드는 것)
        if (y + yspeed > game.getHeight() -2 * RADIUS)//y+yspeed값이 게임보드의 현재 높이-2보다 높으면(밖으로 나가는 것 방지)
            yspeed = -1;//-1대입(윗면에 닿기 전에 내려가게 만드는 것)
        y = y + yspeed;//좌표값+속도(실상 속도가 좌표값)
    }
    public void draw(Graphics2D g){
        g.setColor(Color.BLUE);//색 설정
        g.fillRect(x,y,20,100);//사각형모양으로 위치와 넓이 설정

    }
    public void keyReleased(KeyEvent e){//키를 눌렀다가 떼면 스피드0 이벤트 재정의
        yspeed = 0;
    }
    public void keyPressed(KeyEvent e){//업버튼은 -3(위로),다운버튼은 3(아래로) 이벤트 재정의
        if (e.getKeyCode() == KeyEvent.VK_UP)
            yspeed = -3;
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            yspeed = 3;
    }
    public Rectangle getBounds() {//볼에 충격을 주기위해 라켓의 위치와 넓이를 객체화
        return new Rectangle(x,y,WIDTH,HEIGHT);
    }
}
