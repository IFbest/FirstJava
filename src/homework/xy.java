package homework;



import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class xy extends JFrame{
    private JLabel la = new JLabel("click");
    public xy(){
        setTitle("Mouse 이벤트 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.addMouseListener(new MyMouseListener());
        la.setSize(50,120);
        la.setLocation(30,30);
        c.add(la);
        ImageIcon icon = new ImageIcon("dog.jpg");
        la.setIcon(icon);
        setSize(500,500);
        setVisible(true);
    }
    class MyMouseListener extends MouseAdapter {
        public Color color;

        public void mouseClicked(MouseEvent e) {
                try {
                    Robot robot = new Robot();
                    PointerInfo pointerInfo = MouseInfo.getPointerInfo();
                    Point point = pointerInfo.getLocation();
                    color = robot.getPixelColor((int) point.getX(), (int) point.getY());

                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                } catch (Exception exception) {
                    System.out.println("no");
                }
            la.setText("" +color);
        }
    }
    //생성자 실행
    public static void main(String[] args) {

        new xy();
    }
}


