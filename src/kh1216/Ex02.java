package kh1216;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {10,20,30};
        for (int value:numbers){//확장 for문 형태
        	//for문 안에 변수를 선언하고, 변수에 배열 변수의 값을 입력
            System.out.printf("%d",value);
            //printf("%d", value) : %d(정수형 포멧스트링)을 활용해
			//정수형 변수 value에 저장된 값을 출력
        }
    }
}