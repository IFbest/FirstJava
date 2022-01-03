package kh0103;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


//이곳에서는 JFrame 의 하위 컴포넌트인 JPanel 객체를 정의한다
public class E15MouseListenerAllEx extends JFrame {
    //JLabel 최초 멘트
    private JLabel la = new JLabel("No Mouse Event");

    public E15MouseListenerAllEx(){
        //JFrame 제목과 초기 셋팅
        setTitle("MouseListner와 MouseMotionListener예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        //MyMouseListener 객체 생성 후
        MyMouseListener listener = new MyMouseListener();
        //addMouseListener addMouseMotionListener 기능을 넣어 JFrame 객체에 추가
        //MouseListener : 마우스 클릭과 관련된 인터페이스
        //MouseMotionListener : 마우스 움직임과 관련된 인터페이스
        c.addMouseListener(listener);
        c.addMouseMotionListener(listener);

        c.add(la);

        setSize(300,200);
        setVisible(true);
    }
    class MyMouseListener implements MouseListener, MouseMotionListener {
        //마우스 누를 때 좌표 출력
        public void mousePressed(MouseEvent e){
            la.setText("mousepressed(" + e.getX() + "," + e.getY() + ")");
        }
        //누른 마우스를 뗄 때 좌표 출력
        public void mouseReleased(MouseEvent e){
            la.setText("mouseReleased(" + e.getX() + "," + e.getY() + ")");
        }
        public void mouseClicked(MouseEvent e){}
        //마우스가 c객체(JFrame안으로)안으로 들어올 때
        public void mouseEntered(MouseEvent e){
            Component c  = (Component)e.getSource();
            c.setBackground(Color.CYAN);
        }
        //마우스가 c객체(JFrame 밖으로) 밖으로 나올 때
        public void mouseExited(MouseEvent e){
            Component c = (Component)e.getSource();
            c.setBackground(Color.YELLOW);
        }
        //마우스를 누른 상태에서 이동(드래그)할 때
        public void mouseDragged(MouseEvent e){
            la.setText("mouseDragged(" + e.getX() + "," + e.getY() + ")");
        }
        public void mouseMoved(MouseEvent e){
            la.setText("mouseMoved(" + e.getX() + "," + e.getY() + ")");
        }
    }

    public static void main(String[] args) {
        new E15MouseListenerAllEx();
    }

}