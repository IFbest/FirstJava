package kh1223;
    //abstract : 추상 메소드 선언 (다형성)
    //abstract class C_NAME 이런 식으로 선언
    //추상 클래스란? : 추상 메소드를 한 개 이상 가진 클래스
    //단 한개의 추상메소드를 가져도 추상클래스가 됨
    //필드 변수를 선언하는 것도 가능하다
    abstract class Ex10Calculator {
        // 추상 메소드란? 메소드의 상세 동작이 정의되지 않은 클래스
        // 메소드의 상세 내용은 활용하는 부분에서 오버라이딩으로 정의됨
        public abstract int add(int a, int b);
        public abstract int subtract(int a, int b);
        public abstract double average(int[] a);
        public void aaa(int a, int b){}
        //이렇게 하면 되는데 중괄호가 있어 추상 메소드가 아님
    }