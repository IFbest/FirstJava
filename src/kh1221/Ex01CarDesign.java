package kh1221;

public class Ex01CarDesign {
	// 참조 객체의 변수들(필드)은 모두private접근 제어자를 가지므로
	// 클래스 외부에서의 접근을 차단함
	// 접근은 클래스 내부 getter,setter를 이용해 메소드에 값 저장
	private String carName;
	private String carColor;
	private int carSize;
	private int velocity;
	
	// get값은 return 값만 가짐
	// 필드에 저장된 값을 리턴함
	public String getCarName() {
		return carName;
	}
	// Ex01_1에서 전송받은 매개변수를 해당 클래스의 필드 변수에 저장
	public void setCarName(String _name) {
		carName = _name;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String _carColor) {
		carColor = _carColor;
	}
	public int getCarSize() {
		return carSize;
	}
	public void setCarSize(int _carSize) {
		carSize = _carSize;
	}
	public int getVelocity() {
		return velocity;
	}
	public void setCarVelocity(int _velocity) {
		velocity = _velocity;
	}
	// speed 메소드는 속도를 증가/감소 시키는 연산을 추가하여
	// 차량의 속도가 증가/감소하는 것 같은 역할을 하게 함
	public void speedUp() {
		velocity = velocity + 1;
	}
	//감속에는 속도 제한을 두어, 음수가 나올 수 없게함
	public void speedDown() {
		velocity = velocity - 1;
		if (velocity <0)
			velocity = 0;
	}
	public void stop() {
		velocity = 0;
	}
	public void prak() {
		System.out.println("주차합니다.");
	}
}
