package kh1214;

import java.util.Scanner;

public class Ex10 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] stack = new char[5];
        int top = 0;

        char carName = 'A';
        int select = 9;

        while (select != 3){
            System.out.printf("<1>자동차 넣기 <2>자동차 빼기 <3>끝 :");
            select = scanner.nextInt();
            switch (select){
                case 1:
                    if (top >= 5){
                        System.out.printf("터널이 꽉 차서 차가 못들어감\n");
                    }else {
                        stack[top] = carName++;
                        System.out.printf(" %c 자동차가 터널에 들어감\n", stack[top]);
                        top++;
                    }
                    break;
                case 2:
                    if (top <= 0){
                        System.out.printf("터널 안에 자동차가 모두 빠져나감\n");
                    }else {
                        top--;
                        System.out.printf(" %c 자동차가 터널을 빠져나감]\n", stack[top]);
                        stack[top] = ' ';
                        carName--; // 이게 없으면 carName계속 증가
                    }
                    break;
                case 3:
                    System.out.printf("현재 터널에 %d 대가 있음 \n", top);
                    System.out.printf("프로그램을 종료합니다.\n");
                    break;
                default:
                    	System.out.printf("1 2 3 중 입력하세요\n");
            }
        }
        scanner.close();
    }
 }