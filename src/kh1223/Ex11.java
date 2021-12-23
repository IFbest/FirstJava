package kh1223;
//인터페이스(interface) 매우 중요
//추상클래스의 변형, 인터페이스는 추상클래스와 유사하지만 클래스가 아님
//클래스처럼 상속을 해주지만 클래스가 아니므로 다수의 인터페이스의 ㅅ아속을 받는 것도 가능
//인터페이스는 interface I_NAME 이런 식으로 선언하며
//인터페이스의 상속은 class C_NAME implemnents I_NAME 이런 식으로 쓰임

interface PhoneInterface{
    //인터페이스에서 선언되는 필드 변수는 모두 상수 변수(final)이다
    //아니어도 되지만 대부분 그러헥 사용함
    final int TIMEOUT = 10000;
    void sendCall();
    void receiveCall();
    //default 메소드 : 인터페이스의 메소드 중 하나는 일반 클래스의 메소드처럼 동작이 정의도리 수 있음
    //default 메소드를 활용하면 자바에서도 다중상속을 할 수 있음
    default void printLogo() {//default 메소드
        //interface 내부에 메소드, 맞기만 가져다 쓸 수 있는 것인가
        System.out.println("** Phone **");
    }
}
//인터페이스의 구현은 implements 키워드 활용
class SamasungPhone implements PhoneInterface {
    //PhoneInterface의 모든 추상 메소드 구현
    @Override
    public void sendCall(){
        System.out.println("띠리리리링");
    }
    @Override
    public void receiveCall(){
        System.out.println("전화가 왔습니다.");
    }
    public void flash(){
        System.out.println("전화기에 불이 켜졌습니다.");
    }
}

public class Ex11 {
    public static void main(String[] args) {
        SamasungPhone phone = new SamasungPhone();
        phone.printLogo();
        phone.sendCall();
        phone.receiveCall();
        phone.flash();
    }
}