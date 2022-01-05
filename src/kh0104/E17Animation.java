package kh0104;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class MyPanel1 extends JPanel implements ActionListener{
    //final 기호를 사용해 상수로 활용, 이미지의 크기 및 초기위치
    private final int WIDTH = 500;
    private final int HEIGHT = 300;
    private final int START_X = 0;
    private final int START_Y = 250;
    //이미지 파일을 담기 위한 BufferedImage 객체 변수를 생성
    private BufferedImage image;
    //타이머 객체도 생성
    private Timer timer;
    private int x,y;

    public MyPanel1(){
        //패널 배경식 지정, 패널 크기와 JFrame 크기가 동일
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        //추천 기본 크기를 알아서 지정
        setDoubleBuffered(true);//그림 넣을 메모리 활성화
        //이미지 파일 객체 생성
        File input = new File("c://temp//ship.jpg");
        try {
            //input 객체에 저장된 이미지 파일 버퍼 객체에 저장
            image = ImageIO.read(input);
        }catch (IOException e){
            e.printStackTrace();
        }//이미지를 읽는다.
        x = START_X;
        y = START_Y;

        //타이머 생성자, 1이상이면 어떤 값이 들어와도 동일한 결과가 수행되며
        //0이하에서는 매우 빠른 속도로 움직인다, 무조건 1을 써야겠다
        timer = new Timer(1,this);
        timer.start();//타이머 객체를 생성하고 시작
    }
    //MyPanel1 메소드는 초기 이미지 조건 파일 객체 등 생성만 담당하고
    //나머지 이미지의 동작은 모두 아래 메소드들이 하는 것 같다
    @Override
    //그래픽을 출력하는 메소드
    public void paintComponent(Graphics g){
        //그래픽 객체를 paintComponent 메소드로 이동시킴
        super.paintComponent(g);
        //이미지를 화면에 그린다
        //dreawImage 메소드가 없으면 그림이 생성되지 않는다
        g.drawImage(image, x, y, this);
        //이미지객체,좌표x,좌표y,로딩시점을 알려주는 이미지옵저버(우리가 알 필요는 없으니 this(자기자신 클래스(명))
    }
    @Override
    public void actionPerformed(ActionEvent e){
        //이벤트가 발생하면 좌표를 해당 픽셀 만큼 이동시킴
        x += 1;
        y -= 1;
        //이미지 객체가 범위를 벗어나면 초기 위치로 이동시킴
        if (x > WIDTH){
            x = START_X;
            y = START_Y;
        }
        //동작이 완료되면 repaint 메소드로 이미지를 갱신
        //repaint 메소드가 없으면 그림이 이동하지 않는다
        repaint();
    }
}
public class E17Animation extends JFrame {
    public E17Animation() {
        //JPanel 클래스인 MyPanel1의 생성자를 추가한다
        add(new MyPanel1());
        setTitle("애니메이션 테스트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new E17Animation();
    }
}
