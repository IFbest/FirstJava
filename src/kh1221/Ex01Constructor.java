package kh1221;

public class Ex01Constructor {
	int radius;
	
	public Ex01Constructor(int radius) {
		this.radius = radius;
	}
	//생성자 활용 안 하면 값 활용이 어렵다
	double getArea() {
		return 3.14 * radius * radius;
	}
}
