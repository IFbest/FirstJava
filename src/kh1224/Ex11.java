package kh1224;

import java.util.StringTokenizer;

public class Ex11 {
    public static void main(String[] args) {
        //StringOkenizer : 문자열 관련 클래스
        //import java.util.StringTokenizer; 를 통해 import 해줘야 사용 가능
        //StringTokenizer의 생성자를 활용해 저장된 문자열의 분기점을 지정할 수 있다
        StringTokenizer st = new StringTokenizer("홍길동/장화/홍련/콩쥐/팥쥐", "/");
        //"/"분기로 문자열을 분리
        //st 객체는 위의 메소드를 통해 문자열 배열 형태로 변경되는데
        //hasMoreTokens을 활용하면 객체에 저장된 배열의 수 만큼 while문을 수행한다
        //만약 더 이상 남은 문자열이 없으면 false를 출력해 while문을 빠져나온다
        //이런 형태의 메소드가 다른 클래스 객체에도 많기 때문에 알아두면 좋다
        while (st.hasMoreElements())
            //스트링 토크나이저에 다음 토큰이 있으면 true 리턴
            System.out.println(st.nextToken());
    }
}