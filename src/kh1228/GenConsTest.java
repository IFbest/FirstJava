package kh1228;

class StringUtil {
    private String value;
    //생성자에도 제네릭을 지정할 수 있으며 제네릭 클래스가 아니어도 가능
    <T extends CharSequence> StringUtil(T value){
        //클래스,인터페이스 상관없이 항상 extends사용
        //StringUtil su1 = new StringUtil(s);
        //T는 CharSequence를 상속받는 타입만 전달받을 수 있도록 ㅅ너언하고 StringUtil에 T value값 저장
        this.value = value.toString();
        //value값을 호출시키는 함수를 vaule에 저장
    }
    void printVal(){
        System.out.println("value: " + value);
        //printVal 함수 호출
    }
}
public class GenConsTest{
    public static void main(String[] args) {
        String s = new String("서울");
        //String 타입의 s는 서울이 저장된 String객체 생성
        StringBuffer sbuf = new StringBuffer("대전");
        //StringBuffer타입의 sbuf는 대전이 저장된 StringBuffer객체 생성
        StringBuilder sbui = new StringBuilder("대구");
        //StringBuilder타입의 sbui는 대구가 저장된 StringBuilder객체 생성
        StringUtil su1 = new StringUtil(s);
        //su1은 s가 저장된 StringUtil객체 생성
        StringUtil su2 = new StringUtil(sbuf);
        //su2는 sbuf가 저장된 StringUtil객체 생성
        StringUtil su3 = new StringUtil(sbui);
        //su3은 sbui가 저장된 StringUtil객체 생성
        su1.printVal();
        //su1에 저장된 값 출력
        su2.printVal();
        //su2에 저장된 값 출력
        su3.printVal();
        //su3에 저장된 값 출력
    }//접근지정자 <T extends 최상위클래스명> T 메소드이름(T t){//타입제한 기본문법 구조
    //부모클래스의 메소드 사용 가능
    //}
}
