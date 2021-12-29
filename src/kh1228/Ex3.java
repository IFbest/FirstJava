package kh1228;

public class Ex3 {
    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();

        String str1 = gm.<String>method1("안녕");
        String str2 = gm.method1("안녕");
        System.out.println(str1 + ", " + str2);//안녕, 안녕

        boolean bool1 = gm.<Double>method2(2.5, 2.5);
        boolean bool2 = gm.method2(2.5, 2.5);
        System.out.println(bool1 + ", " + bool2);// true, true

        gm.<String, Integer>method3("국어", 80); // 국어 : 80
        gm.method3("국어", 80); // 국어 : 80
    }// 제네릭 메소드_리턴타입 또는 매개 변수의 타입을 제네릭 타입으로 선언
}
//제네릭 타입 변수명이 한 개인 경우
//접근지정자 <T> T메서드이름 (T t)  {
//타입 T를 사용한 코드
//}
//제네릭 타입 변수명이 두 개인 경우
//접근지정자 <T, V> T메서드이름 (T t,V v){
//타입 T를 사용한 코드
//}
//매개변수에만 제네릭이 사용 된 경우
//접근지정자 <T> void 메서드이름 (T t){
//타입 T를 사용한 코드
//}
//리턴타입에만 제네릭이 사용된 경우
//접근지정자 <T> T 메서드이름 (int a){
//타입 T를 사용한 코드
//}