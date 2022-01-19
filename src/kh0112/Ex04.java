package kh0112;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class GraphicObject {
    BufferedImage img = null;
    //이미지를 넣을 img를 생성한 후 null값을 대입
    int x = 0, y = 0;
    //정수형 변수 x,y를 생성한 후 초기값 0 을 대입

    public GraphicObject(String name) {
        //생성자
        try {
            //try~catch문으로 에러가 떴을 때 실행
            img = ImageIO.read(new File(name));
        }catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(0);//시스템 종료
        }
    }
    public void update() {
    }
    public void draw(Graphics g){
        g.drawImage(img,x,y,null);
    }
}
//GraphicObject상속, 미사일을 나타내는 클래스 정의
class Fire extends GraphicObject {
    boolean fire;
    //fire의 true of false로 나타내기 위해
    //혹은 int fire로 정수형 변수를 만든 뒤
    //65번 행을 조건을 true로 바꾼 뒤 73번행을 비워도 발사가 된다.
    public Fire(String name){
        //Fire 생성자
        super(name);
        //super로 먼저 실행
        y = -2;
        //y의 값을 -2로 변경
    }
    public void update() {
        if (fire)
            //값이 fire(or 그냥 true)일 때
            y -= 50;
        // y에 y - 50을 대입하여 미사일 속도를 올린다
        if (true)
            //y값이 -1보다 작을때 or 그냥 true
            fire = true;
        //키보드가 입력되면 fire의 값이 true로 발사가 된다.
    }
    //스페이스키가 눌리면 미사일이 발사
    public void keyPressed(KeyEvent event, int x, int y){
        //x와 y를 생성한다
        if (event.getKeyCode() == KeyEvent.VK_SPACE){
            //만약 입력받은 키가 스페이스라면
            this.y = y;
            this.x = x;
            //우주선의 위치에 미사일위치를 지정해준다
        }
    }
}
//GrapicObject상속, Enemy클래스 작성
class Enemy extends GraphicObject {
    int dx = -10;
    boolean siva = true;
    //정수형변수 dx를 만든뒤 초기값 -10을 대입

    public Enemy(String name){
        super(name);
        x = 500;
        y = 0;
        // enemy의 시작 위치값
    }
    //Enemy캐릭터의 위치 변경
    public void update() {
        //siva변수를 만들고 true값을 준 뒤 충돌했을 때 false가 되어 위치가 멈추게 한다
        if (siva){
            x += dx;
            // x = x + dx
            if (x<0)
                dx = +10;
            if (x>500)
                dx = -10;
        }
    }

}
// GraphicObject상속, SpaceShip클래스 작성
class SpaceShip extends GraphicObject {
    //클래스 선언
    public SpaceShip(String name){
        //생성자
        super(name);
        x = 150;
        y = 350;
        //SpaceShip 시작 위치 지정
   }
   //화살표 키에 따라 플레이어 캐릭터 위치 변경
    public void KeyPressed(KeyEvent event){
        if (event.getKeyCode() == KeyEvent.VK_LEFT){
            x -= 10;
            //만약 입력받은 키가 <- 라면
            //x값을 -10 한다
            //spaceShip의 위치가 왼쪽으로 간다
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT){
            x += 10;
            //만약 입력받은 키가 ->라면
            //x값을 +10을 한다
            //SpaceShip의 위치가 오른쪽으로 간다
        }
        if (event.getKeyCode() == KeyEvent.VK_UP){
            y -= 10;
            //만약 입력받은 키고 윗키라면
            //y값을 -10을 한다
            //SpaceShip의 위치가 위쪽으로 간다
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN){
            y += 10;
            //만약 입력받은 키가 아래라면
            //y값을 +10한다
            //Spacship의 위치가 아래쪽으로 간다
        }
    }
}
class BackGround extends GraphicObject {
    //Background 클래스 생성
    public BackGround(String name){
        // 생성자
        super(name);
        x = 0;
        y = 0;
        // Background의 위치지정
    }
}
class MyPanel extends JPanel implements KeyListener{
    //MyPanel 클래스 작성
    Enemy enemy;
    SpaceShip spaceship;
    Fire fire;
    BackGround background;
    //선언

    public MyPanel(){
        //생성자
        super();
        this.addKeyListener(this);
        //키를 입력받기위해
        this.requestFocus();
        setFocusable(true);
        //입력을 여기서 받는다는 뜻
        //입력을 받으려면 입력스레드가 그 클래스에서 동작해야하난 것을 포커스가 해줌
        enemy = new Enemy("enemy.png");
        spaceship = new SpaceShip("spaceship.png");
        fire = new Fire("missile.png");
        background = new BackGround ("space.jpg");
        //이미지파일 지정
        //스레드를 이용하여 게임의 메인루프를 작성
        // 각 객체의 위치를 변경하고 다시 그린다.
        class MyThread extends Thread {
            //클래스 생성
            public void run() {
                //run계속 실행
                while (true){
                    enemy.update();
                    spaceship.update();
                    fire.update();
                    repaint();
                    //while이 true이므로 계속 반복
                    //업데이트가 계속 된다
                    try {
                        Thread.sleep(50);
                    }catch (InterruptedException e){

                    }
                    //절대값을 구하여 오차범위를 주고 마시알이 충돌하면 false로 변경
                    if (Math.sqrt((double) (fire.x - enemy.x)) < 10 && (Math.sqrt((double)(fire.y - enemy.y))<10)){
                        //enemy = new Enemy("explode.png");
                        try {
                            enemy.img = ImageIO.read(new File("explode.png"));
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        enemy.siva = false;
                        // enemy.dx = 0;
                        // if (enemy.dx ==0){
                        // enemy.x = fire.x;
                        // }
                    }
                }
            }
        }
        Thread t = new MyThread();
        //생성
        t.start();
        //시작
    }
    public void paint(Graphics g){
        super.paint(g);
        background.draw(g);
        enemy.draw(g);
        spaceship.draw(g);
        fire.draw(g);
        //paint로 그려준다
    }
    //키보드 이벤트를 각 객체에 전달
    public void keyPressed(KeyEvent event){
        spaceship.KeyPressed(event);
        fire.keyPressed(event, spaceship.x, spaceship.y);
    }
    @Override
    public void keyTyped(KeyEvent e){
    }
    @Override
    public  void keyReleased(KeyEvent e){
    }
}
public class Ex04 extends JFrame {
    public Ex04(){
        setTitle("Shooting Gmaes");
        //window창의 이름
        add(new MyPanel());
        //panel을 추가
        setSize(500,500);
        //윈도우의 창 크기
        setVisible(true);
        //윈도우의 창을 실행
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Ex04();
    }
}
