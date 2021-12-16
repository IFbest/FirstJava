package Test;

import java.util.Scanner;

public class seats {
	 public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		  final int SIZE = 10;//변수의상수 10
		  int [] [] seats = new int[SIZE][SIZE];//2단배열생성
		  int i = 0;//카운트 수
		  int k = 0;//입력받는 변수

		  do {//일단실행
		   for (i=1; i<seats.length+ 1; i++) {//0부터 시작해서 +1
		    System.out.print(" " +i);
		   }
		   System.out.println(" ===============");
		   for (i=0; i<seats.length; i++){//배열수까지 증가하며 반복
		    System.out.print(" " + seats[1][i]);//2행의 값을 1씩증가하며 표시
		   }
		   System.out.println("  ===============");
		   System.out.print("원하시는 좌석번호를 입력하세요(종료는 -1): ");
		   k = sc.nextInt();//정수를 입력받고
		   if (k == -1){//-1을 받게되면
			   System.out.println("프로그램 종료");
		    System.exit(0);//시스템을 종료시킴
		   }else if (seats[1][k-1] == 1){//입력한 숫자-1(실제는0부터)이 1이면
		    System.out.println("이미 예약된 자리입니다.");//예약됨출력
		    System.out.println("===============");
		    continue;//다른 자리를 위해 계속 반복
		   }else if (seats[1][k-1] == 0){//입력한 숫자-1(데이터상0부터)가 0이면
		    seats[1][k-1] = 1;// 1값을 대입
		    System.out.println("예약되었습니다.");//예약되었다고 출력
		    System.out.println("===============");
		   }
		  }while (true);
		  }
		 }