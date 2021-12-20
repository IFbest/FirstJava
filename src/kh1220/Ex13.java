package kh1220;

import java.util.Scanner;

public class Ex13 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.print(">>");
	
	Ex13Rectangel sq = new Ex13Rectangel();//객체 생성
	sq.width = sc.nextInt();//넓이값 정수형으로 받기
	sq.height = sc.nextInt();//높이값 정수형으로 받기
	int sqaure = sq.getArea();//메소드를 통해 변수에 값 저장
	
	System.out.println("사각형의 면적은 " + sq.getArea());
	}
}
