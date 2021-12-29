package kh1228;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<String>a = new ArrayList<String>();
        //데이터를 입력받기 위해 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);
        //for문을 활용해 4개의 데이터 입력
        for (int i = 0; i <4; i++){
            System.out.print("이름을 입력하세요>>");
            String s = scanner.next();
            a.add(s);
        }
        //입력정보 출력
        for (int i = 0; i<a.size(); i++){
            String name = a.get(i);
            System.out.println(name + " ");
        }
        int longestIndex = 0;
        //입력값이 가장 긴 문자를 찾아냄
        for (int i =0; i<a.size();i++){
            if (a.get(longestIndex).length() < a.get(i).length())
                longestIndex = i;
        }
        System.out.println("\n가장 긴 이름은 : " + a.get(longestIndex));
        scanner.close();
    }
}
