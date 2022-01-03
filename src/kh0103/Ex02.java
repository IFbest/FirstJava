package kh0103;

import javax.swing.*;
import java.awt.*;

public class Ex02 extends JFrame {
	public Ex02() {
	//이름과 JFrame 창 닫기 시 프로그램이 종료되는 설정 입력
	setTitle("ContentPane과 JFrame");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//컨테이너 객체를 생성하고
	Container contentPane = getContentPane();
	//컨테이너 객체의 색상과, 컨테이너 내부 객체의 배열 방식 지정
	contentPane.setBackground(Color.ORANGE);
	contentPane.setLayout(new FlowLayout());
	
	//JFrame 객체에 JButton 객체를 추가한다
	contentPane.add(new JButton("OK"));
	contentPane.add(new JButton("Cancel"));
	contentPane.add(new JButton("Ignore"));
	
	//JFrame 객체의 크기 및 전시 여부를 설정
	setSize(300,150);
	setVisible(true);
	}
	public static void main(String[] args) {
		//이전과 동일한 동작
		new Ex02();
	}
}
