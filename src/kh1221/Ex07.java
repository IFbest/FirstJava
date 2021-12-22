package kh1221;

public class Ex07 {
	public static void main(String[] args) {
        Ex07StaticSample.m = 10;
        
        Ex07StaticSample s1;
        s1 = new Ex07StaticSample();
        //위에서 입력된 10이 출력된 것
        System.out.println(s1.m);
        //이후 f() 메소드가 실행되면 m=5가 됨
        //이 역시 잘못된 표현으로 아래와 같이 Ex07StaticSample.f() 이렇게 표현해야 한다.
        s1.f();
        Ex07StaticSample.f();
        System.out.println(s1.m);
    }
}