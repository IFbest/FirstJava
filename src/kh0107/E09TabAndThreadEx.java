package kh0107;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class E09TabAndThreadEx extends JFrame {
    //E09MyLabel 객체 생성
    E09MyLabel bar = new E09MyLabel(100);
    //JFrame 객체 생성
    E09TabAndThreadEx(String title){
        super(title);//객체생성시 문자열로 제목을 받겠다
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창 종료시 프로세스도 종료
        Container c = getContentPane();//컨테이너에 컨텐트팬 추가
        c.setLayout(null);//기본 배열 삭제
        //E09MyLabel 객체 기본 설정
        bar.setBackground(Color.ORANGE);//배경화면 오렌지
        bar.setOpaque(true);//작성해야 배경화면 색바뀜
        bar.setLocation(20,50);//라벨위치설정
        bar.setSize(300,20);//라벨사이즈설정
        //후 JFrame 객체에 추가
        c.add(bar);//컨테이너에 라벨추가
        //키를 누르면 작동하는 이벤트(특정키 없음 다 됨)
        c.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                bar.fill();//라벨이 점점 사이즈가 증가되게 만듦
            }
        });
        setSize(350,200);//프레임사이즈
        setVisible(true);//보이게 설정
        c.requestFocus();//키이벤트를 작동하기 위해선 포커스를 줘야함
        //ConsumerThread쓰레드 객체를 생성한 후 JLabel 객체인 bar을 인수로 전달
        ConsumerThread th = new ConsumerThread(bar);
        //하고 쓰레드 시작
        th.start();
    }

    public static void main(String[] args) {
        new E09TabAndThreadEx("보기만 해");//제목포함 생성자
    }
}
