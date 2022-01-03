package kh0103;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex04 extends JFrame implements ActionListener {
    //ActionListener 인터페이스를 구현하므로 마우스 이벤트를 수행할 것이라는 느낌을 받을 수 있음
    //두 객체 변수 모두 외부 이용이 불가능하도록 private 롤 보호됨
    //JTextField : 테그슽가 입력되는 빈 공간
    private JTextField txt;
    //JPanel 객체도 생성
    private JPanel panel;

    public Ex04() {
        //JTextField의 열의 개수를 설정
        txt = new JTextField(20);
        //BorderLayout.NORTH : txt 객체를 북쪽으로 해서 JFrmae 객체에 추가함
        add(txt, BorderLayout.NORTH);
        //JPanel 객체를 생성하고
        panel = new JPanel();
        //GridLayout : 입력한 행/열로 공간을 표현함
        //본 예제는 생성된 JPanel 객체가 많으므로 열의 개수는 의미가 적다
        panel.setLayout(new GridLayout(3,3));
        //JPanel 객체를 JFrame 에 입력하면서
        //BorderLayout.CENTER : 위치는 중앙에 맞춤
        add(panel, BorderLayout.CENTER);

        //JButton 객체를 for문을 통해 생성하고
        for (int i =0;i<20;i++){
            //버튼에 입력될 숫자를 for문을 활용해 지정한 후
            JButton btn = new JButton("" + i);
            //addActionListener 를 활용해 클릭 이벤트를 추가한다
            btn.addActionListener(this);
            //모든 버튼 객체의 크기를 지정한 후
            btn.setPreferredSize(new Dimension(100,100));
            //JPanel 객체에 모두 입력한다
            panel.add(btn);
        }
        //setPreferredSize(new Dimension(x,y));
        //Dimension이라는 객체를 인자로 받아 컴포넌트의 크기를 결정해주는 메소드
        //(BorderLayout을 사용중이면 영향 줄 수 없음)
        //layou 관리자에서는 setPerferredSize()를 써줘야 한다
        //pack();을 통해 컴포넌트의 사이즈를 딱 맞게 맞춰준다.
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    @Override
    //addActionListener 메소드에 의해 클릭 이벤트가 발생하면 동작하는 메소드
    public void actionPerformed(ActionEvent e){
        //전송된 객체(JButton 객체)의 문자 정보를 획득한 후 (getActionCommand 메소드 활용)
        String actionCommand = e.getActionCommand();
        //JTextField 객체인 txt에 값을 입력함
        txt.setText(txt.getText() + actionCommand);
        //문자를 텍스트필드에 넣음
    }//이벤트 발생하면 호출
    //메인 메소드는 시작일 뿐 하는 일이 없음
    public static void main(String[] args) {
        new Ex04();
    }
}
