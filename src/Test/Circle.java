package Test;

public class Circle {
	//PI라는 이름으로 3.14로 초기화된 정적 변수
	public static final double PI =3.14;
    private double radius;//radius를 무엇으로 변경? this가 private를 의미
    //원의 반지름을 매개 변수로 받는 생성자를 작성
    public Circle() {
    //public Circle(double radius) {//double radius를 넣게 되면 해당 메소드는 실수형으로만 매개변수를 받아야함
    //radius는 private형이므로 인자로 갖게 되면 외부에서 사용할 수 없게 됨
    	//this.radius(전역변수) = radius(매개변수);//this는 자기자신을 가리키는 포인터 전역,매개변수가 이름이 같을 때 사용,여기선 불필요
    }
    //접근자 메소드인 getRadius()를 작성
    public double getRadius() {
    	return radius;
    }
    //설정자 메소드인 setRadius()를 작성
    public void setRadius(double radius, double b) {
    	//Run클래스에서 실수형 2개를 받기 위해서 1개를 추가로 작성
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
