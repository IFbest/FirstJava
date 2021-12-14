package kh1214;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] aa = new int[4];//선언 = 생성
        int hap = 0, i; // int hap = 0 , int hap = i

        for (i=0; i <= 3; i++){//3이하까지 반복
            System.out.printf("%d번째 숫자를 입력하세요 : ", i + 1);
            aa[i] = scanner.nextInt();//배열에 정수형으로 입력받음
        }

        hap = aa[0] + aa[1] + aa[2] + aa[3];//총합
        System.out.printf("합계 ==> %d\n", hap);
        scanner.close();
    }
 }