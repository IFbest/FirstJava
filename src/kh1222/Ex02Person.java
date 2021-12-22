package kh1222;

public class Ex02Person {
	int age;
	public String name;//접근 제한 없음
	private int weight;//하위 클래스가 상속받지 못함
	protected int height;
	//protected는 동일 패키지 내와 상속 받는 클래스에서만 사용 가능
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getWeight() {
		return weight;
	}
}
