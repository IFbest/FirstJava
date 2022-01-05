package kh0104;

import java.awt.*;

public class Ball {
    private static final int RADIUS = 20;//전역변수 상수 뤠디어스
    int x = 0;
    int y = 0;
    int xspeed = 1;
    int yspeed = 1;
    private GameBoard game;//GameBoard 클래스를 private로 game변수에 지정
    Color color;
    //Ball생성자 셋
    public Ball(GameBoard game, Color color){
        this.game = game;//게임보드 클래스 셋
        this.color = color;//전역 컬러에 color셋
    }
    void move() {//default타입 void
        if (x + xspeed <0)//x와 xspeed의 합이 0이하라면
            xspeed = 1;//xspeeddp 1을 대입
        if (x + xspeed > game.getWidth() -2 * RADIUS)//x+xspeed값이 게임보드의 현재 넓이-2*20보다 높으면(밖으로 나가는 것 방지)
            xspeed = -1;//-1대입(옆면에 닿기 전에 반대 방향으로 가게 만드는 것)
        if (y + yspeed <0)//y+yspeed값이 0보다 작다면
            yspeed = 1;//yspeed에 1 대입 (아랫면에 닿기 전에 올라가게 만드는 것)
        if (y + yspeed > game.getHeight() -2 * RADIUS)//y+yspeed값이 게임보드의 현재 높이-2보다 높으면(밖으로 나가는 것 방지)
            yspeed = -1;//-1대입(윗면에 닿기 전에 내려가게 만드는 것)
        if (collision()){//라켓에 충돌하면 튕기게 만듦
            xspeed = -xspeed;//스피드를 0으로 만듦
        }
        x = x + xspeed;//좌표값+속도값
        y = y + yspeed;//좌표값+속도값
    }

    private boolean collision() {//충돌
        return game.racquet1.getBounds().intersects(getBounds())//라켓1의 좌표와넓이를 현재 좌표와 교차하는경우 true
                || game.racquet2.getBounds().intersects(getBounds());//라켓2의 좌표와넓이를 현재 좌표와 교차하는경우 true
    }//intersects는 Rectangel2D로부터 상속된 메소드
    public void draw(Graphics2D g){//볼 생성
        g.setColor(color);//컬러셋
        g.fillOval(x,y,2*RADIUS, 2*RADIUS);//원형모양 생성
    }
    public Rectangle getBounds() {//라켓의 위치를 객체화하여 얻어 화
        return new Rectangle(x,y, 2* RADIUS, 2 * RADIUS);
    }
}
