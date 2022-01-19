package kh0110;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class E01HangmanGame {
    static String soLution;

    //static 메소드를 활용해 정답을 파악
    static boolean check(String s, StringBuffer a, char ch){
        int i;

        for (i=0;i<s.length();i++){
            //입력한 철자와 같은 곳이 있으면
            if (s.charAt(i) == ch)
                //해당 부분을 _ 에서 입력한 알파벳으로 변경
                a.setCharAt(i, ch);
        }
        //모든 부분이 동일하면 true를 출력해 프로그램을 종료
        for (i=0;i < s.length();i++)
            if (s.charAt(i) !=a.charAt(i))
                return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        char ch;
        Scanner scanner = new Scanner(System.in);
        BufferedReader in = null;
        String [] words = new String[100];
        int count = 0;
        int TRY = 0;

        //BufferdReader 객체인 in 객체에 sample.txt파일을 저장함
        in = new BufferedReader(new FileReader("sample.txt"));
        for (int i=0;i<100;i++){
            //readLine 메소드로 파일에 있는 한 문장만 저장함
            String s = in.readLine();
            //문장들을 모두 출력함
            System.out.println(s);
            //출력할 문장이 없으면 for문을 종료함
            if (s == null)
                break;
            //문장들을 words 배열에 한 줄씩 저장함
            words[i] = s;
            //저장된 문장의 총 갯수를 저장
            count++;
        }
        //랜덤으로 출력할 문장을 결정함
        int index = (new Random()).nextInt(count);
        soLution = words[index];

        //문자열 변수인 StringBuffer 객체로 정답을 저장함
        StringBuffer answer = new StringBuffer(soLution.length());
        //문장에 띄어쓰기는 빈 칸으로
        for (int i = 0;i<soLution.length();i++)
            answer.append(' ');
        //문자가 있는 경우는 _표시로 표기
        for (int i =0;i<soLution.length();i++){
            if (soLution.charAt(i) != ' ')
                answer.append('_');
        }
        //while문을 활용해 정답 추론
        while (true){
            //정답을 출력해서 볼 수도 있다
            //System.out.println("정답: " + solution);
            //문장을 찾기 위해 문자를 입력
            System.out.println("현재의 상태 : " + answer);
            System.out.println("글자를 추측하시오 : ");
            String c = scanner.next();
            //시도 횟수 표시
            TRY++;
            //입력에 따른 결과 출력 부분
            if (check(soLution,answer,c.charAt(0)) == true)
                break;
        }
        //결과를 출력
        System.out.println("정답 : " + answer);
        System.out.println("시도횟수 : " + TRY);
    }
}
