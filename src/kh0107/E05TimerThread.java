package kh0107;

public class E05TimerThread extends Thread{
    private int n = 0 ;
    private boolean flag = false;
    //finish 메소드가 실행되면 flag = true로 변해
    public void finish() {
        flag = true;
    }
    @Override
    public void run() {
        while (true){
            System.out.println(n);
            n++;
            try {
                sleep(1000);
                //if 문에서 종료됨
                if (flag == true)
                    return;//종료
            }catch (InterruptedException e){
                return;
            }
        }
    }

    public static void main(String[] args) {
        //쓰레드 객체 생성
        E05TimerThread th = new E05TimerThread();
        //쓰레드 실행
        th.start();
        //하자마자 finish 메소드를 활용해 쓰레드 종료
        th.finish();
    }
}
