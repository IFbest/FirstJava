package kh0106;

class MyHorse implements Runnable{
    private int horse_num;
    private static int rankCount = 1;

    public MyHorse(int horse_num){
        this.horse_num = horse_num;
    }
    public void run()  {
        int [] mm = {100,200,300,400,500,600,700,800,900,1000};
        long sleepTime = (long) (Math.random()*500);
        int i = 0;
        while (true){//반복작업
            try {//슬립 사용을 위해 try catch문사용
                Thread.sleep(sleepTime);
                System.out.println(horse_num + "번 말이 " + mm[i] + "미터 도착");//배열사용900까지출력됨
                i++;
                Thread.yield();
                if (mm[i] == 1000){//9번째의 값 1000이 되면 도착을 감지
                    int rank = MyHorse.rankCount++;//순위를 매기기 위한 후위연산 후 대입
                    System.out.println(horse_num + "번 말이 " + mm[i] + "미터 도착");//1000출력
                    System.out.println(horse_num + "번 말이 도착했습니다");//도착알림
                    System.out.println(horse_num+ " 번말 " + rank + " 등 도착!");//순위 알림
                    break;//무한루프 방지
                }
            }catch (Exception e){
                e.printStackTrace( );
            }
        }
    }
}
public class HorseTest2 {
    public static void main(String[] args) {
        int [] temp = {1,2,3,4,5,6,7,8,9};
        for (int i=0;i<8;i++){
            Thread t = new Thread(new MyHorse(temp[i]));//쓰레드 배열 번호 순서대로 객체생성
            t.start();//쓰레드 시작
            try {//sleep시간을 3초이상으로 늘이면 1번이 1등하게 됨(가끔 2번이 중간에 나오긴 하나 우선순위가 돌아오지 않는 것 같음)
                t.sleep(3000);
            }catch (InterruptedException e){}
        }
        System.out.println("main( ) 종료...");
    }
}