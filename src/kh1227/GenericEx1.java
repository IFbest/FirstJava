package kh1227;

public class GenericEx1<T> {
	T[] v;
    //클래스 옆에<T>로 가상의 자료형 명시. 만약<T>를 붙이지 않는다면 변수 선언시에
    //T와 같은 가상의 자료형을 붙이는 것은 불가능하다. 따라서 가상의 자료형을 명시할 경우
    //클래스명 옆에<가상자료형명>을 입력해준다.

    //배열 타입의 인수가 주어졌으므로 매개변수도 배열로 주어져야 한다
    public void set(T[] n){
        v = n;
    }
    public void print() {
        //확장 for문을 활용해 데이터를 출력
        for (T s: v)
            System.out.println(s);
    }
}