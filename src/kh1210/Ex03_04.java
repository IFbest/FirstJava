package kh1210;
public class Ex03_04 {

	public static void main(String[] args) {
		int a; // 정수형 변수 선언
		float b; // 실수형 변수 를 선언

		a = (int) 123.45f; // 정수형 변수에 실수를 대입 오류를 방지하기 위해(인트)를 붙여서 정수로 변환
		b = (float) 200; // 실수형 변수에 정수를 대입 오류를 방지하기위해 (플롯)를 붙여서 실수로 변환
		// b= 200.0f도 가능
		System.out.printf("a의 값 ==>%d \n", a);
		System.out.printf("b의 값 ==>%f \n", b);

	}

}