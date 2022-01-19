package kh0107;

import javax.swing.*;
import java.awt.*;

public class E09MyLabel extends JLabel {
    int barSize = 0;//초기사이즈 0
    int maxBarSize;//뚫지 않게 맥스값 줄 변수

    //maxBarSize 설정
    E09MyLabel(int maxBarSize){
        this.maxBarSize = maxBarSize;//필드변수에 대입
    }
    //키보드 클릭 이벤트 발생 시
    public void paintComponent(Graphics g){
        super.paintComponent(g);//부모도 그릴 수있게
        //마젠타 색으로
        g.setColor(Color.MAGENTA);
        //변화된 barSize를 입력해 바의 상태 변경
        int width = (int)(((double)(this.getWidth()))/maxBarSize * barSize);
        if (width == 0) return;//넒이가 0이되면 쓰레드종료
        g.fillRect(0,0,width,this.getHeight());//채워줄 사각형 설정
    }
    //키를 누르면 동작하는 메소드
    //synchronized 키워드가 쓰여 consume 메소드와 조화롭게 쓰인다(미 작성시 채워지기만 하고 오류)
    synchronized void fill() {
        if (barSize == maxBarSize){//최대 사이즈가 되면
            try {
                wait();//쓰레드를 일시정지 상태로 만듦
            }catch (InterruptedException e){
                return;//예외처리 미작성시 wait사용불가
            }
        }
        barSize++;//사이즈 업
        repaint();//업된 사이즈로 재표현
        //notify : 일시 정지 상태의 스레드 중 하나를 실행 대기 상태로 변화시킴
        notify();
    }
    //synchronized는 여러개의 쓰레드가 자원을 사용할 때 조화롭게 실행될 수 있도록 하는 키워드
    synchronized void consume(){
        //바의 사이즈를 지속적으로 깎는 메소드, run 메소드와 연동된다
        if (barSize ==0){//바사이즈가 0이되면
            try {
                wait();//쓰레드를 일시정지 상태로 만듦
            }catch (InterruptedException e){
                return;//예외처리
            }
        }
        barSize--;//사이즈 다운
        repaint();//다운된 사이즈로 재표현
        notify();//일시 정지 쓰레드 중 하나를 실행 대기 상태로 변화
    }
}
