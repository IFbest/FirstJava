package kh1217;

public class Ex01 {
    // 객체 변수를 매개변수로 받으면 Call by reference가 되기 때문에
    // 리턴이 없더라도 원래 값이 변하게 된다.
    // 사실 객체변수를 넘기는 것도 주소값을 넘기는 Call by Value 이지만
    // 결과가 Call by reference와 같기 때문에 그냥 레퍼런스라고 했음
    static void func1(Myint m){
        m.a = m.a + 1;
        System.out.printf("전달받은 a --> %d\n", m.a);
    }

    public static void main(String[] args) {
        Myint m = new Myint(); // 객체 변수 선언
        m.a = 10; // 클래스 내부 변수 초기값 입력
        
        func1(m);// 클래스 m을 매개변수로 받은 건가??
        System.out.printf("func1() 실행 후의 a ==> %d\n", m.a);
        //리턴이 없지만 연산 후 a의 값이 변경
    }
}