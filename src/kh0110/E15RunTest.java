package kh0110;

class B1 implements Runnable{
    public void run() {
        for (int i = 0;i<=100;i++){
            System.out.print(Thread.currentThread().getName() + "대박 \t");
            //스레드 이름 얻어오기
            if (i % 10 == 0){//i를 10으로 나누어서 0일 때 10의 배수일 때
                System.out.println(i + " ");
                //100회 출력하면 활성화되는 쓰레드를 교체함
                Thread.yield();
            }
        }
    }
}
public class E15RunTest {
    public static void main(String[] args) {
        B1 b1 = new B1();
        B1 b2 = new B1();
        Thread th1 = new Thread(b1,"첫번째");
        Thread th2 = new Thread(b2,"두번쨰");
        th1.start();
        th2.start();
    }
}
