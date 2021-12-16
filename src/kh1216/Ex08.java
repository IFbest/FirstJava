package kh1216;

import java.util.Arrays;

public class Ex08 {
    public static void main(String[] args) {
        final int SIZE = 10;

        int[] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            // 랜덤 메소드를 활용해, 0~99까지 SIZE수 만큼 난수 생성
            // Math.random() : 0이상 1미만의 난수가 생성되는데
            // 뒤에 발생시키고 싶은 난수-1 까지의 범위를 결정하는 수(여기서는 100)를 지정하고
            // 앞에 (int)로 형변환 시켜 정수형으로 사용
            int r = (int) (Math.random() + 100);
            // 0~99 까지 랜덤 실수 발생
            numbers[i] = r;
        }
        System.out.print("최초의 리스트: ");
        //확장 for문을 활용해 벼열에 저장된 데이터 출력
        for (int r : numbers)
            System.out.print(r + " ");
        //sort : 배열의 모든 성분을 오름차순 정리하는 메소드
        Arrays.sort(numbers);
        //데이터 정렬 메소드 => 배열의 데이터를 내림차순 정렬 numbers배열에 적용
        System.out.print("\n정렬된 리스트: ");
        //확장 for문을 활용해 정렬된 배열을 재출력
        for (int r : numbers)
            System.out.print(r + " ");
    }
}
