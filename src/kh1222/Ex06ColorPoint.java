package kh1222;

public class Ex06ColorPoint extends Ex06Point{
	private String color;
	//이 부분이 호출되지만 자식 클래스이기 때문에 부모 생성자가 먼저 동작(2)
	public Ex06ColorPoint(int x, int y, String color) {
		//이 부분에서 부모 클래스의 생성자를 지목(3)
		super(x, y);
		//부모 생성자를 동작시킨 후 돌아와서 this 키워드로 color 변수를 필드에 저장(6)
		this.color = color;
	}
	//해당 메소드에서 (6)번 동작으로 전달 받은 color 출력하고(8)
	public void showColorPiont() {
		System.out.print(color);
		//부모 클래스의 showPoint 메소드 호출(9)
		showPoint();
	}
}
