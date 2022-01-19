package kh0107;

import javax.swing.*;
import java.awt.*;

class FlickeringLabel extends JLabel implements Runnable{
    private long delay;
    //객체를 생성할 때 활용된 생성자는
    public FlickeringLabel(String text, long delay){
        //JLabel 생성자를 활용해 문구를 삽입하고
        super(text);
        //입력받은 값을 delay 필드에 저장하고
        this.delay = delay;
        setOpaque(true);//Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
        //Runnable 인터페이스를 활용해 쓰레드를 생성한 뒤
        //this는 현재 클래스 객체를 의미함(FlickeringLabel)
        Thread th = new Thread(this);
        //쓰레드를 실행함
        th.start();
    }
    @Override
    //start 메소드를 통해 실행
    public void run() {
        //n은 스위치 역할
        int n = 0;
        //while + if-else 문을 활용해 깜빡이느 모션 구현
        while (true){
            if (n == 0)
                setBackground(Color.YELLOW);
            else
                setBackground(Color.GREEN);
            if (n == 0)
                n = 1;
            else
                n = 0;
            try {
                //sleeep 메소드를 통해 delay 시간 동안 해당 스레드를 정지시키는 과정을 수행해
                //깜빡이는 모션 구현
                Thread.sleep(delay);
            }catch (InterruptedException e){
                return;
            }
        }
    }
}
// 메인 클래스가 JFrame
public class E01FlickeringLabelEx extends JFrame{
    public E01FlickeringLabelEx() {
        //생성자에서 JFrame 객체의 기본 설정을 하고
        setTitle("EFlickeringLabelEx 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        //JLabel 객체를 상속받는 FlickeringLabel 클래스 객체를 생성함
        FlickeringLabel flabel = new FlickeringLabel("깜빡", 500);
        //이 객체는 그냥 JLabel 객체 변화 없음
        JLabel label = new JLabel("안깜빡");

        FlickeringLabel flabel2 = new FlickeringLabel("여기도 깜빡", 300);

        //생성된 객체들을 JFrame 안에 입력
        c.add(flabel);
        c.add(label);
        c.add(flabel2);

        setSize(300, 150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new E01FlickeringLabelEx();
    }
}
