package kh1216;

public class Ex13 {
    public void print(int a) {
        System.out.println("결과값 = " + a);
    }
    public static void main(String[] args) {
        int a = 11;
        int b = 22;
        int result = 0;
        // 객체를 생성하면 메모리에 언스턴스가 생성돼 메소드 활용 가능
        Ex13 m = new Ex13();
        result = a + b;
        
        // m.print(10)에서 10이 인수(argument)
        m.print(10);
        m.print(b);
        m.print(result);
        
        Ex11 n = new Ex11();
        n.print();
    }
}