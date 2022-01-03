package kh0103;

import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

//이곳에서는 JFrame 의 하위 컴포넌트인 JPanel 객체를 정의한다
class MyPanel3 extends JPanel {
    //BufferedImage : 버퍼에 이미지파일을 저장하는 클래스
    BufferedImage img = null;
    //이미지의 초기 출력 위치 지정
    int img_x = 200, img_y = 200;
    public MyPanel3() {
        try{
            //해당 경로의 의미지 파일을 읽어들임
        	img = ImageIO.read(new File("C:\\Temp/car1.gif"));
        }catch(IOException e){
            System.out.println("no image");
            System.exit(1);
        }
        //마우스 클릭 이벤트가 발생하면
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                //초기 위치에서 마우스 클릭 위치로 변경하고
                img_x = e.getX();
                img_y = e.getY();
                //repaint 메소드로 다시 그림
                repaint();
            }
            public void mouseReleased(MouseEvent arg0) {}
            public void mouseTyped(MouseEvent arg0) {}
        });
        this.requestFocus();
        setFocusable(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, img_x, img_y, null);
    }
}
//JFrame 클래스를 상속받는 메인 클래스
//드디어 메인 클래스도 일을 한다
public class E14CarGame extends JFrame{
    public E14CarGame(){
    	setSize(600,600);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	add(new MyPanel3());
    	setVisible(true);
    	
    }
    public static void main(String[] args) {
        new E14CarGame();
    }
}