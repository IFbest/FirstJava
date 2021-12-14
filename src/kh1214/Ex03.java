package kh1214;

public class Ex03 {
	public static void main(String[] args) {
        int aa[] = {100, 200, 300, 400};
        int bb[] = new int[] {100, 200, 300};

        int cc[];
        cc = new int[] { 100, 200};
        int[] dd = new int[1];
        dd[0] = 100;
        int i;
     // 배열을 선언하고 생성하고 대입하는 여러가지 방법

        for (i = 0; i < 4; i++)
            System.out.printf("aa[%d]==>%d\t", i, aa[i]);
        System.out.printf("\n");
        
        for (i = 0; i< 3; i++)
            System.out.printf("bb[%d]==>%d\t", i, bb[i]);
        System.out.printf("\n");

        for (i = 0; i< 2; i++)
            System.out.printf("cc[%d]==>%d\t", i, cc[i]);
        System.out.printf("\n");

        for (i = 0; i< 1; i++)
            System.out.printf("dd[%d]==>%d\t", 0, dd[0]);
        System.out.printf("\n");
    }
 }