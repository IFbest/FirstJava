package kh1223;

import java.util.Arrays;

public class Ex05 {
    public static void main(String[] args) {
        String [] strings = {"로마에 가면 로마법을 따르라.", "시간은 금이다", "펜은 칼보다 강하다"};
        //Array.sort : 내림차순 정리
        //타입, 매개변수 -> 실행문 - 실행문);
        //아래 식은 문자열의 수가 적은 순으로 배열의 순서를 바꾸는 식이다
        Arrays.sort(strings, (first, second) -> first.length() - second.length());
        //확장 for문을 활용해 정렬된 문자열을 출력
        for (String s: strings)
            System.out.println(s);
    }
}//인터페이스 구현한 부분을 람다식으로 바꾸어 할당(대입)한것이다.
//람다식은 기본적으로 함수를 만들어 사용하는 것이다.