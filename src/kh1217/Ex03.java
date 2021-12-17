package kh1217;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividend;
        int divisor;

        System.out.print("나뉨수를 입력하시오 : ");
        dividend = scanner.nextInt();
        System.out.print("나눗수를 입력하시오 : ");
        divisor = scanner.nextInt();
        //try-catch문 (던지고 잡는다(try정상/catch예외상황))
        //try 내부 코드에 에러가 없으면 try 내부 코드가 실행되지만
        try {
            System.out.println(dividend + "를" + divisor + "로 나누면 몫은 " + dividend/divisor + "입니다.");
            
        }catch (ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다! 다시 입력하세요.");
        }
        scanner.close();
    }
}
//오류가 있을 경우 try는 실행되지 않으며
//catch문 내부 eception(예외 유형)과 일치하면 catch문 내부 코드가 진행됨
//즉, 에러가 발생하지 않음
// 에러가  발생하지 않고 에러 유형을 다른 사용자로 부터 감출 수 있음