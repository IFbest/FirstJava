package kh1222;

public class Ex01ColorPoint extends Ex01Point{
	//클래스 상속
	//클래스 상속은 "자식클래스 명 exteds 부모클래스 명" 이렇게 사용
	//extends 임(끝에 s가 들어감)
	//상속 받은 클래스는 상속해준 클래스의 메소드 및 변수를 활용 가능
	//상속 받은 메소드의 경우 이름만 갖다 쓰고 내용은 변경할 수 있음(오버라이딩, 다형성)
	//자바는 하나의 클래스가 하나의 클래스만 상속 받을 수 있음(다종상속 불가)
	//상속은 해주는 것은 몇 번이고 가능
	//다중상속 문제를 해결하기 위해 인터페이스(interface)가 존재하며
	//인터페이스를 통한 간접 상속은 무한히 가능

	private String color;
	//위의 color 변수의 타입이 private 이므로
	//setter 메소드로 데이터 입력 받음

	public void setColor(String color) {
		this.color = color;
	}

	public void showColorPoint() {
		System.out.println(color);
		//super.은 상속 받은 메소드를 활용한다는 표현임
		//super을 빼도 되지만 ㅅ아속 받았따는 것을 표현하기 위해 쓴 것
		//이 메소드는 부모 클래스인 ex01Point.java에 존재하는 클래스
		//해당 객체에서 ex01Point.java에 직접 x, y 값을 대입 하지는 않지만
		//x, y 역시 상속 받아 사용하므로 아예 x,y 변수를 선언 했다고 봐도 됨
		super.showPoint();
	}
}
