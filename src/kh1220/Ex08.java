package kh1220;

public class Ex08 {
	public static void main(String[] args) {
		int sum;
		// 객체 obj 생성
		Ex08Math obj = new Ex08Math();
		//ex08Math  내부 메소드 add 활용
		sum = obj.add(2, 3);//인수
		System.out.println("2와 3의 합은 " + sum);
		// 이번에는 2,3을 입력
		sum = obj.add(7, 8);//인수
		System.out.println("7와 8의 합은 " + sum);
	}
}

class Ex08Math{
	int add(int x, int y) {//매개변수 
	 return x+y;//리턴값으로 매개변수의 합	 
	}
}