package kh0110;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + " : " + (isDaemon()? "데몬쓰레드": "일반쓰레드"));
        for (int i =0;i<6;i++){
            System.out.println(getName() + " : " + i + "초");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){}
        }//Thread 데몬 설정  (Thread 클래스의 인스턴스메서드)
    }//주의. setDeamon()dms 반드시 start() 전에 호출
}

public class ThreadProperties_3_3 {
    public static void main(String[] args) {
        //#. 일반쓰레드
        //Thread thread1 = new MyThread();
        //thread1.setDaemon(false);//일반쓰레드로 설정, true인 경우 Daemon Thread
        //thread1.setName("thread1");
        //thread1.start();
        //일반쓰레드는 다른쓰레드 종료여부와 상관없이 자신의 쓰레드가 종료되어야 프로세스 종료
        //#2. 데몬쓰레드
        Thread thread2 = new MyThread();
        thread2.setDaemon(true);//데몬쓰레드로 설정
        thread2.setName("thread2");
        thread2.start();
        //데몬쓰레드는 일반쓰레드(사용자쓰레드)가 모두 종료되면 작업이 완료되지 않았어도 함께 종료
        //#3. 3.5초 후 main Thread 종료
        try {
            Thread.sleep(3500);
        }catch (InterruptedException e){}
        System.out.println("main Thread 종료");
    }
}
