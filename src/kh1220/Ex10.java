package kh1220;

public class Ex10 {
	public static void main(String[] args) {
		// myCar 객체 생성
		Ex10car myCar = new Ex10car();
		// changeGear 메소드 실행
		myCar.changeGear(1);
		// speedUp 메소드 시랳ㅇ
		myCar.speedUp();
		// toString 메소드 실행
		System.out.print(myCar.toString());
	}

}

class Ex10car{
	String color;
	int speed;
	int gear;
	//@override : 이미 존재하는 메소드의 기능을 변경하는 것(다형성)
	@Override
	//toString 메소드를 실행시켜 System.out.print 메소드에 문자열 전송
	//toString은 특수 메소드이다
	public String toString() {
		return "Car [color=" + color + ",speed=" + speed + ",gear=" + gear +"]";
	}
	//ex10 클래스에서 전달받은 1이 객체 변수에 저장
	void changeGear(int g) {
		gear = g;
	}
	//객체에서 speedUp 메소드를 실행시켜 스피드에 10이 추가됨
	void speedUp() {
		speed = speed - 10;
	}
}