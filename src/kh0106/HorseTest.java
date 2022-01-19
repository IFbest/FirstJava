package kh0106;

class Horse implements Runnable{
    private int horse_num;
    public Horse(int horse_num){
        this.horse_num = horse_num;
    }
    public void run()  {
        long sleepTime = (long) (Math.random()*500);
        System.out.println(horse_num + "번 말이 " + sleepTime + "만큼 sleep ..");
        try {
            Thread.sleep(sleepTime);
        }catch (Exception e){
            e.printStackTrace( );
        }
    }
}
public class HorseTest {
    public static void main(String[] args) {
//        int [] temp = {1,2,3,4,5,6,7,8,9};
//
//        for (int i=0;i< temp.length;i++){
//            Thread t = new Thread(new Horse(temp[i]));
//            //t.start();
//        }
//        for (int i:temp){
//            Thread t = new Thread();
//
//        }
        Thread t1 = new Thread(new Horse(1));
        Thread t2 = new Thread(new Horse(2));
        Thread t3 = new Thread(new Horse(3));
        Thread t4 = new Thread(new Horse(4));
        Thread t5 = new Thread(new Horse(5));
        Thread t6 = new Thread(new Horse(6));
        Thread t7 = new Thread(new Horse(7));
        Thread t8 = new Thread(new Horse(8));
        Thread t9 = new Thread(new Horse(9));//일반 포문
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();//확장 포문
        System.out.println("main( ) 종료...");
    }
}