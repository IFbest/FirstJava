package kh0111;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class E09BulletGameFrame extends JFrame {
    public E09BulletGameFrame() {
        setTitle("사격 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JFrame 기본 세팅
        GamePanel p = new GamePanel();
        //ContentPane 에 JPanel 객체 추가
        setContentPane(p);
        setSize(500,500);
        setResizable(false);//사이즈 변경 불가
        setVisible(true);//보이게 설정
        //기본 설정이 끝나면 startGame 메소드를 통해 게임을 실행
        p.startGame();
    }
    public static void main(String[] args) {
        new E09BulletGameFrame();
    }
}
class GamePanel extends JPanel {
    //쓰레드 객체를 생성하고 발사대, 총알, 타겟 객체를 JLabel 타입으로 생성
    TargetThread targetThread = null;//쓰레드 객체
    JLabel baseLabel = new JLabel();//발사대
    JLabel bulletLabel = new JLabel();//총알
    JLabel targetLabel;//타겟

    //JPanel 객체에 JLabel를 추가하고 설정 해서 JFrame 객체에 입력
    public GamePanel() {
        setLayout(null);//기본레이아웃 삭제
        //발사대 기본설정(자체 이미지 생성)
        baseLabel.setSize(40,40);//발사대 사이즈
        baseLabel.setOpaque(true);//배경화면 보이게 설정
        baseLabel.setBackground(Color.BLACK);//배경화면 검은색으로


        //타겟은 ImageIcon 클래스를 활용해 외부 이미지 활용
        ImageIcon img = new ImageIcon("chicken.jpg");//이미지아이콘으로 img에 이미지 저장
        targetLabel = new JLabel(img);//타겟에 이미지를매개변수로 생성자 추가
        targetLabel.setSize(img.getIconWidth(),img.getIconHeight());//타겟라벨 사이즈를 이미지이 넓이와 높이로 설정
        //미사일 객체도 자체 이미지를 생성해서 사용
        bulletLabel.setSize(10,10);//총알라벨은 사이즈 10 10
        bulletLabel.setOpaque(true);//배경화면 보이게 설정
        bulletLabel.setBackground(Color.RED);//배경화면을 빨간색으로
        //JPanel 객체에 JLabel 객체들을 추가
        add(baseLabel);//패널에 발사대라벨 추가
        add(targetLabel);//패널에 타겟라벨 추가
        add(bulletLabel);//패널에 총알라벨 추가
    }
    //startGame 메소드를 활용해 게임 시작
    public void startGame() {
        //객체들의 초기 위치를 지정하고
        baseLabel.setLocation(this.getWidth()/2-20, this.getHeight()-40);//발사대라벨시작위치
        bulletLabel.setLocation(this.getWidth()/2-5, this.getHeight()-50);//총알라벨시작위치
        targetLabel.setLocation(0,0);//타겟라벨시작위치

        //targetLabel 객체를 targetThread 쓰레드 클래스에 입력해 시작
        targetThread = new TargetThread(targetLabel);
        targetThread.start();//타겟쓰레드 시작
        //baseLabel 객체에 이벤트를 등록,
        baseLabel.requestFocus();//발사대에 키입력 이벤트 등록
        baseLabel.addKeyListener(new KeyAdapter() {//키어답터를 이용하여 키이벤트 감지
            BulletThread bulletThread = null;//총알쓰레드를 넣을 변수를 만들고 null값 대입
            public void keyPressed(KeyEvent e) {
                //getKeyChar 메소드를 통해 엔터키 입력 여부를 판별하고
                if (e.getKeyChar() == '\n'){
                    //그 상황에서 bulletThread 가 실행되지 않은 상태라면 bulletThread 객체를 실행
                    //이 조건 때문에 총알은 한 발만 발사됨
                    if (bulletThread == null || !bulletThread.isAlive()){//총알쓰레드가 null이거나 살아있지 않다면 true
                        bulletThread = new BulletThread(bulletLabel,targetLabel,targetThread);//총알쓰레드 객체생성
                        bulletThread.start();//총알쓰레드 실행
                    }
                }
            }
        });
    }
    class TargetThread extends Thread {//타겟쓰레드
        JComponent target;//컴포넌트 타겟
        public TargetThread(JComponent target){
            this.target = target;//필드타겟에 매개변수 타겟대입
            target.setLocation(0,0);//타겟 초기위치설정
            target.getParent().repaint();//타겟의 조상 디렉토리로 재표현
        }
        public void run() {//쓰레드 실행부분
            while (true){//반복
                //run을 할 때 마다 x축으로 5씩 이동한다
                int x = target.getX() + 5;//5씩 이동
                int y = target.getY();//y축 고정
                //getWidth 패널의 x축 범위를 넘어서면 다시 원점으로 복귀
                if (x>GamePanel.this.getWidth())
                    target.setLocation(0,0);
                else
                    target.setLocation(x,y);
                try {
                    sleep(20);//0.02초 기다림
                }catch (InterruptedException e){
                    //the case of hit by a bullet
                    //catch 상황은 미사일에 맞은 경우에 적용
                    target.setLocation(0,0);
                    //그래서 타겟을 원점으로 돌리고 다시 실행함
                    target.getParent().repaint();
                    try {
                        //0.5초 간격으로 쓰레드를 실행
                        sleep(500);//0.5초 기다림
                    }catch (InterruptedException e2){}
                }
            }
        }
    }
    class BulletThread extends Thread {
        JComponent bullet, target;
        Thread targetThread;
        //미사일 쓰레드에서는 타겟,총알과 타겟 쓰레드 객체 변수를 받아들이고
        //충돌 상황 발생 시 타겟 쓰레드의 중단 여부를 결장하는 명령을 한다
        public BulletThread(JComponent bullet,JComponent target,Thread targetThread){
            this.bullet = bullet;
            this.target = target;
            this.targetThread = targetThread;
        }
        //run메소드 실행
        public void run() {
            while (true){
                //명중했는지 확인, hit 메소드로 판별
                if (hit()){
                    //targetThread 를 중단하고
                    targetThread.interrupt();
                    //bullet을 최초 발사대 위치에 이동시키고
                    bullet.setLocation(bullet.getParent().getWidth()/2-5,bullet.getParent().getHeight()-50);
                    //다시 복귀
                    return;
                    //충돌하지 않았다면 총알을 y축으로 이동시킴
                }else {
                    int x = bullet.getX();
                    int y = bullet.getY()-5;
                    //y가 위치를 넘어서면 미사일 쓰레드를 종료하고 총알 객체를 원위치 시킴
                    if (y<0){
                        bullet.setLocation(bullet.getParent().getWidth()/2 -5,bullet.getParent().getHeight()-50);
                        bullet.getParent().repaint();
                        return;//쓰레드 종료
                    }
                    bullet.setLocation(x,y);//총알을 원위치
                    bullet.getParent().repaint();
                }
                try {
                    sleep(20);
                }catch (InterruptedException e){}
            }
        }
        //충돌 상황은 두 객체의 크기 좌표가 겹치는지 여부를 판단해 결정한다
        private boolean hit(){
            if (targetContains(bullet.getX() + bullet.getWidth() -1, bullet.getY()) ||
            targetContains(bullet.getX() + bullet.getWidth() -1, bullet.getY() + bullet.getHeight() -1)||
                    targetContains(bullet.getX(), bullet.getY() + bullet.getHeight() -1))
            return true;
            else return false;
        }
        private boolean targetContains(int x, int y){
            if (((target.getX() <= x) && (target.getX() + target.getWidth() -1 >= x)) &&
                    ((target.getY() <= y) && (target.getY() + target.getHeight() -1>= y))){
                return true;
            }else return false;
        }
    }
}
