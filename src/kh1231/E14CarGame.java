package kh1231;

//JFrame JPannel 클래스를 활용한 그래픽 인터페이스 구현 및
//KeyEvent 객체를 활용한 이미지 컨트롤

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;

class MyPanel extends JPanel{
    BufferedImage img = null;
    int img_x = 100;
    int img_y = 100;
    public MyPanel(){
        try{
            img = ImageIO.read(new File("C:\\Temp/car.gif"));
        } catch(IOException e) {
            System.out.println("no image");
            System.exit(1);
        }
        addKeyListener(new KeyListener(){
            public void keyPressed(KeyEvent e) {
                int keycode = e.getKeyCode();
                switch(keycode) {
                    case KeyEvent.VK_UP: img_y -= 10; break;
                    case KeyEvent.VK_DOWN: img_y += 10; break;
                    case KeyEvent.VK_LEFT: img_x -= 10; break;
                    case KeyEvent.VK_RIGHT: img_x += 10; break;
                }
                repaint();
            }
            public void keyReleased(KeyEvent arg0) {}
            public void keyTyped(KeyEvent arg0) {}
        });
        this.requestFocus();
        setFocusable(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, img_x, img_y, null);
    }
}
public class E14CarGame extends JFrame {
    public E14CarGame(){
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MyPanel());
        setVisible(true);
    }
    public static void main(String[] args) {
        E14CarGame s = new E14CarGame();
    }
}
