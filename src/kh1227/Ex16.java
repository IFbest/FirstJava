package kh1227;

public class Ex16 {
    public static void main(String[] args) {
        //객체 생성, 자료형은 String
        GenericEx1<String> t = new GenericEx1<String> ();
        //GenericEx1 객체 생성시 가상 자료형 String의 자료형 명시

        //배열 변수 생성
        String[] ss = {"Ye~", "Ah~", "Seo"};
        //setter 메소드를 활용해 객체에 데이터 저장
        t.set(ss);
        //저장된 데이터 출력
        //제네릭 표현으로 인해 별도의 형변환이 필요가 없다
        t.print();

        //GenericEx1 t1 = new GenericEx1();
        //좋지 않은 사용
        //Integer[] s = {1,2,3};
        //t1.set(s);
        //t1.print();
    }
}
