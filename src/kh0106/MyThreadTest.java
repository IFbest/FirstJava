package kh0106;

class MyThread extends Thread{
    public void run() {
        for (int i=10;i>=0;i--)
            System.out.print(i+" ");
    }
}
//Thread클래스는 java.lang패키지 안에 들어 있어 import할 필요없음
//MyThread클래스는 하나의 메서드 run()만을 가지고 있음
//run()은 스레드가 시작하면 자바런타임 시스템에 의해 호출
//스레드가 실행하는 모든 작업은 run()메서드안에 있어야 함
//현재는 단순히 10~0까지 출력
public class MyThreadTest {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
    }
}//10 9 8 7 6 5 4 3 2 1 0
//스레드를 실행시키면 Thread에서 파생된 클래스 Thread의 인스턴스를 실행한 후 start()호출
//Thread의 타임변수 t가 선언, MyThread()객체 생성
//start()호출해야만 스레드 실행됨
