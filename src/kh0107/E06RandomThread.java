package kh0107;

import javax.swing.*;
import java.awt.*;

//해당 객체는 Thread 클래스를 상속받는 쓰레드 객체
public class E06RandomThread extends Thread{
    private Container contentPane;
    private boolean flag = false;//스레드의 종료 명령을 표시하는 플래그
    public E06RandomThread(Container contentPane){
        this.contentPane = contentPane;
    }
    //쓰레드의 진행 여부를 판단하는 flag 변수를 true로 바꿔 종료시킴
    void finish() {
        flag = true;
    }
    @Override
    //start 객체로 인해 실행되는 메소드
    public void run() {
        //while문으로
        while (true){
            //contentPane 객체의 크기 정보를 활용해 범위 내의 랜덤 좌표 생성
            int x = (int)(Math.random() * contentPane.getWidth());
            int y = (int)(Math.random() * contentPane.getHeight());
            //랜덤 좌표에 Java 글자를 가진 jLabel 객체 생성
            JLabel label = new JLabel("Java");
            label.setSize(80,30);
            label.setLocation(x,y);//위의 랜덤을 통해 임의위치 지정
            //contentPane 객체에 추가하고
            contentPane.add(label);
            //화면 갱신
            contentPane.repaint();
            try {
                //쓰레드가 0.3초 간격으로 실행되도록 함
                Thread.sleep(300);//0.3초
                //마우스 클릭 이벤트 발생 시
                if (flag == true){
                    //contentPane 객체의 모든 내용을 삭제하고
                    contentPane.removeAll();
                    //finish라는 문구를 가진 JLabel 객체를 생성해
                    label = new JLabel("finish");
                    label.setSize(80,30);
                    label.setLocation(100,100);
                    label.setForeground(Color.RED);
                    //contentPane 객체에 추가하고
                    contentPane.add(label);
                    contentPane.repaint();//갱신
                    return;//후 스레드 종료
                }
            }catch (InterruptedException e){
                return;
            }
        }
    }
}
