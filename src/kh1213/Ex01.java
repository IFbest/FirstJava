package kh1213;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("양의 정수를 입력 : ");
        int n = sc.nextInt();
        int i;

        System.out.println(n + "의 약수는 다음과 같다");
        for(i=1; i<=n; i++){
            if (n % i == 0)
                System.out.println(" " + i);
    }
    }
 }