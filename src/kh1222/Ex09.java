package kh1222;

import java.util.Scanner;

public class Ex09 {
	public static void main(String[] args) {
        //(복습) 입력을 담당하는 Scanner 객체 선언
        Scanner scanner = new Scanner(System.in);
        System.out.print("환율(1달러)>>");
        //Scanner 클래스를 통해 데이터를 입력할 때
        //부동소수점을 입력받고 싶으면 nextDouble() 메소드를 활용
        double rate = scanner.nextDouble();
        //static 클래스이므로 클래스명 그대로 활용 가능
        CurrencyConverter.setRate(rate);
        //(복습)printf 내부 %0.2f를 활용해 소수점 두 자리 까지만 표현
        //% 를 포멧 스트링이라고 하며, ,(작은 따옴표) 뒤에 오는 변수(또는 상수)를 표현하는 역할을 한다.
        System.out.printf("백만원은 $%.2f 입니다.", CurrencyConverter.toDollar(1000000));
        System.out.printf("$100는 %.2f원 입니다.", CurrencyConverter.toKWR(100));
        //사용이 끝나면 Scanner 클래스를 종료해야 함
        scanner.close();
    }
}