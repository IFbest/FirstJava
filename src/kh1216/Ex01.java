package kh1216;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] aa = new int[][] {{2,3,0}, {8,9,1},{7,0,5}};
        int sum = 0;
        for (int i = 0; i<aa.length;i++){
            for (int j = 0;j< aa.length;j++){
                sum += aa[i][j];
                System.out.println(i + 1 + "행의 합은" + sum);
                sum = 0;
            }
            System.out.println();
            for (i = 0; i < aa.length; i++){
                for (int j =0; j<aa.length; j++){
                    sum += aa[j][i];
                    System.out.println(i+1+"열의 합은" + sum);
                    sum = 0;
                }
                scanner.close();
            }
        }
    }
}
//내장 클래스인 Scanner 객체변수를 생성
//scanner 객체변수를 활용해 Scanner 클래스의 메소드를 활용(오버로딩)
//2차원 배열 선언
//크기를 설정하지 않았지만 초기화 과정에서 크기가 3X3으로 지정됨
//sum변수 생성
//2차원 배열 데이터를 활용하기 위한 2차원 for문
//aa.length 행의 개수를 나타냄, length 메소드를 활용
//aa.length 해당 행의 열의 개수를 나타냄
//내부 for문을 도는 동안 외부 행은 고정되기 때문에
//해당 행에 있는 데이터값의 합이 구해짐

//sum += aa[i][j] : sum = sum + aa[i][j] 이런 뜻
//내부 루프가 끝나면 합을 초기화 => 다음 행 계산
//행과 열의 위치가 바뀜, 위에서는 aa[i][j] 였고
//행과 열의 위치를 뒤바꿈으로써 해당 열의 행 값을 더하는 식이 완성
//i열이 고정인 상태에서 행의 값 합
//내부 루프가 끝나면 합을 초기화 =>다음 행 계산
// scanner.close() : System을 건드리는 Scanner 클래스 변수인 scanner을 종료