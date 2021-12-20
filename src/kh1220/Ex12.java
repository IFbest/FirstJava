package kh1220;

public class Ex12 {
	int radius;
	String name;
	//기본 생성자, 만들지 않아도 컴파일러가 알아서 생성된다
	public void E14Circle() {
	}
	//면적을 구하는 메소드, 리턴 타입이 double이다
	public double getArea() {
		return 3.14 * radius * radius;
	}
	public static void main(String[] args) {
		//ex12 pizza = new ex12(); 이것을 두 줄로 쓴 것이다
		Ex12 pizza;
		pizza = new Ex12();
		// 객체에 해당 변수를 입력한다
		pizza.radius = 10;
		pizza.name = "자바피자";
		//면적은 아래 메소드를 활용해 구함
		double area = pizza.getArea();
		System.out.println(pizza.name + "의 면적은 " + area);
		// 객체 생성
		// 위의 동작을 반복함, 클래스는 같지만 객체변수가 다르기 떄문에 결과는 다르다
		Ex12 donut = new Ex12();
		donut.radius = 2;
		donut.name = "자바도넛";
		area = donut.getArea();
		System.out.println(donut.name + "의 면적은 " + area);
	}
}
