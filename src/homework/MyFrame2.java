package homework;

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
    }//계속해서 업데이트한다.
    //화면에 이미지를 그린다.
    public void draw(Graphics g){
        g.drawImage(img,x,y,null);
        //이미지가 담겨진 img를 x와 y값에 출력한다
        //Thread가 아니라 JPanel로 지정되기에 null값이 지정
    }
}
//GraphicObject상속, 미사일을 나타내는 클래스 정의
class Missile extends GraphicObject {
    boolean launched = false;
    //missile의 true of false로 나타내기 위해

    public Missile(String name){
        //missile생성과 초기위치
        super(name);//GraphicObject의 name = buffred~ img
        y = -200;
    }
    public void update() {
        if (launched)
            //값이 fire(or 그냥 true)일 때
            y -= 20;
        // y에 y - 20을 대입하여 미사일 속도를 올린다
        if (y < -100)//y가 -100 즉 창을 넘어 올라가면
            launched = false;//런치를 꺼버려 더이상 올라가지 못하게 함
    }//스페이스를 입력하면 우주선의 위치에 미사일 위치를 지정
    public void keyPressed(KeyEvent event, int x, int y) {
        if (event.getKeyCode() == KeyEvent.VK_SPACE){
            launched = true;
            this.x = x;
            this.y = y;
            //우주선의 x ,y 가 미사일의 x,y위치로 대입됨
        }
    }
}
class Enemy extends GraphicObject{
    int dx = -10;
    int dy = 0;
    boolean siva = true;
    //정수형변수 dx를 만든뒤 초기값 -10을 대입
    //정수형변수 dy를 만든뒤 초기값 0을 대입
    //논리형변수 siva를 생성(움직임을 꺼줄 스위치가됨)

    public Enemy(String name){
        super(name);//GraphicObject의 name = buffred~ img
        x = 500;
        y = 0;
        // 적의 시작 위치값
    }
    public void update() {
        //siva변수를 만들고 true값을 준 뒤 충돌했을 때 false가 되어 위치가 멈추게 한다
        if (siva){
            x += dx;
            y += dy;
            if (y>100)
                dy = -10;
            if (y<=0)
                dy = +10;
            // x = x + dx
            if (x<0)
                dx = +10;
            if (x>500)
                dx = -10;
        }
    }
}

class SpaceShip extends GraphicObject{
    //생성자
    public SpaceShip(String name){
        //SpaceShip 시작 위치 지정
        super(name);//GraphicObject의 name = buffred~ img
        x = 150;
        y = 350;
    }
    public void keyPressed(KeyEvent event){
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
            x -= 10;
            //만약 입력받은 키고 윗키라면
            //y값을 -10을 한다
            //SpaceShip의 위치가 위쪽으로 간다
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN){
            x += 10;
            //만약 입력받은 키가 아래라면
            //y값을 +10한다
            //Spacship의 위치가 아래쪽으로 간다
        }
    }
}
//백그라운드 클래스 생성 GrapicObject상속
class BackGournd extends GraphicObject{
    public BackGournd(String name){
        super(name);
        x = 0;
        y = 0;//배경화면 위치세팅 왼쪽위가 0,0이다
    }
}
//MyPanel 클래스
class MyPanel extends JPanel implements KeyListener{
    Enemy enemy;
    SpaceShip spaceShip;
    Missile missile;
    BackGournd backGournd;
    //생성자
    public MyPanel() {
        super();
        this.addKeyListener(this);
        //키를 입력받기위해
        this.requestFocus();
        setFocusable(true);
        //입력을 여기서 받는다는 뜻
        //입력을 받으려면 입력스레드가 그 클래스에서 동작해야하는 것을 포커스가 해줌

        enemy = new Enemy("enemy.png");
        spaceShip = new SpaceShip("spaceship.png");
        missile = new Missile("missile.png");
        backGournd = new BackGournd("space.jpg");
        //이미지파일 지정
        //스레드를 이용하여 게임의 메인루프를 작성
        class MyThread extends Thread{
            public void run(){
                while (true){//쓰레드가 실행 될 동안 무한반복(업데이트)
                    enemy.update();
                    spaceShip.update();
                    missile.update();
                    repaint();
                    //절대값을 구하여 오차범위를 주고 마시알이 충돌하면 false로 변경
                    if (Math.sqrt((double) (missile.x - enemy.x)) < 10 &&
                            (Math.sqrt((double)(missile.y - enemy.y))<10)) {
                        try {//적의 이미지 변수에 폭발 이미지를 삽입
                            enemy.img = ImageIO.read(new File("explode.png"));
                        }catch (IOException e){//read사용하려면 이미지 예외처리 필수
                            e.printStackTrace();
                        }
                        //if로 이동식을 묶어서 false로 만들어 버리면 이동을 하지 못하게 됨
                        enemy.siva = false;
                    }
                    try {
                        Thread.sleep(50);//0.05초마다 실행되도록 쓰레드슬립
                    }catch (InterruptedException e){//슬립예외처리 필수
                    }
                }
            }
        }//쓰레드 객체 생성 후 실행
        Thread t = new MyThread();
        t.start();
    }
    //화면위에 표현해줄 페인트 재정의
    public void paint(Graphics g){
        super.paint(g);
        backGournd.draw(g);
        enemy.draw(g);
        spaceShip.draw(g);
        missile.draw(g);
    }//키보드 이벤트를 각 객체에 전달
    public void keyPressed(KeyEvent event){
        spaceShip.keyPressed(event);
        missile.keyPressed(event, spaceShip.x, spaceShip.y);
    }
    public void keyReleased(KeyEvent arg0){
    }
    public void keyTyped(KeyEvent arg0){
    }
}
public class MyFrame2 extends JFrame {
    public MyFrame2() {
        setTitle("My Game");//제목설정
        add(new MyPanel());//프레임에 패널 추가
        setSize(500,500);//윈도우사이즈설정
        setVisible(true);//보이게 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//윈도우종료시 프로세스종료
        setResizable(false);//크기 변경불가
        setLocationRelativeTo(null);//정가운데로 윈도우위치
    }
    public static void main(String[] args) {
        new MyFrame2();
    }
}