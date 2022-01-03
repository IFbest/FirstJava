package kh0103;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ex03 extends JFrame {
	//마우스 클릭에 따른 JLabel 객체 조정
	//JLabel  객체 생성 후 문자 입력
	//JPanel 객체에는 문자열을 입력할 수 없는 것 같다
	private JLabel la = new JLabel();
	public Ex03() {
		//JFrame 설정
		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		//JFrame 객체에 마우스 이벤트 설정
		c.addMouseListener(new MyMouseListener());
		//setLayout 메소드에 null을 입력해 내부 요소들의 정렬 방식을 지정하지 않음
		c.setLayout(null);//배치관리자 제거
		la.setLayout(new FlowLayout());
		la.add(new JLabel("Follow"));
		//이후 JLabel  객체의 정보를 지정하고
		la.setSize(50,20);
		la.setLocation(30,30);
		//JFrame 객체에 입력
		c.add(la);
		
		setSize(250,250);
		setVisible(true);
	}
	//내부 클래스인 마우스 이벤트 관련 클래스를 생성한 후(Override)
	class MyMouseListener implements MouseListener {
		int x,y;
		// 마우스 버튼을 누르고 있을 때의 동작 정의
		public void mousePressed(MouseEvent e) {
		}
		// 마우스 버튼을 눌렀다가 떼었을 때의 동작 정의
		public void mouseReleased(MouseEvent e) {
		}
		// 마우스 버튼을 클릭했을 때의 동작 정의
		public void mouseClicked(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			la.setLocation(x,y);
		}
		// 마우스 포인터가 컨테이너/컴포넌트 영역 안에 있을 때의 동작 정의
		public void mouseEntered(MouseEvent e) {
		}
		// 마우스 포인터가 컨테이너/컴포넌트 영역 밖에 있을 때의 동작 정의
		public void mouseExited(MouseEvent e) {}
	}
	//생성자 실행
	public static void main(String[] args) {
		new Ex03();
	}
}
//배치관리자가 없는 컨테이너란?
//응용프로그램에서 컴포넌트의 절대 크기와 절대 위치 결정
//용도
//컴퍼터넌트의 크기나 위치를 개발자 임의로 결정하고자 하는 경우
//게임 프로그램과 같이 시간이나 마우스/키보드의 입력에 따라
//컴퍼넌트들의 위치와 크기가 수시로 변하는 경우
//여러 컴포넌트들이 서로 겹쳐 출력하고자 하는 경우
//컨테이너의 배치 관리자 제거 방법
//container.setLayout(null);