package kh1214;

public class Ex05 {
	public static void main(String[] args) {
        int aa[] = {10, 20, 30, 40, 50};
        int count, size;

        count = aa.length;
        size = count * Integer.BYTES;
        //int 변수의 용량인 4byte에 5를 곱한 20
        System.out.printf("배열 aa[]의 요소의 개수는 %d 입니다 \n", count);
        System.out.printf("배열 aa[]의 요소의 전체 크기는 %d 입니다 \n", size);
    }
 }