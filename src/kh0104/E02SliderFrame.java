package kh0104;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class E02SliderFrame extends JFrame implements ChangeListener {
    static final int INIT_VALUE = 15;//초기값으로 15사이즈정도
    //버튼과 슬라이드 객체 생성
    private JButton buttonOK;
    private JSlider slider;
    private JButton button;
    //슬라이더는 사용자가 특정한 범위 안에서 하나의 값을 선택할 수 있는 컴포넌트이다.
    public E02SliderFrame(){
        //패널과 관련된 기본 설정
        JPanel panel;
        setTitle("Slider Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        //슬라이더를 사용하는 JLabel 객체 생성
        JLabel label = new JLabel("Move the slider", JLabel.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        //멘트가 써진 JLabel 객체를 JPanel 객체에 추가
        panel.add(label);
        //슬라이더 객체를 만들고
        slider = new JSlider(0,30,INIT_VALUE/*=15*/);
        //0~30단계까지 초기값15
        slider.setMajorTickSpacing(10);//큰 눈금 간격
        slider.setMinorTickSpacing(1);//작은 눈금 간격
        slider.setPaintTicks(true);//눈금 표시
        slider.setPaintLabels(true);//값을 레이블에 표시
        slider.addChangeListener(this);//이벤트 리스너를 붙인다.
        //JPanel에 추가
        panel.add(slider);

        //JButton 객체를 생성하고
        button = new JButton("");
        //이미지 객체를
        ImageIcon icon = new ImageIcon("dogg.gif");
        //버튼 객체에 입력함
        button.setIcon(icon);
        //버튼의 초기 크기를 설정(그림 크기가 아닌 버튼의 크기)
        button.setSize(INIT_VALUE * 10, INIT_VALUE * 10);
        //버튼을 JPanel 객체에 추가함
        panel.add(button);
        add(panel);
        //버튼에 setIcon()을 이용하여 이미지 설정
        setSize(300,300);
        setVisible(true);
    }
    public void stateChanged(ChangeEvent e){//컴포넌트의 상태가 변할 때 호출
        //JSlider 이라는 클래스도 있다
        //슬라이드 기능을 활용할 수 있는 클래스
        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting()){
            int value = (int) source.getValue();
            button.setSize(value *10 , value *10);
        }//슬라이더의 상태가 변경되면 호출, 슬라이더가 움직일 때를 말한다.
    }//버튼 크기를 변경


    public static void main(String[] args) {
        new E02SliderFrame();
    }
}