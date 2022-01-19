package kh0107;

public class E10ThreadControl {
    static void print(String message){//메세지를 스레드 이름과 함께 출력
        //현재 쓰레드 명 저장
        String threadName = Thread.currentThread().getName();
        //현재 쓰레드 명과 메시지 출력
        System.out.format("%s: %s%n", threadName,message);
        //System.out.format()은 sprintf 함수를 구현할 수 있습니다
        //자바 1.5(=자바 5.0) 이상에서만 사용 가능합니다.
        //이것을 System.out.println()으로 출력하면
        //최종적으로 printf()와 같은 역할을 하게 됩니다.
        //%s-큰따옴표 문자열, %d-10진수, %c-작은따옴표 문자 %f-실수
    }
    //정적 내부 클래스는 외부 클래스 객체 없이도 사용 가능
    private static class MessageLoop implements Runnable{
        public void run(){
            //출력할 메시지 배열 정의
            String messages[] = {"Pride will have a file. "
                    ,"Power is dangerous unless you have humility."
                    ,"Office chnages manners."
                    ,"Empty vessels make the most sound"};
            try {
                //for문을 통해 메시지 출력
                for (int i=0;i<messages.length;i++){
                    //4번 멘트
                    print(messages[i]);
                    //2초 간격으로 실행
                    Thread.sleep(2000);
                }
            }catch (InterruptedException e){//인터럽트 되면 메시지를 출력한다.
                print("아직 끝나지 않았어요!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //쓰레드 실행횟수
        int tries = 0;
        //해당 클래스 내부 static 메소드인 print 실행해 추가적인 스레드를 실행합니다 출력
        //1번 멘트 쓰레드 명은 main
        print("추가적인 스레드를 실행합니다.");
        //내부 클래스인 MessageLoop를 쓰레드 객체로 지정
        Thread t = new Thread(new MessageLoop());
        //run 메소드 실행
        t.start();
        //2번 멘트
        print("추가적인 스레드가 끝나기를 기다립니다.");
        while (t.isAlive()){//isAlive() : 해당 스레드의 실행여부 반환
            //스레드가 실행중일 때 멘트 실행
            //3번 멘트 5번멘트
            print("아직 기다립니다.");
            t.join(1000);
            //join():하나의 메소드가 다른 스레드의 종료를 기다리게 하는 메소드
            //스레드 t가 종료하기를 1초 동안 기다린다
            //스레드 생성 횟수 추가
            tries++;
            //스레드 생성 횟수가 3회 이상이면 종료
            if (tries >2){
                print("참을 수 없네요!");

                t.interrupt();//해당 스레드 중지
                t.join();//t의 종료를 기다리게 하는 메소드
            }
        }
        print("메인 메소드 종료!");
    }
}
