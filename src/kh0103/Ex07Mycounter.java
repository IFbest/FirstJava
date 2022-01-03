package kh0103;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//클래스를 상속받고 인터페이스도 상속받는데, 인터페이스를 활용하면 자바에서도 간적적인 다중상속을 받을 수 있다
public class Ex07Mycounter extends JFrame implements ActionListener {
	private JLabel label, label1;
	private JButton button;
	private int count = 0;
	public Ex07Mycounter() {
		//JPanel : JFrame 보다 작고 JLabel  보다 큰 정도의 컨테이너 클래스이다.
		JPanel panel = new JPanel();
		//JLabel : 가장 작은 형태의 스윙 컨테이너 클래스
		//JPanel 클래스에 속하게 된다
		label = new JLabel("Counter");
		//JPanel 객체에 추가된다
		panel.add(label);
		//또 다른 JLabel 객체를 생성하고
		label1 = new JLabel("" + count);
		//해당 객체의 폰트를 설정한 후
		label1.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 100));
		//JPanel 객체에 추가한다
		panel.add(label1);
		//Button 객체도 생성한 후;
		button = new JButton("카운터 증가");
		//패널에 추가한다
		panel.add(button);
		//ActionListener : 버튼 클릭시 동작하는 이벤트 메소드, 버튼 객체에 추가한다.
		//해당 동작을 구현하기 위해서는 ActionListener 인터페이스를 상속받아 구현해야 한다
		button.addActionListener(this);
		add(panel);
		setSize(300,200);
		setTitle("My Counter");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	//위의 addActionListener 메소드에 의해 클릭 이벤트가 실행되면 아래 메소드가 실행된다
	public void actionPerformed(ActionEvent e) {	
		//전송받은 이벤트 객체를 JButton 객체로 형변환 한 후 
		JButton b = (JButton)e.getSource();
		count ++;
		b.setText("" + count);

//		count++;
//		label1.setText("" + count);
		
	}
	public static void main(String[] args) {
		//이번에도 메인 메소드는 생성자만 실행시킨다.
		new Ex07Mycounter();
	}
}
