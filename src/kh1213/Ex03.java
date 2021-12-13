package kh1213;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
        double entrytime;
        double exittime;
        double ptime;
        String flag;//보통 맞다 아니다의 선택의 용도로 사용

        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("들어온 시간을 입력하세요:\t");
            entrytime = scan.nextDouble();//double실수형으로 입력받음
            System.out.println("나간 시간을 입력하세요:\t");
            exittime = scan.nextDouble();

            ptime = exittime - entrytime; //주차시간 계산
            double fee = 0.0; //실수형 fee초기화
            if (ptime > 0.0){ //주차시간이 0보다 클 시에
                if (ptime <= 1.0) //1보다 클 경우
                    fee = 1000;//fee에 1000 대입
                else {//아닐경우
                    fee = 1000 + Math.ceil(ptime - 1.0) * 500;//기본요금+주차시간(-1.0)올림처리x500
                    if (fee>10000) fee = 10000;//만약 10000초과라면 10000 대입
                }
            }
            System.out.println("주차요금은:\t" + fee);
            System.out.println("계속하기를 원하세요? 그렇다면 y를 아니면 n을 입력하세요:\t");
            flag = scan.next();
        }while (flag.equals("y"));//flag변수가 y와 같다면 반복
    }
 }

