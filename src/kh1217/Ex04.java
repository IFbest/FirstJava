package kh1217;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 3개를 입력하세요");
        int sum = 0, n= 0;
        //for문을 통해 3개의 변수를 입력 받는데
        for (int i = 0; i<3; i++){
            System.out.print(i + ">>");
            try {
                n = scanner.nextInt();
            }
            //만약 정수가 아닐 경우 catch문 실행
            catch (InputMismatchException e){
                System.out.println("정수가 아닙니다 다시 입력하세요!");
                scanner.next();//입력 스트림에 잇는 정수가 아닌 토큰 버린다
                //for문 증가를 취소시키고
                i--;
                //continue 문을 통해 루프를 다음으로 이동시킴
                //contunue문 : 반복문 내에서 컨티뉴 문이 실행되면
                //이후 반복문을 실행하지 않고 다음 반복문을 실행
                continue;
            }
            //문제가 없다면 try문이 실행되어 정상입력 받고 값을 합함
            sum += n;
        }
        System.out.println("합은 " + sum);
        scanner.close();
    }
}