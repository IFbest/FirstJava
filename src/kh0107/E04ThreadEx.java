package kh0107;
//이번에는 Thread 클래스를 직접 상속
public class E04ThreadEx extends Thread{
    public static void main(String[] args) {
        //메인 메소드 안에 쓰레드 객체 클래스 생성
        class Car {
            String carName;
            public Car(String carName){
                this.carName = carName;
            }
            public void run(){
                for (int i =0;i<3;i++){
                    try {
                        Thread.sleep(10);
                        System.out.println(carName + " " + i + "km 달립니다.");
                    }catch (Exception e){
                    }
                }
            }
        }
        //이전 예제에서는 start 메소드를 활용해 쓰레드를 실행했는데
        //본 예제에서는 run으로 직접 실행하는 것으로 돼있기 때문에
        //쓰레드 방식으로 객체를 실행시킨 것이 아닌 일반 메소드 호출이 된다
        //다만 sleep 메소드는 정상 실행됨
        Car car1 = new Car("$자동차1"); car1.run();
        Car car2 = new Car("$자동차2"); car2.run();
        Car car3 = new Car("$자동차3"); car3.run();
    }
}
//스스로 종료 : run() 메소드 리턴
//타 스레드에서 강제 종료 : interrupt() 메소드 사용 -->return 을 해줘야 함
//wait(),notify(),notifyAll()은 Thread의 메소드가 아니며 Object의 메소드임

//멀티스레드 프로그램 작성시 주의점
//다수의 스레드가 공유 데이터에 동시에 접근하는 경우
//공유 데이터의 값에 예상치 못한 결과 발생 가능
//스레드 동기화
//멀티스레드의 공유 데이터의 동시 접근 문제 해결책
//공유 데이터를 접근하는 모든 스레드의 한 줄 세우기
//한 스레드가 공유 데이터에 대한 작업을 끝낼 때까지 다른 스레드가 대기 하도록 함
