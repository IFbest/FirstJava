package kh1222;

public class Ex13Manager extends Ex13Employee {
	private int bonus;
	//이동한 뒤 bonus만 this 키워드로 전달하고(2)
	public Ex13Manager(String name, String address, int salary, int rrn, int bonus) {
		//나머지 데이터는 Ex13Employee 클래스로 전송한다(3)
		super(name, address , salary, rrn);
		this.bonus = bonus;
	}
	void test() {
		//이 변수들은 Ex13Manager필드에 존재하지 않지만
		//부모클래스인 Ex13Employee에 있으므로 바로 활용이 가능하다.
		System.out.println("name = " + name);
		System.out.println("address = " + address);
		System.out.println("salary = " + salary);
		//System.out.println("rrn = " + rrn);//priavte 피라미터라 안됨
	}
}
