package kh1216;

public class Ex11 {
    // ex10번과 다르게 static 선언을 안해주는 이유는
    // 아래에 객체 변수를 생성해줬기 때문이다.
    public void print() {
        System.out.println("메소드를 호출합니다.");
        //void 타입이기 때문에 리턴이 없다.
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int result = 0;

        //해당 예제 클래스의 객체 변수 m을 생성함
        //ex11()은 기본 생성자로 클래스 내에 생성자를 만들지 않아도 자동으로 생성됨
        Ex11 m = new Ex11();//before ex11 m = new ex11();
        m.print(); // m객체 변수를 생성하고 그 내부 print() 메소드 활용 가능
        m.print(); // 객체 변수 생성 안하고 활용하려면 static 메소드로 변경하면 가능
        m.print();
    }
}