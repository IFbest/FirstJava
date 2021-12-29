package kh1228;

public class Ex17 {
    public static void main(String[] args) {
        String[] language = { "C++", "C#", "JAVA"};
        //보통은 클래스명 없이 바로 활용 가능하지만 제네릭 타입을 활용하기 때문에 클래스 명을 사용해야 함
        String last = MyArrayAlg.<String>getLast(language);
        System.out.println(last);
    }
}
// 제네릭을 활용하는 경우 <형 안정성>
// - 유형이 엉뚱하게 바뀌지 않는다
// - 형안정성이 확보된다