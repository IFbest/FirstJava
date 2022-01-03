package kh0103;

import javax.swing.JFrame;

public class Ex01 extends JFrame {
	public Ex01() {
		//JFrame 객체를 컨틀롤하는 기본 예제이다
		setTitle("300x300 스윙 프레임 만들기");
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		//해당 부분을 추가해도 안해도 동작에는 문제가 없다
		//Ex01 frame = new Ex01();
		new Ex01();
	}

}
