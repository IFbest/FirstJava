package kh1229;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class IteratorEx2 {
    public static void main(String[] args) {
        //ArrayList 객체에 데이터를 저장하고
        ArrayList<String> al = new ArrayList<>();
        al.add("구렁이");al.add("팔렁이");al.add("칠렁이");
        al.add("구렁이");al.add("구렁삼");al.add("구렁사");
        //Iterator 객체를 활용해 ArrayList 변수의 데이터를 순서대로 출력
        Iterator<String> it = al.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("=================");
        //LinkedList 변수도 ArrayList와 마찬가지로 컨트롤이 가능하다
        LinkedList<String> kk = new LinkedList<>();
        //kk.animal에 String타입 배열로 하나씩 최대길이까지 삽입
        String[] animal = {"산토끼", "집토끼", "판토끼", "죽은토끼", "알카리토끼"};
        for (int i = 0;i<animal.length;i++){
            kk.add(animal[i]);
        }
        //for 향상문으로 출력해보기
        for (String str : kk)
            System.out.println(str);
        System.out.println(al);
        System.out.println(kk);
    }
}