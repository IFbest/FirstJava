package Project;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
    private BufferedImage background;

    private BufferedImage lazerImage;

    private Clip clip;
    private AudioInputStream audioInputStream;
    private File audioBgm;
    private File audioShot;
    private File audioExplode;

    private int stage;
    private int freeFireCount = 1;

    Score scoreP = new Score();

    private static int count = 0; // 레이저 쏘는 타이밍 조절

    public GalagaGame() {
        //제목설정한 프레임 생성자 객체
        JFrame frame = new JFrame("Galaga Game");

        frame.setSize(800,600);//사이즈설정
        frame.add(this);//this는 패널(이클래스)
        frame.setResizable(false);//창크기 조절 불가
        frame.setVisible(true);//보이게 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //종료시 프로세스 종료

        try {//버퍼이미지 변수에 해당 이미지들 삽입
            shotImage = ImageIO.read(new File("missile.png"));
            shipImage = ImageIO.read(new File("airplane.png"));
            alienImage = ImageIO.read(new File("enemy.png"));
            background = ImageIO.read(new File("background.jpeg"));
            lazerImage = ImageIO.read(new File("lazer.png"));
        }catch (IOException e){//read사용을위한 예외처리
            e.printStackTrace();
        }
        this.requestFocus();//패널에 키보드입력감지를 위한 포커스
        this.initSprites();//패널 초기화
        addKeyListener(this);//패널에 키리스너 추가

        audioBgm = new File("spacewar.wav").getAbsoluteFile();
        audioShot = new File("shot.wav").getAbsoluteFile();
        audioExplode = new File("explode.wav").getAbsoluteFile();
        stage = 1;
        playSound();
        startGame();
    }
    private void initSprites() {//초기 설정 메소드
        starship = new StarShipSprite(this, shipImage, 370, 500);
        sprites.add(starship);
        for (int y=0;y<5;y++){//5행
            for (int x=0; x<12; x++){//12열
                Sprite alien = new AlienSprite(this, alienImage,100+(x*50), (0)+y*30);
                sprites.add(alien);
            }
        }
    }
    private void startGame() {//스타트 버튼을 위해 존재할 것 같은 메서드
        sprites.clear();
        initSprites();
    }
    public void reset() {
        boolean flag = true;//리셋 기준
        for (int i = 0; i < sprites.size(); i++) {//적 수만큼 반복
            if (sprites.get(i) instanceof AlienSprite) {//수가0이라면
                flag = false;//거짓으로 바꾸고
                break;//반복문 탈출
            }
        }
        if (flag) {
            stage++;//스테이지를 1증가시키고
            freeFireCount++;//필살기 갯수를 1증가시킨다
            startGame();//게임을 재시작
        }
    }
    public void endGame() {//게임종료 메소드
        if (stage==1 && scoreP.getScore()==0){//시작과 같이 증가값이 없을 경우
            JOptionPane.showMessageDialog(null,"스테이지 : "
                    +stage+"\n점수 : "+ scoreP.getScore()+"\n ㅋㅋ","ㅋㅋ",JOptionPane.INFORMATION_MESSAGE);
        }else {//1점이라도 오른다면
            JOptionPane.showMessageDialog(null,"스테이지 : "
                    +stage+"\n점수 : "+ scoreP.getScore(),"대단해요!",JOptionPane.INFORMATION_MESSAGE);
        }

        System.out.println("endgame()");//게임끝 출력
        System.exit(0);
    }
    public void removeSprite(Sprite sprite){
        sprites.remove(sprite);//적 삭제
        scoreP.scoreplus();
    }
    public void removeLazerSprite(Sprite sprite) {
        sprites.remove(sprite);
    }
    public void fire() {//미사일 발사 메소드
        //생성자 객채 생성 this는 ShotSprite에서 설정한 game
        ShotSprite shot = new ShotSprite(this,shotImage, starship.getX()+10, starship.getY()-30);
        sprites.add(shot);
        shotSound();
    }
    public void freeFire(){//필살기 메소드 특정좌표마다 4개씩 발표X4
        if (freeFireCount == 1){
            for (int z=0;z<4;z++){
                ShotSprite shot2 = new ShotSprite(this,shotImage,50,600+(z*40));
                sprites.add(shot2);
            }
            for (int z=0;z<4;z++){
                ShotSprite shot3 = new ShotSprite(this,shotImage,250,600+(z*40));
                sprites.add(shot3);
            }
            for (int z=0;z<4;z++){
                ShotSprite shot4 = new ShotSprite(this,shotImage,430,600+(z*40));
                sprites.add(shot4);
            }
            for (int z=0;z<4;z++){
                ShotSprite shot5 = new ShotSprite(this,shotImage,600,600+(z*40));
                sprites.add(shot5);
            }
            freeFireCount--;
        }


    }
    public void lazer() {
        for (int i = 0; i < (stage*4) + 1; i++) {
            if (count == 100) {
                int j = (int) (1 + (Math.random() * (sprites.size())));
                for (int k = 0; k < sprites.size(); k++) {
                    if (k == j) { // 값이 같다면 레이저 발사!
                        Sprite sprite = (Sprite) sprites.get(j);
                        if (sprite instanceof AlienSprite) {
                            LazerSprite lazer = new LazerSprite(this,
                                    lazerImage,
                                    sprite.x + 15, sprite.y + 30);
                            sprites.add(lazer);
                        }
                    }
                }
                count = 0;
            } else
                count++;
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);//부모도 그릴 수 있게 설정
        g.drawImage(background,0,0,null);
        g.setColor(Color.white);//
        for (int i =0;i<sprites.size();i++){//수많은 적 그리기
            Sprite sprite = (Sprite) sprites.get(i);
            sprite.draw(g);
        }
        g.drawString("스테이지 : " + stage,700,20);
        g.drawString("점수 : " + scoreP.score,700,40);
        g.drawString("필살기 : "+ freeFireCount,700,60);
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
            lazer();
            repaint();
            reset();
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
        if (e.getKeyCode() == KeyEvent.VK_C)
            freeFire();
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
    public void playSound() {
        try {
            audioInputStream = AudioSystem
                    .getAudioInputStream(audioBgm);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            if (true)clip.loop(-1);//무한반복재생
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public void shotSound() {
        try {
            audioInputStream = AudioSystem
                    .getAudioInputStream(audioShot);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public void explodeSound() {
        try {
            audioInputStream = AudioSystem
                    .getAudioInputStream(audioExplode);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    //실행문
    public static void main(String[] args) {
        GalagaGame g = new GalagaGame();
        g.gameLoop();
    }
}
