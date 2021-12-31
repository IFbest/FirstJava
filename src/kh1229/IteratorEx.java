package kh1229;

import java.util.Iterator;
import java.util.Vector;

public class IteratorEx {
    //Iterator : 자료형 객체 변수 내부 데이터를 편하게 활용하기 위해 만들어진 클래스
    //hasNext(), next(), remove() 세 가지 메소드를 가지고 있다
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();
        //정수값을 다루는 제네릭 생성
        v.add(5);
        v.add(4);
        v.add(-1);
        v.add(2, 100);
        //사용 방법은 자료구조형 객체변수를 Iterator 변수에 대입하고
        Iterator<Integer> it = v.iterator();
        //대입받아 만들어진 Iterator 객체 변수에 메소드를 입력해 실행하는 방식이다
        while (it.hasNext()){
            int n = it.next();
            System.out.println(n);
        }
        int sum = 0;
        it = v.iterator();
        while (it.hasNext()){
            int n = it.next();
            sum += n;
        }
        System.out.println("벡터에 있는 정수 합: " + sum);
    }
}
