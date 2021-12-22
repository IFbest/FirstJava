package kh1222;

public class Shape {
	protected String name;
	public void paint() {
		//이 부분에서 동적 바인딩이 발생해 오버라이드 하고 있는 draw메소드로 이동(3)
		draw();
	}
	//이동해서 이전에 전달받은 name을 호출하고(6)
	public void draw() {
		System.out.println(name);
	}
}
