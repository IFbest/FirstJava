package kh1222;

public class Ex13Employee  {
	public String name;
	String address;
	protected int salary;
	private int rrn;
	//해당 생성자에서 나머지 값들을 입력받고 완료
	public Ex13Employee(String name, String address, int salary, int rrn) {
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.rrn = rrn;
	}
	@Override
	//toString() : 최상위 클래스인 Object 클래스에 내장된 메소드
	//객체를 System.out.println();에 입력만 해도 별도의 동작 없이 자동으로 콘솔창에 출력됨
	public String toString() {
		return "Employee {name = " + name + ", address =" + address 
				+ ", salary =" + salary + ", rrn =" + rrn + "]";
	}
}
