package kh1224;

public class Ex14 {
    public static void main(String[] args) {
        //객체 변수를 생성하고 데이터를 입력
        SimplePair<String> pair = new SimplePair<String>("apple", "tomato");
        //getter 메소드를 통해 데이터를 획득
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
}
//가장 기본적인 제네릭 클래스 선언 방식
//클래스 명 뒤에 오는 꺽쇠 <T>로 표현하면
//클래스 내부의 모든 T는 인수로 부터 전달된 랩퍼 클래스 타입으로 변경된다
//만약 Integer라고 돼있으면 모든 T는 정수형이 되어 활용 가능하다
//Generics 사용법
//<>로 표현한다.
//<T>, <E>, <K>,<V>로 표현한다.
//<T>
//전달되는 객체가 클래스의 자료형(Type)으로 사용되는 경우
//<E>
//전달되는 객체가 클래스의 요소(Element)로 사용되는 경우
//<K>
//전달되는 객체가 클래스의 키(Key)로 사용되는 경우
//<V>
//전달되는 객체가 클래스의 값(Value)로 사용되는 경우
