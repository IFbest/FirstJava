package kh1222;

//상속성, 아주 중요
//출력과 관련된 것이 없으므로 출력은 없음
//만약 결과를 보고 싶다면
//public void showPoint(){
//System.outprintln("(" + x + "," + y + ")");
//} 이런 식으로 출력 메소드를 별도로 만들어 주면 됨
public class Ex02 {
	public static void main(String[] args) {
		//자식 클래스인 ex02Student의 객체 생성
		Ex02Student s = new Ex02Student();
		s.set();
		//set 메소드를 활용해 Person에 있던 분수들을 갱신
	}
}
