package kh1224;

public class Ex15 {
    public static void main(String[] args) {
        //아래와 같이 서로 다른 자료형을 사용해도 되고
        OrderedPair<String, Integer> p1 = new OrderedPair<String, Integer> ("mykey", 12345678);
        //자료형이 같아도 상관 없다
        OrderedPair<String, String> p2 = new OrderedPair<String,String> ("Java", "a programming language");
        System.out.println(p1.getKey() + " " + p1.getValue());
        System.out.println(p2.getKey() + " " + p2.getValue());
    }
}
//클래스의 제네릭은 두 개 이상 지정할 수도 있기 때문에 활용성이 엄청나다
//보통 제네릭 쌍은 key & value 방식으로 사용되는데 다른 변수 타입으로 사용도 가능하다