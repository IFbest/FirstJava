package kh1213;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
        final int STUDENTS = 5; // 고정값이므로 상수로 선언, 배열의 갯수 사용
        int total = 0; // 초기화
        int[] aa = new int[STUDENTS]; // 5개의 방을 가진 배열 생성
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i<STUDENTS; i++){//상수인 STUDENTS를 비교대상으로
            System.out.print("성적을 입력하시오 : ");
            aa[i] = scan.nextInt();
            total += aa[i];
        }
        System.out.println("합계 : " + total);
        total /= STUDENTS; // 합계를 STUDENT(5명)로 나누면 평균
        System.out.println("평균 : " + total);
    }
 }