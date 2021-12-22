package kh1222;

public class Calc {
	//클래스 내 메소드가 모두 static 멤버이므로 객체 생성 없이도 바로 사용 가능하다.
    //abs 메소드는 삼항 연산자를 활용해 a>0 ? a: -a a가 0보다 크면+
    //0보다 작으면 -a로 만들어 절대값을 구한다.
    public static int abs(int a) {
        return a>0 ? a : -a;
    }
    // max나 min 메소드도 삼항 연산자를 사용한다{
    public static int max(int a, int b) {
        return (a>b) ? a: b;
    }
    public static int min(int a, int b){
        return (a>b) ? b : a;
    }
}