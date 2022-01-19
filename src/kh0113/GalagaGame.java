package kh0113;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GalagaGame extends JPanel implements KeyListener {
    private boolean running = true;//게임 진행 상태

    private ArrayList sprites = new ArrayList();
    private Sprite starship;
    private BufferedImage alienImage;
    private BufferedImage shotImage;
    private BufferedImage shipImage;
    private int score = 0;

    public GalagaGame() {
        //제목설정한 프레임 생성자 객체
        JFrame frame = new JFrame("Galaga Game");

        frame.setSize(800,600);//사이즈설정
        frame.add(this);//this는 패널(이클래스)
        frame.setResizable(false);//창크기 조절 불가
        frame.setVisible(true);//보이게 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //종료시 프로세스 종료


        try {//버퍼이미지 변수에 해당 이미지들 삽입
            shotImage = ImageIO.read(new File("explode.png"));
            shipImage = ImageIO.read(new File("spaceship.png"));
            alienImage = ImageIO.read(new File("chicken.jpg"));
        }catch (IOException e){//read사용을위한 예외처리
            e.printStackTrace();
        }
        this.requestFocus();//패널에 키보드입력감지를 위한 포커스
        this.initSprites();//패널 초기화
        addKeyListener(this);//패널에 키리스너 추가
    }
    //이해용
    //적 스프라이트 생성
    //100 + (x*50), (50) + y *30 : 적 사이 간격 설정
    //x = 0, y = 0
    //100 + (0*50), (50) + 0 * 30 = 100, 50 : 0행 0열에 있는 적
    //x = 1, y = 0
    //100 + (1*50), (50) + 0 * 30 = 150, 50 : 0행 1열에 있는 적
    //x = 1, y = 1
    //100 + (1*50), (50) + (1 * 30) = 100, 80 : 1행 1열에 있는 적
    private void initSprites() {//초기 설정 메소드
        starship = new StarShipSprite(this, shipImage, 370, 550);
        sprites.add(starship);
        for (int y=0;y<5;y++){//5행
            for (int x=0; x<12; x++){//12열
                Sprite alien = new AlienSprite(this, alienImage,100+(x*50), (50)+y*30);
                sprites.add(alien);
            }
        }
    }
    private void startGame() {//스타트 버튼을 위해 존재할 것 같은 메서드
        sprites.clear();
        initSprites();
    }
    public void endGame() {//게임종료 메소드
        System.out.println("endgame()");//게임끝 출력
        System.exit(0);//종료
    }
    public void removeSprite(Sprite sprite){
        sprites.remove(sprite);//적 삭제
    }
    public void fire() {//미사일 발사 메소드
        //생성자 객채 생성 this는 ShotSprite에서 설정한 game
        ShotSprite shot = new ShotSprite(this,shotImage, starship.getX()+10, starship.getY()-30);
        sprites.add(shot);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);//부모도 그릴 수 있게 설정
        g.setColor(Color.BLACK);//검은색으로
        g.fillRect(0,0,800,600);//사각형그리기(배경화면)
        for (int i =0;i<sprites.size();i++){//수많은 적 그리기
            Sprite sprite = (Sprite) sprites.get(i);
            sprite.draw(g);
        }
    }
    public void gameLoop(){//플레이어를 제외한 모든 오브젝트를 이동시킴
        while (running){
            for (int i=0; i<sprites.size(); i++){
                //ArrayList의 모든 요소를 가져와서 Sprite타입(슈퍼클래스)으로 변환
                Sprite sprite = (Sprite) sprites.get(i);
                sprite.move();
            }//두 스프라이트의 충돌을 확인
            for (int p =0;p<sprites.size();p++){
                for (int s =0;s<sprites.size();s++){
                    Sprite me = (Sprite) sprites.get(p);
                    //s번째 인덱스의 스프라이트를 가져옴
                    Sprite other = (Sprite) sprites.get(s);
                    //s번째 +1번째 인덱스부터의 스프라이트를 가져옴
                    if (me.checkCollision(other)){
                        me.handleCollision(other);
                        other.handleCollision(me);
                    }
                }
            }
            repaint();
            try {//0.01초 슬립을주어 0.01초마다 작동하게 설정
                Thread.sleep(10);
            }catch (Exception e){
            }
        }
    }
    @Override//키 이벤트 발생시 해당 키일경우 이동정의(이동)
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            starship.setDx(-3);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            starship.setDx(+3);
        if (e.getKeyCode() == KeyEvent.VK_UP)
            starship.setDy(-3);
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            starship.setDy(+3);
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            fire();
    }
    @Override//키 이벤트 발생시 해당 키일경우 이동정의(키를 떼었을 때 이동하지 않게)
    public void keyReleased(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            starship.setDx(0);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            starship.setDx(0);
        if (e.getKeyCode() == KeyEvent.VK_UP)
            starship.setDy(0);
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            starship.setDy(0);
    }
    @Override
    public void keyTyped(KeyEvent arg0){
    }
    //실행문
    public static void main(String[] args) {
        GalagaGame g = new GalagaGame();
        g.gameLoop();
    }
}
