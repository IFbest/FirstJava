package kh1222;

class A{
	//상위 클래스의 기본 생성자가 동작한다(3)
	public A() {
		System.out.println("생성자A");
	}
	public A(int x) {
		System.out.println("매개변수생성자A");
	}
}

class B extends A {
	public B() {
		System.out.println("생성자 B");
	}
	//여기로 먼저 갔다가(2)
	public B(int x) {
		//이 부분을 먼저 실행히시키지 못하고
		//(4)번 동작이 마무리 되면 이 부분이 출력되면서 프로그램 마무리(5)
		System.out.println("매개변수생성자B");
	}
}
//어떠 클래스를 상속 받는 자식 클래스의 객체를 생성할 경우
//해당 객체의 부모 클래스의 생성자가 우선 호출되므로 원하지 않는 메소드가 실행 될 수 있다.
//이러한 현상을 바인딩이라고 하는데 어렵다

public class Ex04 {
	public static void main(String[] args) {
		//클래스 B의 생성자 중 매개변수가 존재하는 생성자를 호출한다.
		//호출된 메소드를 실행하기 전에 부모 클래스인 classA의 기본생성자가 우선 호출된다.
		B b = new B(5);
	}
}
//super()
//서브 클래스에서 명시적으로 슈퍼 클래스의 생성자 선택 호출
//super(parameter);
//인자를 이용하여 슈퍼 클래스의 적당한 생성자 호출
//반드시 서브 클래스 생성자 코드의 제일 첫 라인에 와야 함
