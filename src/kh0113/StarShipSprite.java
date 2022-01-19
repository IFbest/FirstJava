package kh0113;

import java.awt.*;
//우주선 클래스
public class StarShipSprite extends Sprite{
    private GalagaGame game;

    public StarShipSprite(GalagaGame game, Image image, int x, int y){
        super(image, x, y);//이미지,x,y를 생성자로 갖는 부모클래스의 변수 사용(Sprite)
        this.game = game;
        dx = 0;//좌우이동속도 0으로 설정
        dy = 0;//상하이동속도 0으로 설정
    }
    @Override//우주선 이동 재정의
    public void move(){
        if ((dx<0) && (x<10)){//왼쪽벽에 위치하고 이동속도가 0보다 작을경우
            return;//움직임을 제한(진행을 멈춤,그 위치에 있게 함)
        }
        if ((dx>0) && (x>800)){//오른쪽벽보다 적게 위치하고 이동속도가 0보다 클 경우
            return;//움직임을 제한(진행을 멈춤,그 위치에 있게 함)
        }
        super.move();//부모의 메소드의 멤버변수 x += dx;y += dy;갖고 옴
    }
    @Override
    public void handleCollision(Sprite other){//other은 적
        //other객체가 AlienSprite타입으로 형변환 가능한지 확인(총알이 적과 닿았는지 확인)
        if (other instanceof AlienSprite){//플레이어가 적과 충돌했을 때
            game.endGame();//게임 끝내버리기
        }
    }
}
