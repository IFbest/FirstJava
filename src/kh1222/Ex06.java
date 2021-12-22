package kh1222;

public class Ex06 {
	public static void main(String[] args) {
		Ex06ColorPoint cp;
		//자식 클래스의 생성자 호출(1)
		cp  = new Ex06ColorPoint(5,6,"blue");
		//ex03ColorPoint 메소드 동작이 완료되면 showColorPoint 메소드 호출(7)
		cp.showColorPiont();
	}
}
