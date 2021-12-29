package kh1228;

import java.util.ArrayList;

public class ArrayList2 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("watermelon"); // add(stirng) 문자열 추가/수정
        al.add("apple");
        al.add("banana");
        al.add("watermelon");
        al.add("Jujube");
        al.add("banana");
        //size메소드를 활용하면 ArrayList 변수에 저장된 데이터 수를 알 수 있음
        System.out.println("Count : " + al.size());
        print(al);
        //앞 번호 순서에 저장된 데이터 정보 변경
        al.add(1, "kiwi");
        print(al);
        al.add(4, "peach");
        print(al);
        //remove 메소드로 해당 번째 저장된 데이터 제거
        al.remove(0);
        print(al);
        System.out.println("Index 3 : " + al.get(3)); // 3번째 배열의 값이 변함을 표시
        //contains : 해당 자료형 변수에 문자(열)가 저장돼있는지 여부를 확인
        System.out.println("Banana : " + al.contains("banana"));
        System.out.println("Banana : " + al.indexOf("banana"));//banana의 위치
        System.out.println("Banana : " + al.lastIndexOf("Banana"));//banana의 마지막위치

        for (int i = 0; i<al.size(); i++){
            if (al.get(i).equals("banana")){//banana 성분을 strawberry로 대체
                al.set(i, "strawberry");
            }
        }
        print(al);
    }
    //static 메소드로 코딩 순서와 무관하게 항상 메모리가 할당된 상태이다
    private static void print(ArrayList<String> al){
        //확장 for문을 활용해 저장된 데이터를 출력
        for (String str : al)
            System.out.print(str + "\t");
        System.out.println();
    }
}
