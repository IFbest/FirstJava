package kh1222;

//학생은 사람의 일부이므로 이름을 이렇게 지은 것임
//클래스를 선언할 때 이름을 막 짓는 것이 아니라 의미가 있도록 지어야 함
//ex02Student가 ex02Person클래스를 상속 받는다는 선언
public class Ex02Student extends Ex02Person {
	//set 메소드를 활용해 데이터를 입력함
	public void set() {
		age = 30;
		name = "홍길동";
		height = 175;
		//weight 변수가 private 이므로 상속 받는 것이 불가능함
		//set을 통한 간접 상속
		setWeight(99);
	}
}
