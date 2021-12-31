package kh1230;

import java.util.ArrayList;

public class GenericTest {
    public static void main(String[] args) {
        //꺽쇠 안 변수 타입 생략 가능
        ArrayList all = new ArrayList<>();// 모든 종류 다 출력 가능
        all.add("대박"); all.add("금요일"); all.add(1);
        print(all);
        System.out.println();

        ArrayList<String> al2 = new ArrayList<>();//String만 출력가능
        al2.add("대박"); al2.add("금요일"); //al2.add(1);
        print(al2);
        System.out.println();

        ArrayList<Integer> al3 = new ArrayList<>(); //정수만 출력가능
        //al3.add("대박"); al3.add("금요일");
        al3.add(1);
        print(al3);
        System.out.println();
    }
    //System.out.println 메소드의 이름이 길기 때문에 따로 메소드를 만들어 활용할 수도 있다
    //이 때는 static 메소드로 지정해야 한다
    static void print(ArrayList al){
        for (int i=0;i<al.size();i++)
            System.out.print(al.get(i) + "\t");
    }
}
