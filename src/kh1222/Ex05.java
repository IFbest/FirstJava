package kh1222;

class AA{
	public AA() {
		System.out.println("생성자A");
	}
	//super(x) 로 지정되었기 때문에 해당 메소드를 실행한다(4)
	public AA(int y) {
		//이 부분을 동작 시키고(5)
		System.out.println("매개변수생성자A" + y);
	}
}
class BB extends AA{
	public BB() {
		super(); //이게 super
		System.out.println("생성자B");
	}
	
	//이전 예제에서는 부모 클래스의 매개변수 없는 생성자로 이동했지만 (2)
	public BB(int x) {
		//super(x) 명령에 의해 매개변수가 선언된 생성자를 실행하게 된다(3)
		super(x); //이게 super
		//내려와서 자식 클래스의 해당 생성자를 마저 실행한다 (6)
		System.out.println("매개변수생성자B" + x);
	}
}
//제멋대로 뛰어ㅏ니는 바인딩을 쉽게 컨트롤 하기 위해 사용하는 것이 super keyword이다.
//super을 활용하면 바인딩이 발생할 때 원하는 생성자를 지정할 수 있다.
//만약 바인딩 하는 꼴을 정말 보기 싫으면 생성자를 안쓰면 되는 것 같다

public class Ex05 {
	public static void main(String[] args) {
		//해당 메소드를 실행하면 BB(int x)로 이동한다(1)
		BB bb = new BB(5);
	}
}
