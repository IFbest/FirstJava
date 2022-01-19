package kh0106;
//현재 동작중인 쓰레드 정보
//쓰레드란 프로세스가 만들어낸 임의의 데이터 처리 공간 정도?
public class E02ThreadMainEx {
    public static void main(String[] args) {
        long id = Thread.currentThread().getId();
        String name = Thread.currentThread().getName();
        int priority = Thread.currentThread().getPriority();
        Thread.State s = Thread.currentThread().getState();
        System.out.println("현재 스레드 이름 = " + name);//스레드 이름
        System.out.println("현재 스레드 ID = " + id);//아이디
        System.out.println("현재 스레드 우선순위 값 = " + priority);//우선순위 값
        System.out.println("현재 스레드 상태 = " + s);//상태 RUNNABLE
    }
}
