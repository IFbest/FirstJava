package kh1213;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] s = new int[4];
        int hap = 0;

        for (int i = 0; i<s.length; i++){
            System.out.print((i+1)+ "번째 숫자를 입력하세요: ");
            //배열이 0부터라 +1로 보기좋게 만든다
            s[i] = scanner.nextInt();
        }

        for (int i = 0; i<s.length; i++){
            hap += s[i];//합에 배열을 추가입력 hap = hap + s[i]
        }
        System.out.print(" 합계==>"+ hap);
        scanner.close();
    }
 }