package kh1214;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	        int aa[] = new int [100];
	        int bb[] = new int [100];
	        int i;

	        for (i = 0; i< 100; i++)
	            aa[i] = i * 2;//0부터 2단위로 200까지 들어감 총 100개

	        for (i = 0; i< 100; i++)
	            bb[i] = aa[99 - i];//aa의 99-i번째 배열이 bb에 대입됨 역순으로 대입

	        System.out.printf("bb[0]는 %d, bb[98]는 %d 입력됨\n", bb[1], bb[98]);
	        scanner.close();
	    }
	 }