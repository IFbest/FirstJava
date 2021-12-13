package Test;

import java.util.Scanner;

public class HomeWork01 {
    public static void main(String[] args) {
        String str; // 입력받는 문자열
        int index; // 지수
        char ch; // 마지막 문자
        String rest; // 남은 문자열
        String outputStr = ""; // 출력 문자열
        Scanner scan = new Scanner(System.in);

        System.out.print("길이가 3인 문자열을 입력하세요: ");
        str = scan.next(); // 문자열을 입력받는다
        System.out.println("입력 문자열 : " + str);// 입력한 문자열을 출력한다

        index = str.length() - 1; // str의 문자열 길이에서 1을 빼면 마지막 글자 인덱스 번호
        ch = str.charAt(index); // str의 마지막 문자를 끄집어 낸다
        rest = str.substring(0, index); // 마지막 문자를 제외하고 남은 문자열을 rest에 저장
        outputStr += ch; // str에서 끄집어 낸 문자를 출력 문자열의 끝에 추가("" + 끄집어낸 문자)

        index = rest.length() - 1; // rest의 문자열 길이에서 1을 빼면 마지막 글자 인덱스 번호
        ch = rest.charAt(index); // rest의 마지막 문자를 끄집어 낸다
        rest = rest.substring(0, index); // 마지막 문자를 제외하고 남은 문자열을 rest에 저장
        outputStr += ch; // rest에서 끄집어 낸 문자를 출력 문자열의 끝에 추가
        outputStr += rest; // rest를 출력 문자열의 끝에 추가

        System.out.println("출력 문자열 : " + outputStr); // 출력 문자열을 출력한다
    }
 }
