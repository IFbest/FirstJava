package kh1228;

import java.util.ArrayList;

public class Ex19 {
    public static void main(String[] args) {
        //ArrayList 객체 생성
        ArrayList<MyStudent> list = new ArrayList<MyStudent>();
        //ArrayList 내부 타입을 객체로 사용할 수도 있다.
        list.add(new MyStudent("이순신"));
        //list.add(new Integer(123));
        //리스트에 저장된 첫 번째 객체가 가진 name을 getter 메소드를 활용해 저장하는 구조
        MyStudent s = list.get(0);
        //MyStudent s = (MyStudent)list.get(0);
        //MyStudent s = (Integer)list.get(0);
        //저장된 이름을 출력한다.
        System.out.println("학생 이름 : " + s.getName());
    }
}
