package kh1216;

public class Ex21 {
    static void func1(int a) {
        //static 붙어있고 동일 클래스에서 선언됐고
        a = a + 1;
        System.out.printf("전달받은 a ==> %d\n", a);
    }

    public static void main(String[] args) {
        int a = 10;
        //이번에는 객체를 생성하지 않았기 때문에
        //메소드에 static을 붙였음
        //객체 생성 안하고 그냥 메소드를 사용하면 이탤릭체로 변환
        func1(a);
        System.out.printf("func1() 실행 후의 a ==> %d\n", a);
    }
}
