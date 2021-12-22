package kh1222;

//아래의 상속 관계를 보면
//Person -> Student
//Person -> Researcher -> Professor이 된다

class Person{}
class Student extends Person{}
class Researcher extends Person{}
class Professor extends Researcher{}

public class Ex07 {
	//해당 메소드의 인수와 매개변수(Perameter)를 합쳐서 보면 다음과 같다
	//Person p  = new Student();
	//자식 객체가 부모 멤버(필드 + 메소드)를 활용하는 형태
	//이러한 형태를 업 캐스팅 이라고 한다
	//반대의 경우 다운 캐스팅이 된다
	static void print(Person p) {
		//a instanceof b 메소드 다운캐스팅이 가능한지 확인하기 위해 사용
		//a, b는 모두 객체이고 a 객체가 b 객체의 자식 클래스일 경우 true
		//아닐 경우 false를 출력
		if(p instanceof Person)
			System.out.print("Person ");
		if(p instanceof Student)
			System.out.print("Student ");
		if(p instanceof Researcher)
			System.out.print("Researcher ");
		if(p instanceof Professor)
			System.out.print("Professor ");
		System.out.println();
	}
	public static void main(String[] args) {
		System.out.print("new Student() -> \t");
		//print 메소드는 Ex07 클래스의 자체 생성 메소드이다
		//전달하는 인수(argument)가 new Student()로 객체의 형태로 전달된다
		print(new Student());
		System.out.print("new Researcher() -> \t");
		print(new Researcher());
		System.out.print("new Professor() -> \t");
		print(new Professor());
	}
}
