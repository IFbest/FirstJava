package kh0104;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class E01CheckboxPanel extends JPanel implements ItemListener {
    //체크박스 객체 생성
    JCheckBox[] buttons = new JCheckBox[3];
    //이름 문자열 배열 생성
    String[] china = {"jajang", "jjambbong", "tangsuyuk"};
    //이미지 파일 개수에 맞춰 JLabel 객체도 3개 생성
    JLabel[] pictureLabel = new JLabel[3];
    //imageIcon 객체도 3개 생성
    ImageIcon[] icon = new ImageIcon[3];

    public E01CheckboxPanel() {
        //JPanel 객체를 4등분해 표현
        super(new GridLayout(0,4));

        for (int i=0;i<3;i++){
            //체크박스에 이름 입력
            buttons[i] = new JCheckBox(china[i]);
            //체크박스에 아이템 리스너 등록
            buttons[i].addItemListener(this);
            pictureLabel[i] = new JLabel(china[i] + ".png");
            icon[i] = new ImageIcon(china[i] + ".png");
        }//체크박스 생성

        //체크박스 객체를 JPanel 첫 번째 열에 저장
        JPanel checkPanel = new JPanel(new GridLayout(0,1));
        for (int i=0;i<3;i++)
            checkPanel.add(buttons[i]);//체크박스를 하나로 묶는다
        //add를 통해 JPanel 객체에 입력
        add(checkPanel);
        add(pictureLabel[0]);
        add(pictureLabel[1]);
        add(pictureLabel[2]);
    }
    //체크박스의 아이템 이벤트를 처리한다.
    public void itemStateChanged(ItemEvent e){//체크박스 선태 상태가 변하는 경우 호출
        ImageIcon[] image = null;
        //이벤트 객체로 부터 체크된 체크박스 객체를 획득
        Object source = e.getItemSelectable();
        for (int i=0;i<3;i++){
            if (source == buttons[i]){
                //해당 객체가 선택되지 않았다면
                if (e.getStateChange() == ItemEvent.DESELECTED)
                    pictureLabel[i].setIcon(null);
                else
                    pictureLabel[i].setIcon(icon[i]);
            }//DESELECTED: 체크가 헤제되었는지를 검사
        }//체크박스가 체크된 경우 ItemEvent.SELECTED를
    }//해제된 경우 ItemEvent.DESELECTED를 리턴

    public static void main(String[] args) {
        //JFrame 객체 생성
        JFrame frame = new JFrame("CheckBoxDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //E01CheckBoxPanel 객체 생성하고 생성자 실행
        E01CheckboxPanel panel = new E01CheckboxPanel();
        //E01CheckboxPanel 객체 표시 여부 설정,true나 false나 결과는 동일한
        panel.setOpaque(true);//그림을 표시하게 설정,불투명
        //setOpaque 메소드를 추가해야 변경사항이 적용된다
        //JComponent는 Default로 Opaque 값이 false(투명)로 되어있기 때문
        //E01CheckboxPanel 생성자 연산 후 JFrame 에 추가
        frame.add(panel); frame.setSize(500,200); frame.setVisible(true);
    }
}//자바에서 그래픽 좌표계 Y좌표는 아래로 갈수록 증가합니다.
