package kh0103;

import javax.swing.*;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;


//이곳에서는 JFrame 의 하위 컴포넌트인 JPanel 객체를 정의한다
public class E16FlyingTextEx extends JFrame {
    //한 번의 키 조작으로 이동하는 거리(픽셀)
    private final int FLYING_UNIT = 10;
    //이동할 타겟의 문자열
    private JLabel la = new JLabel("KeyBoard로");

    public E16FlyingTextEx(){
    	Container c = getContentPane();//컨테이너 초기화
    	setSize(600,600);//사이즈설정
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창을끄면 프로세스도 종료
        setTitle("상하좌우 키를 이용하여 텍스트 움직이기");//제목설정
        setVisible(true);//보이게 설정
        c.addKeyListener(new MyKeyListener());//프레임객체에 키리스너 이벤트 추가
        c.setLayout(null);//컨테이너 배치관리자 제거
        la.setSize(70,20);//라벨 사이즈설정
        la.setLocation(20,50);//라벨 위치설정
        c.add(la);//컨테이너에 라벨 추가
        c.requestFocus();//키 이벤트를 받을 컴포넌트를 강제로 설정
    }
    //Key리스너 구현
    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();//입력된 키의 코드를 알아낸다
            //키 코드 값에 따라 상하좌우 키를 판별하고 la의 위치를 이동시킨다.
            switch (keyCode){//좌표는 왼쪽위부터 0.0으로 시작
                case KeyEvent.VK_UP:
                    la.setLocation(la.getX(), la.getY()-FLYING_UNIT);break;//x는 유지 y는 -10으로 위로
                case KeyEvent.VK_DOWN:
                    la.setLocation(la.getX(), la.getY()+FLYING_UNIT);break;//x는 유지 y는 +10으로 아래로
                case KeyEvent.VK_LEFT:
                    la.setLocation(la.getX()-FLYING_UNIT, la.getY());break;//x는 -10으로 왼쪽으로 y는 유지
                case KeyEvent.VK_RIGHT:
                    la.setLocation(la.getX()+FLYING_UNIT, la.getY());break;//x는 +10으로 오른쪽으로 y는 유지
            }
        }
        
    }
    
    public static void main(String[] args) {
    	new E16FlyingTextEx();
    }
}
