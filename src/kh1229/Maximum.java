package kh1229;

public interface Maximum <T extends  Comparable<T>>{
    //제네릭 인터페이스 선언, Comparable을 상속받는 타입만 전달 받음
    T max();
}
