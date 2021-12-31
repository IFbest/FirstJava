package kh1231;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ex02 extends JFrame {
    public Ex02() {
        // JFrame 제목
        setTitle("Action 이벤트 리스너 예제");
        // JFrame 창 종료 시 프로그램도 같이 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Container c = getContentPane() : 최외곽 컨테이너를 표현하는 객체
        // 이 c 객체에 다른 컨테이너(panel이나 labe 객체)를 추가하는 방식
        // Container 클래스는 JFrame 클래스의 조상 클래스가 된다
        Container c = getContentPane();
        // setLayout : 컴포넌트가 배치되는 방식
        // FlowLayout : 왼쪽에서 오른쪽, 위에서 아래로 배치됨
        c.setLayout(new FlowLayout());
        // JButton : 버튼객체, 기본 생성자를 통해 이름을 Action 으로 지정
        JButton btn = new JButton("Action");
        // addActionListener : 이벤트를 추가함
        // MyActionListener 클래스의 생성자를 이벤트로 추가함
        btn.addActionListener(new MyActionListener());
        // 버튼 객체를 컨테이너에 추가함
        c.add(btn);
        //컨테이너 (JFrame 객체)의 크기를 결정하고
        setSize(350, 150);
        // setVisible : 초기 전시여부를 결정함
        setVisible(true);

    }
    public static void main(String[] args) {
    	new Ex02();//생성자 초기화
    }
}
    // ActionListener 인터페이스를 상속(구현)함
    class MyActionListener implements ActionListener {
        // 이벤트 발생 시 전달받은 ActionEvent 객체 e는
        public void actionPerformed(ActionEvent e) {
            //JButton 객체로 형변환 되며
            JButton b = (JButton) e.getSource();
            //해당 객체의 문자값이 Action이면
            if (b.getText().equals("Action"))
                // 문자를 액션으로 바꾸며
                b.setText("액션");
            else
                //아닐 경우 문자를 Action으로 한다
                b.setText("Action");
        }
    }
