package kh1222;

public class Ex01 {
	public static void main(String[] args) {
        //객체 생성
        Ex01Point p = new Ex01Point();
        //set 메소드를 활용해 데이터 입력
        p.set(1,2);
        //입력된 데이터를 출력
        p.showPoint();
        //ColorPoint 객체 생성
        //이 객체는 Point 클래스의 자식 클래스이므로
        //메소드나 변수를 그대로 활용할 수 있음
        //부모클래스에 선언되어 있으면 굳이 자식 클래스에서 선언할 필요가 없음(상속성)
        Ex01ColorPoint cp = new Ex01ColorPoint();
        //ex01ColorPoint클래스에는 set 메소드가 없지만
        //부모 클래스인 ex01Point에는 있으므로 상속받아 사용 가능
        cp.set(3, 4);
        cp.setColor("red");
        cp.showColorPoint();
    }
}