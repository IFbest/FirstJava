package kh1221;

public class Ex02CarDesign {
	private String carName;
	private String carColor;
	private int carSize;
	private int velocity;
	
	public Ex02CarDesign(String _name,String _color,int _size,int _velocity) {
		this.carName = _name;
		this.carColor = _color;
		this.carSize = _size;
		this.velocity = _velocity;
	}
		
	public String getCarName() {
		return carName;
	}
//	public void setCarName(String _name) {
//		this.carName = _name;
//	}
	public String getCarColor() {
		return carColor;
	}
//	public void setCarColor(String _color) {
//		this.carColor = _color;
//	}
	public int getCarSize() {
		return carSize;
	}
//	public void setCarSize(int _size) {
//		this.carSize = _size;
//	}
	public int getVelocity() {
		return velocity;
	}
//	public void setVelocity(int _velocity) {
//		this.velocity = _velocity;
//	}
	public void speedUp() {
		velocity = velocity + 1;
	}
	public void speedDown() {
		velocity = velocity - 1;
		if(velocity <0)
			velocity = 0;
	}
	public void stop() {
		velocity = 0;
	}
	public void prak() {
		System.out.println("주차합니다.");
	}

}
