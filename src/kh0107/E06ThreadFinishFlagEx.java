package kh0107;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class E06ThreadFinishFlagEx extends JFrame {
    //E06RandomThread 객체 생성
    private E06RandomThread th;

    public E06ThreadFinishFlagEx() {
        //JFrame 초기 설정
        setTitle("EThreadFinishFlagEx 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        //JFrame의 배치조건 없음
        c.setLayout(null);

        //마우스 이벤트 생성
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                //마우스 누름 이벤트 발생 시 E06RandomThread 객체의 동작이 종료됨
                //클릭이 아닌 누름 만으로도 종료되며 클릭은 mouseClicked 메소드를 사용한다
                th.finish();
            }
        });
        setSize(300, 200);
        setVisible(true);

        //E06RandomThread객체에 컨텐츠팬 정보를 넘기고 생성자를 실행시킴
        th = new E06RandomThread(c);
        //스레드 시작
        th.start();
    }
    //E06ThreadFinishFlagEx 메소드 실행
    public static void main(String[] args) {
        new E06ThreadFinishFlagEx();
    }
}
