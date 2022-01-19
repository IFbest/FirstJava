package kh0106;

class Blue_02 implements Runnable{
    public void run(){
        while (true){
            System.out.println("청기 올려!!");
        }
    }
}
class White_02 implements Runnable{
    public void run(){
        while (true){
            System.out.println("백기올려!!");
        }
    }
}
public class FlagTest3 {
    public static void main(String[] args) {
        Thread t = new Thread(new Blue_02());
        t.start();
        Thread t2 = new Thread(new White_02());
        t2.start();
    }
}
