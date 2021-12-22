package kh1221;

public class Ex06 {
    public static void main(String[] args) {
        Ex06StaticSample s1,s2;
        s1 = new Ex06StaticSample();
        s1.n = 5;
        s1.g();
        s1.m = 50; // static 변수
        s2 = new Ex06StaticSample();
        s2.n = 8;
        s2.h();
        //ex06StaticSample.f() : static 멤버는 객체 생성 이전에 메모리에 할당 되므로
        // 객체와 별도로 클래스 명을 활용해 직접 사용 가능
        // static 메소드는 원래 객체 생성 없이 바로 사용해야 하지만
        // 컴파일러에서는 그냥 허용해주는 것이다.
        // 원래는 Ex06StaticSample.f() 이렇게 사용해야 한다.
        s2.f();
        // static 변수는 객체와 무관하게 공유하므로 s2 객체에서 변경 되었어도 s1에서 변경된 것과 동일
        System.out.println(s1.m);
    }
}