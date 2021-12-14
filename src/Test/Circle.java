package Test;

public class Circle {
	//PI라는 이름으로 3.14로 초기화된 정적 변수
	public static final double PI =3.14;
    private double radius;//radius를 무엇으로 변경? this가 private를 의미
    //원의 반지름을 매개 변수로 받는 생성자를 작성
    public Circle() {
    //public Circle(double radius) {
    	//this.radius = radius;//this means private
    }
    //접근자 메소드인 getRadius()를 작성
    public double getRadius() {
    	return radius;
    }
    //설정자 메소드인 setRadius()를 작성
    public void setRadius(double radius, double b) {//before) double
    	this.radius = radius;
    }
    //PI값을 반환하는 정적 메소드 getPI를 작성
    public static double getPI() {
    	return PI;
    }
    public void draw() {
    	System.out.println("반지름" + radius + "cm인 원을 그립니다.");
    }
}
