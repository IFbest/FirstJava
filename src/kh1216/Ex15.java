package kh1216;

public class Ex15 {
    public void print(int a, int b){
        int c = a + b;
        System.out.println("결과는= " + c);       
    }
    public void print1(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        int num1 = 11;
        int num2 = 22;
        int result = 0;
        
        //객체 생성
        Ex15 m = new Ex15();
        //print 메소드 활용
        m.print(10, 30);
        m.print(num1, num2);
        //print1 메소드 활용
        m.print1("안녕하세요");
    }
}