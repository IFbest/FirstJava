package kh1231;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex03 extends JFrame {
    //해당 부분의 내용은 이전 02번 예제와 동일하다
    public Ex03() {
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
    // 이게 바로 내부 클래스다
    // 외부 클래스인 E02와 함께 사용되어 코드를 간결하게 유지할 수 있다
    class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JButton b = (JButton)e.getSource();
            if (b.getText().equals("Action"))
                b.setText("액션");
            else
                b.setText("Action");
            //IneerClassListener의 멤버나 JFrame의 멤버를 호출할 수 있음
            Ex03.this.setTitle(b.getText());
            //프레임 타이틀에 버튼 문자열을 출력한다 이 부분만 다르다
        }
            }
  //이번에도 메인 클래스는 메인 클래스의 생성자만 호출
    public static void main(String[] args) {
        new Ex03();
    }
}