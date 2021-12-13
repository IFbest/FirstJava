package kh1210;

import java.util.Scanner;

public class Ex07 {
    public  static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //System.out.printf("목표액 입력: ");
        //int aim = scanner.nextInt();
        final int aim = 1000;
        System.out.printf("목표액 : %d\n", aim);

        System.out.printf("실적 입력 : ");
        int result = scanner.nextInt();
        int bonus;

        if (result >= aim ){
            bonus = (result - aim) / 10;
            System.out.printf("보너스 : %d", bonus);
        }else
            System.out.printf("달성 실패!");
        scanner.close();
    }
}