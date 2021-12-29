package kh1228;

import java.util.Arrays;
import java.util.List;

public class UnboundedWildcard {
    public static void main(String[] args) {
        //List 인터페이스 : 자료구조 관련 클래스들에 상위 인터페이스(ArrayList 등)
        //Arrays : 항목 정렬, 검색, 비교 등 메소드를 제공하는 static 클래스
        //asList : 전달받은 배열 인자들을 List 객체 성분으로 변환시켜줌(무슨 뜻이지?)
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String> ls = Arrays.asList("one", "two", "three");
        //Arrays.asList로 설정된 데이터는 변경 불가
        //printList 클래스로 데이터 전송
        printList.printList(li);
        printList.printList(ls);
    }
}
//제네릭과 와일드카드
//제네릭은 전달받는 인수의 타입이 변하는 것에 대응해 유연하게 변화하기 위해 만들어졌다
//와일드 카드는 매개변수 내부의 타입 변수의 클래스 상속 관계에 따른 제약을 거는 목적으로 만들어짐
//와일드 카드는 상한 제한 하한 제한을 설정할 수 있음
