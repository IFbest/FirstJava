package kh1222;

public class Ex06Point {
	private int x, y;
	public Ex06Point() {
		this.x = this.y = 0;
	}
	// 이 부분으로 이동(4)
	public Ex06Point(int x, int y) {
		//this keword를 활용해 동명의 매개변수를 필드에 저장(5)
		this.x = x; this.y = y;
	}
	// 이 곳에서 (5)번 동작 때 저장된 필드 정보를 출력
	public void showPoint() {
		System.out.println("(" + x + "," + y + ")");
	}

}
