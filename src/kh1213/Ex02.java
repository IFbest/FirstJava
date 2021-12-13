package kh1213;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
    System.out.print("평점을 입력하세요 : ");
    double grade = sc.nextDouble();//

    System.out.print("토익점수를 입력하세요 : ");
    int to = sc.nextInt();

    if (to >= 700 && grade >= 4.0){
        System.out.print("면접대상자");
    }else if (to >= 700 && grade >= 3.5){
        System.out.print("서류전형대상자");
    }else if (to >= 700 && grade >= 3.0){
        System.out.print("필기시험");
    }else {
        System.out.print("지원불가");
    }
    sc.close();
	}
}
