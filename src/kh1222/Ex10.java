package kh1222;

public class Ex10 extends Ex10Shape{
	@Override
	public void draw() {
		//그래서 이 부분이 출력됨
		System.out.println("Circle");
	}
	
	public static void main(String[] args) {
		//업 캐스팅의 기본 형 부모클래스 객체명 = new자식생성자();
		//자식 객체가 부모 멤버를 활용할 때 사용
		//이렇게 되면 메소드는 자식의 생성자를 활용하고 필드는 부모의 필드만 활용
		Ex10Shape b = new Ex10();
		//paint 메소드로 이동
		b.paint();
	}
}
