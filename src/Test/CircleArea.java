package Test;
public class CircleArea {

	public static void main(String[] args) {//pi의 값은 변하면 안되니 앞에 final로 고정
		final double PI = 3.14; // 원주율을 상수로 선언
		double radius = 10.0; // 원의 반지름
		double circleArea = radius * radius * PI; // 원의 면적 계산
		System.out.println("원의 면적=" + circleArea); // 원의 면적을 화면에 출력

	}

}
//원의 면적=314.0
// System.out.println() : 괄호 안의 내용을 출력한 후 한 행을 띄움
// System.out.print() : 괄호 안의 내용을 출력한 후 한 행을 띄지 않고 유지
// System.out.printf() : 서식을 지정해서 출력