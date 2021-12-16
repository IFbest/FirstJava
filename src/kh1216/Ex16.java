package kh1216;

public class Ex16 {
    //해당 메소드에 어떤 매개변수를 사용하더라도 리턴 값은 일정하다
    public double add(int a, int b){
        int c = a + b;
        return c;
        //매개변수와 무관하게 리턴값은 무조건 정해져있다.
        //return 3.5;
    }
    public static void main(String[] args){
        int num1 = 10;
        int num2 = 20;
        double result = 0;
        //객체 생성
        Ex16 m = new Ex16();
        //add 메소드 결과를 result에 저장
        result = m.add(num1,num2);
        System.out.println("두 수의 합은 " + result);
        //저장값이 아닌 메소드 값을 바로 출력
        System.out.println("두 수의 합은 " + m.add(100,300));
    }
}
