package kh1222;

public class Ex08 {
	public static void main(String[] args) {
		
	//static 메소드 이므로 객체 생성 없이 calc 클래스명을 그대로 사용할 수 있다.
	// 이와 같은 static 클래스로는 Math가 있다.
	System.out.println(Calc.abs(-5));
	System.out.println(Calc.max(10, 8));
	System.out.println(Calc.min(-3, -8));
	}
}
