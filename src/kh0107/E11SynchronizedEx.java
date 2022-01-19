package kh0107;

public class E11SynchronizedEx {
    public static void main(String[] args) {
        SharedPrinter p = new SharedPrinter(); //공유 데이터 생성
        //영문 텍스트와
        String[] engText = {"Wise men say,",
                "only fools rush in",
                "But I can't help",
                "falling in love with you",
                "Shall I stay?",
                "Would it be a sin?",
                "If I can't help,",
                "falling in love with you"};
        //한글 텍스트 배열을 생성하고
        String [] korText = {"동해물과 백두산이 마르고 닳도록, ",
                "하느님이 보우하사 우리나라 만세","무궁화 삼천리 화려강산, ",
                "대한사람 대한으로 길이 보전하세","남산위에 저 소나무, 철갑을 두른 듯",
                "바람서리 불변함은 우리 기상일세.",
                "무궁화 삼천리 화려강산, ",
                "대한사람 대한으로 길이 보전하세"};
        //WorkerThread 객체를 쓰레드 객체로 만든 후 SharedPrinter 객체를 인수로 전송함
        Thread th1 = new WorkerThread(p, engText);//영문 출력 스레드
        Thread th2 = new WorkerThread(p, korText);//국문 출력 스레드
        //실행시킴
        th1.start();
        th2.start();
    }
}
class SharedPrinter {//두 WorkerThread스레드에 의해 동시 접근되는 공유 프린터
    //synchronized를 생략하면
    //한글과 영어가 한 줄에 섞여 출력되는 경우 발생
    //synchronized 키워드로 인해 영문이 먼저 실행되고 한글은 나중에 실행됨
    synchronized void print(String text){//synchronized로 잘 출력됨
        for (int i = 0;i<text.length();i++)
            System.out.print(text.charAt(i));
        System.out.println();
    }
}
class WorkerThread extends Thread{//WorkerThread클래스 Thread 클래스 상속
    SharedPrinter p;//공유 프린터 주소
    String[] text;
    WorkerThread(SharedPrinter p,String [] text){
        this.p = p;
        this.text = text;
    }
    public void run(){//스레드는 반복적으로 공유 프린터에 10번 접근 text[] 출력
        for (int i=0;i<text.length;i++)
            p.print(text[i]);//공유 프린터에 출력
    }
}
