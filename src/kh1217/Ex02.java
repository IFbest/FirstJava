package kh1217;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        //(복습) 데이터 입력이 가능한 Scanner 클래스 객체 변수인 scanner 생성
        Scanner scanner = new Scanner(System.in);
        // 나눠지는 수와 나누는 수 모두 int형으로 선언됨
        int dividend;
        int divisor;

        // scanner객체를 활용해 데이터 입력
        // (복습)nextInt() : int 형 변수 입력받음
        System.out.print("나뉨수를 입력하시오 : ");
        dividend = scanner.nextInt();
        System.out.print("나눗수를 입력하시오 : ");
        divisor = scanner.nextInt();
        //나눗셈이 될 때 소수가 되면 정수부만 남기고 버려지며(강제 형변환)
        //나누는 수가 0일 경우 무한 에러가 발생
        System.out.println(dividend + "를" + divisor + "로 나누면 몫은 " + dividend/divisor  + "입니다.");
        
        scanner.close();
    }
}