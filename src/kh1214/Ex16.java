package kh1214;

public class Ex16 {
	public static void main(String[] args) {
        final int SIZE = 6; // 주사위 6면체 상수 선언
        int freq[] = new int[SIZE];// 6개의 공간을 갖는 배열 선언
        for (int i = 0; i< 10000; i++)//
            ++freq[(int) (Math.random() * SIZE)];//전치라 먼저 증가 [n]=n+1
        // Math.random() * SIZE : 0~5사이의 난수 발생 후 int 형변환,배열 공간 설정
        // ++freq 난수가 발생할 때 마다 해당 공간에 +1
        System.out.println("===================");
        System.out.println("면빈도");
        System.out.println("===================");

        for (int i=0; i<SIZE; i++)
            System.out.println(" " + (i+1) + "\t" + freq[i]);
        
        System.out.println(1+ (int) (Math.random() * 10000));
    }
}
//각각 면마다 나온 횟수 출력
//배열에서 처음은 0부터 시작하니 각면 빈도가 원래는 0~5로 출력되지만
//그걸 1~6까지로 변경해 주려고 ""+(i+1)로
