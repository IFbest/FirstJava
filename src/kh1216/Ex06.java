package kh1216;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //공간이 3인 배열을 지정
        args = new String[3];
        //args에 대한 별도의 선언은 필요없지만 공간 지정은 필요
        args[0] = "-h";
        args[1] = "two";
        args[2] = "toto";
        //args 배열이 지정되었을 때
        //args 배열의 크기가 지정되지 않으면 if문이 동작하지 안ㅇ흠
        if (args.length >0){
            for (int i =0; i< args.length; i++)
                System.out.print(" "+ args[i]);
            // 배열의 첫 번째 성분이 -h 이면 HELP를 출력
            // args[0].equals("-h") : 성분의 주소는 관계없고 값만 같으면 true
            // a == b 의 경우 두 변수에 저장된 값의 값 뿐 아니라 저장된 주소의 위치 같아야함
            if (args[0].equals(("-h")))
                System.out.print("HELP ");
        }
        scanner.close();
    }
}
