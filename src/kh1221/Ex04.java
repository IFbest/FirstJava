package kh1221;

public class Ex04 {
	public static void main(String[] args) {
        Ex04Bean aClass = new Ex04Bean();
        aClass.a = 10;
        // b의 변수가 private로 지정되어 있어 변수값을 직접 전달할 수 없음
        // 즉 aClass.b = 10; 이런 식을 사용하면 에러 발생
        // setter 메소드를 활용해야만 데이터 전달 가능
        aClass.setNum(10);
        aClass.c = 10;
        System.out.println("a = " + aClass.a);
        // 데이터를 전달 받을 때도 객체명.변수명 이런 식으로 사용 불가능
        // 객체명.getter메소드 이런 식으로 전달받아야 함
        System.out.println("b = " + aClass.getNum());
        System.out.println("c = " + aClass.c);
    }//public int a;
}//private int b;
//int c;