package kh1223;

import kh1223.MyFunction1;

public abstract class Ex04 implements MyFunction1{
    public static void main(String[] args) {
        //람다식, 메소드를 편하게 활용하기 위해 추가된 기능
        //람다식을 활용하면 코드를 많이 줄일 수 있지만 자바에서는 별로 사용되지 않음
        //인터페이스 객체 = 변수명 -> 메소드 정의
        MyFunction1 square = x -> x * x;
        //squre.calc(2)를 하면 인터페이스 메소드가 윗줄의 식으로 구현되어 결과가 출력됨
        System.out.println(square.calc(2));
    }
}
