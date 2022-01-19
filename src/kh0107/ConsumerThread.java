package kh0107;

public class ConsumerThread extends Thread{
    E09MyLabel bar;

    ConsumerThread(E09MyLabel bar){
        this.bar = bar;//전역변수에 대입
    }
    //쓰레드 시작 , consume메소드와 연동
    public void run() {
        while (true){
            try {
                //0.2초 마다 쓰레드가
                sleep(200);
                //counsume 메소드를 실행시킴
                bar.consume();//09MyLabel bar에 있는 메소드와 연결
            }catch (InterruptedException e){
                return;
            }
        }
    }
}
