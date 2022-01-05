package kh0104;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class E03ImageLabelTest extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel label;
    private JButton button;

    public E03ImageLabelTest(){
        setTitle("이미지 레이블");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,250);

        panel = new JPanel();
        label = new JLabel("이미지를 보려면 아래 버튼을 눌러주세요");
        button = new JButton("이미지 레이블");
        ImageIcon icon = new ImageIcon("icon.png");
        button.setIcon(icon);
        //이미지 아이콘 객체생성 및 버튼에 이미지 객체 생성
        button.addActionListener(this);
        //JPanel 객체에 요소들을 추가
        panel.add(label);
        panel.add(button);
        //패널에 레이블과 버튼 추가
        //JPanel 객체도 JFrame 에 추가
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        E03ImageLabelTest dog = new E03ImageLabelTest();
    }
    public void actionPerformed(ActionEvent e){
        ImageIcon dog = new ImageIcon("dog.jpg");
        //버튼을 클릭하면 dog이미지가 출력되고
        label.setIcon(dog);
        //JLabel 객체에 지정된 문자열이 null로 변함
        label.setText(null);
    }
}
