package kh0104;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyCounter extends JFrame implements ActionListener{
    private JLabel[] labels;//배열형식 라벨
    private JButton button;//버튼형식 버튼
    private int[] numbers;//정수형 배열 넘버

    public MyCounter() {
        setSize(500,300);//프레임 사이즈 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창닫기시 프로세스 종료
        JPanel panel = new JPanel();//패널 객체생성
        panel.setLayout(null);//패널의 배치관리자 삭제

        labels = new JLabel[3];//labels에 크기3라벨배열대입
        numbers = new int[3];//numbers에 크기3정수배열대입

        for (int i =0; i<3; i++){//슬롯머신 숫자 생성기!
            labels[i] = new JLabel("" + numbers[i]);//라벨에 객체numbers[i]대입 ""은 정수형만 넣을 수 없기 때문
            labels[i].setFont(new Font("Serif",Font.BOLD | Font.ITALIC,100));//폰트설정
            labels[i].setSize(100,100);//사이즈 설정
            labels[i].setLocation(100+100*i,20);//위치설정
            panel.add(labels[i]);//패널에 라벨 추가
        }
        button = new JButton("슬롯");//슬롯이 적힌 버튼 객체
        button.setSize(250,50);//버튼 사이즈
        button.setLocation(100,150);//버튼 위치
        panel.add(button);//패널에 버튼 추가
        button.addActionListener(this);//버튼에 기능추가

        add(panel);//프레임에 패널 추가
        setTitle("My Game");//프레임 제목설정
        setVisible(true);//보이게 설정
    }
    @Override
    public void actionPerformed(ActionEvent event){//재정의
        for (int i=0; i<3; i++){//버튼누를시 나올 랜덤숫자 생성 반복
            numbers[i] = (int) (Math.random() * 10);//넘버스에 들어갈 랜덤숫자(정수형캐스팅)
            labels[i].setText("" + numbers[i]);//labels[i]에 "" 랜덤숫자 셋
        }
    }
}

public class SlotMachine {
    public static void main(String[] args) {
        new MyCounter();
    }
}
