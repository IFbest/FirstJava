package kh0110;

class Th1 extends Thread{
    public void run() {
        for (int i=0;i<10;i++){
            System.out.print("월요일대박");
            if(i == 3) Thread.yield();
        }
    }
}
class Th2 extends Thread{
    public void run() {
        Thread.yield();
        for (int i=0;i<10;i++){
            System.out.print(" 대박");
            /*if (i==7)*/ Thread.yield();
        }
    }
}
public class E14ThreadTest {
    public static void main(String[] args) {
        Th1 th1 = new Th1();
        Th2 th2 = new Th2();
        //쓰레드가 실행된 후
        th1.start();
        th2.start();
        //이 for문은 없어도 동작에 이상이 없다
        for (int i=0;i<20;i++){
            try {
//join 메소드를 실행하면 해당 쓰레드가 실행 완료되고 난 후 다음 쓰레드를 실행한다
//즉 main 쓰레드를 정지시킨다
//본 예제에서는 쓰레드가 영향을 끼치지 않는데
//start와 join을 순서대로 쓰면 효과를 볼 수 있다
                th1.join();
                th2.join();
            }catch (InterruptedException e){
                System.out.print("error");
            }
        }
    }
}
