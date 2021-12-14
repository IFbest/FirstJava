package kh1214;

import java.util.Scanner;

public class Ex09 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        System.out.printf("행 개수를 입력 : ");
        row = scanner.nextInt();
        System.out.printf("열 개수를 입력 : ");
        col = scanner.nextInt();

        int[][] aa = new int[row][col];

        int i,k;
        int val = 1;//val의 역할은? 대입될 값

        for (i=0; i<row; i++){
            for (k=0; k<col; k++){
                aa[i][k] = val;//각 칸에 값 대입
                val++;//1씩 증가
            }
        }
        for (i=0; i<row; i++){
            for (k=0; k<col; k++){
                System.out.printf("%3d", aa[i][k]);
            }
            System.out.printf("\n");
        }
        scanner.close();
    }
 }