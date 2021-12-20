package kh1220;

public class Ex11 {
	public static void main(String[] args) {
		//객체 생성
		Ex11Math obj = new Ex11Math();
		//  위 아래의 메소드명은 모두 square로 동일하지만
		// 들어가는 인수(argument, 매개변수와 유사)의 데이터 타입이 정수와 부동소수로 서로 다름(다형성)
		// ex11Math 클래스에서 동명의 메소드가 존재하는 오버로딩이 있음을 예상할 수 있음
		System.out.println(obj.square(10));
		System.out.println(obj.square(3.14));
	}
}

class Ex11Math {
	int square(int x){
		return x*x;
	}
	double square(double x){
		return x*x;
	}
}//square로 메소드명이 겹치지만 매개변수타입이 다르므로 다형성으로 인해 다른 메소드가 된다.

