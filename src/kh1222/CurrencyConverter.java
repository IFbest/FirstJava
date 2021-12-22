package kh1222;

public class CurrencyConverter {
	//객체의 모든 메소드와 필드가 static 이므로 객체 생성 없이 자유롭게 새용 가능
	//단 객체 생성이 불가하므로 해당 클래스의 모든 값이 공유되어
	//서로 다른 값을 갖는 객체의 생성은불가능
	private static double rate;
	public static double toDollar(double won) {
		return won/rate;
	}
	public static double toKWR(double dollar) {
		return dollar * rate;
	}
	public static void setRate(double r) {
		rate = r;
	}
}
