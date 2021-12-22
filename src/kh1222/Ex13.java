package kh1222;

public class Ex13 extends Shape {
	public static void main(String[] args) {
		//Manager 생성자로 이동한다(1)
		Ex13Manager m = new Ex13Manager("Tom", "Seoul",1000000,123456,50000);
		//toString() 메소드에 의해 m객체에 입력된 문장이 출력됨
		//반드시 toString 이름으로 메소드를 만들어야 효룍이 있음
		System.out.println(m);
		//나머지 입력 값은  test  메소드에서 출력되는데
		m.test();
	}

}
