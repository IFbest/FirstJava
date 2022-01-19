package kh0106;

public class FlagTest {
    public static void main(String[] args) {
        White_01 white = new White_01();
        Blue_01 blue = new Blue_01();
        white.start();
        blue.start();
    }
}

class White_01 extends Thread{
    public void run() {
        while (true){//무한실행
            System.out.println("백기올려!");
        }
    }
}

class Blue_01 extends Thread{
    public void run() {
        while (true){
            System.out.println("청기 올려");
        }
    }
}