package kh1214;

import java.util.Scanner;

public class Ex15 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//스캐너 사용 선언
        int s[] = {0, 10, 20, 30, 40 ,50, 60, 70, 80, 90 ,100 };//배열 선언 및 초기화(데이터 저장)
        int value, index = -1;//탐색 값, 탐색 위치 정의 
        System.out.printf("탐색할 값을 입력하시오 : ");
        value = scanner.nextInt();//탐색값 입력
        for (int i = 1; i<s.length; i++){
            if (s[i] == value)//배열 내 값 비교
                index = i;
        }// 같을 때 횟수(저장공간) 확인
        if (index < s.length && index >= 0)//저장 공간이 배열 범위 내에 있을 때
            System.out.println(" " + value + "값은 " + (index + 1) + "위치에 있습니다");
    }
}