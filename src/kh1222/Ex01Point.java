package kh1222;

public class Ex01Point {//부모 클래스
	int x,y;
	//set 메소드로 좌표 정보  받아들임
	public void set(int x, int y) {
		this.x = x; this.y = y;
	}
	//입력받은 데이터 출력
	public void showPoint() {
		System.out.println("(" + x +","+ y + ")");
	}
}
