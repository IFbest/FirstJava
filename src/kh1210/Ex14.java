package kh1210;

public class Ex14 {
    public static void main(String[] args) {
        int hap = 0;
        int i;

        myLabel: for (;;) { // 무한루프와 레이블 표시
            for (i = 1; i <= 100; i++) {
                hap += i;
                if (hap > 2000) {
                    System.out.printf("%d\n", hap);
                    hap = 0;
                    break myLabel;
                    // hap이 2000보다 크면 무한루프를 빠져나감 조건 안주면 아직도 반복중 무한 생성
                }
            }
            System.out.printf("아직도 반복중...\n");
        }
    }
}