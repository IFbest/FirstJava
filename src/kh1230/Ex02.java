package kh1230;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        //HashMap 객체를 활용해 키-값을 저장하고
        Map<String, String> st = new HashMap<String,String>();

        st.put("map", "지도");
        st.put("Java", "자바");
        st.put("school", "학교");
        //Scanner 객체와 do-while문으로 키를 검색하는 예제
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("영어 단어를 입력하세요 : ");
            String key = scanner.next();
            if (key.equals("quit")) break;
            System.out.println("단어의 의미는 " + st.get(key));
        }while(true);
        scanner.close();
    }
}
