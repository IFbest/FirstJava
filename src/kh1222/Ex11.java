package kh1222;

public class Ex11 extends Shape{
	protected String name;
@Override
//해당 메소드가 출력되어 (4)
public void draw() {
	name = "Circle";
	super.name = "Shape";
	//super.name을 활용해 부모 클래스에 이름 입력
	//super 키워드를 통해 다시 부모 클래스의 로 이동(5)
	super.draw();
	//다시 자식 클래스로 이동해 를 출력하고 종료(7)
	System.out.println(name);
}
public static void main(String[] args) {
	//업캐스팅 객체 생성(1)
	Shape b = new Ex11();
	// 부모 클래스 shape의 paint메소드 호출(2)
	b.paint();
	}
}
//Super는 슈퍼 클래스의 멤버를 접근할 때 사용되는 레퍼런스
//서브 클래스에서만 사용
//슈퍼 클래스의 메소드 호출
//컴파일러는 super의 접근을 정적 바인딩으로 처리

//동적 바인딩
//실행할 메소드를 실행 시(run time)에 결정
//오버라이딩 메소드가 항상 호출