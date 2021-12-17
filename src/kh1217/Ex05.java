package kh1217;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
//import java.awt.* 라고 쓰면 되긴되나 광범위하게 들어감

public class Ex05 extends JFrame {
        private static final long serialVersionUID = 1L;
        Ex05() {
            //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) : 창닫기(x버튼)를 눌러도
        //창만 닫힐 뿐 프로그램은 종료되지 않는데 아래 문을 추가하면
        //창을 닫을 때 프로그램도 종료된다.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //프로그램 창 외부의 제목
        setTitle("대박");
        //setLayout : JFrame창에 이미지를 배치하는 방식을 정의하는 메소드
        //FlowLayout() : 컴포넌트(JFrame에 배치되는 이미지 객체)좌에서 우로 배치함,
        //컴포넌트 배치를 위임함
        setLayout(new FlowLayout());
        //버튼 객체 생성, 버튼에 가위 바위 보 생성
        Button btn1 = new Button("가위");
        Button btn2 = new Button("바위");
        Button btn3 = new Button("보");
        //JFrame 객체에 버튼 추가
        add(btn1);
        add(btn2);
        add(btn3);
        //각 버튼의 배경색 지정
        btn1.setBackground(Color.CYAN);
        btn3.setForeground(Color.RED);
        //버튼 2번을 비활성화 시킴 setEnabled(false)
        btn2.setEnabled(false);
        setBackground(Color.PINK);
        setForeground(Color.BLUE);
        //JFrame의 사이즈 지정 (200,200) 픽셀 사이즈(픽셀은 알아서 찾아보시길)
        setSize(200,200);
        setVisible(true);}

    public static void main(String[] args) {
        new Ex05();
    }
}//네모칸이 아닌 한글이 나오게 만들기
