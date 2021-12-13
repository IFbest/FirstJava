package Test;

public class Circle {
	public static final double PI =3.14;
    private double radius;//hint
    
    public Circle(double radius) {
    	this.radius = radius;
    }
    public double getRadius() {
    	return radius;
    }
    public void setRadius(double radius, int i) {//before) double
    	this.radius = radius;
    }
    public static double getPI() {
    	return PI;
    }
    public void draw() {
    	System.out.println("반지름" + radius + "cm인 원을 그립니다.");
    }
}
