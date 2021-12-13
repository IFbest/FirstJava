package kh1210;

public class Ex02_1_1 {
    public static void main(String[] args) {
        int i, k; // 변수 선언

        for (i = 2; i <= 9; i++) { //2단부터 9단까지
            for (k = 1; k <= 9; k++) { //각 단마다 곱해지는 수(1~9)
                System.out.printf("%d X %d = %d \n", i, k, i * k);
                // printf 의 서식 부분은 쉼표(,)로 구분 짓지 않는다.
            }
            System.out.println();
        }
    }
}