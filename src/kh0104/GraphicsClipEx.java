package kh0104;

import javax.swing.*;
import java.awt.*;

//패널에(100,20)에서 150x150 크기로 클리핑 영역을 설정
public class GraphicsClipEx extends JFrame {
    private MyPanel panel = new MyPanel();
    public GraphicsClipEx(){//프레임
        setTitle("클리핑 예제");//제목설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창이꺼지면 프로세스도 종료
        setContentPane(panel);//컨텐트팬에 패널 셋
        setSize(300,400);//사이즈 지정
        setVisible(true);//보이게 설정
    }
    class MyPanel extends JPanel{//패널
        private ImageIcon icon = new ImageIcon("image0.jpg");//아이콘객체
        private Image img = icon.getImage();//이미지 객체
        public void paintComponent(Graphics g){//재정의
            super.paintComponent(g);//그래픽 컴포넌트를 상속받을 때 부모클래스도 그릴 수 있게 설정
            g.setClip(100,20,150,150);//x,y,width,height/
            //이미지객체,좌표x,좌표y,로딩시점을 알려주는 이미지옵저버(this:자기자신 클래스(명),get으로 사용시 가변
            g.drawImage(img,0,0,getWidth(),getHeight(),this);
            g.setColor(Color.yellow);//색상설정
            g.setFont(new Font("Arial", Font.ITALIC,40));//폰트와 이탈릭,사이즈 설정
            g.drawString("Go Gator!!",10,150);//문구와 위치 설정
        }
    }

    public static void main(String[] args) {
        new GraphicsClipEx();
    }
}
//클리핑(Clipping)이란?
//클리핑 영역에서만 그래픽이 이루어지도록 하는 기능
//크리핑 영역 : 하나의 사각형 영역
//클리핑이 작동하는 그래픽 기능
//그리기,칠하기,이미지 그리기,문자열 출력 등에서 모드 클리핑  작동

//Graphics의 클리핑 메소드
//void setClip(int x, int y, int w, int h)
//그래픽 대상 컴포넌트의 (x,y)위치에서 wxh 의 사각형 영역을 클리핑 영역으로 지정
//void clipRect(int x,int y,int w,int h)
//기존 클리핑 영역과 지정된 사격형 영역((x,y)에서 wxh의 영역)의 교집합 영역을
//새로운 클리핑 영역으로 설정
//clipRect()이 계속 불리게 되면 클리핑 영역을 계속 줄어들게 됨

//ImageObserver는 이미지가 다그려졌을 떄, 통보를 받는 객체를 지정하는 매개변수
//이미지는 경우에 따라 디코딩 등으로 인해 시간이 오래 걸릴 수 있기 때문에,
//이미지 그리기가 완료되었는지 통보 받을 때 사용.
//보통의 경우 this를 주거나 null을 주어 통보를 받지 않을 수 있음
