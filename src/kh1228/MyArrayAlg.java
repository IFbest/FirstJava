package kh1228;

public class MyArrayAlg {
    // static 메소드이므로 별도의 객체 생성 없이 바로 활용 가능
    // 전달 받은 타입과 같은 줄에 있는 T도 꺽쇠 안에 있는 T로 통일된다
    public static<T> T getLast(T[] a) {
        //가장 마지막 배열요소를 출력
        //length 메소드 : 배열에 저장된 요소 수를 출력
        return a[a.length -1];
    }
}// 제네릭 타입변수 N 숫자(Number)
// 객체생성시 제네릭타입을 지정하지 않으면 올 수 있는 Type중 최상위 클래스(Object)로 인식
//(즉, 아래 두 코드는 동일한 의미)
//MyClass mc = new MyClass();
//MyClass<Object> mc = new Myclass<>();

//클래스명<실제제네릭타입> 참조변수명 = new 클래스명<실제제네릭타입>(); <-- 이방법이 보기가 편함
//또는
//클래스명<실제제네릭타입> 참조변수명 = new 클래스명<생성자의 경우 내부타입 생략이 가능> ();