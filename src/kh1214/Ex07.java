package kh1214;

public class Ex07 {
	public static void main(String[] args) {
        int[][] aa = new int[3][4];
        int i, k;
        int val = 1;

        for (i=0; i<3; i++){//2중for문
            for (k=0; k<4; k++){
                aa[i][k] = val;
                val++;
                System.out.printf("aa[%d][%d]=%d\t", i, k, aa[i][k]);
            }
            System.out.printf("\n");
        }
    }
 }