package kh0106;

import javax.swing.*;
import java.awt.*;

class TimeRunnable implements Runnable{
    private JLabel timerLabel;

    public TimeRunnable(JLabel timerLabel){
        this.timerLabel = timerLabel;
    }
    @Override
    public void run(){
        int n = 0;
        while (true){
            timerLabel.setText(Integer.toString(n));
            n++;
            try {
                Thread.sleep(1000);//1초에 1번씩 올라가도록 슬립
            }catch (InterruptedException e){
                return;
            }
        }
    }
}
public class E12RunnableTimerEx extends JFrame {
    public E12RunnableTimerEx() {
        setTitle("Runnable을 구현한 타이머 스레드 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
        c.add(timerLabel);

        TimeRunnable runnable = new TimeRunnable(timerLabel);
        //Runnable 인터페이스를 상속 받은 클래스를 쓰레드 객체로 만든 것
        Thread th = new Thread(runnable);
        setSize(250, 150);
        setVisible(true);
        th.start();
    }
    public static void main(String[] args) {
        new E12RunnableTimerEx();
    }
}
