package kh1230;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Suffle {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<=10;i++)
            list.add(i);
        //Collections.shuffle 메소드를 활용해 랜덤으로 데이터를 출력하는 예제
        Collections.shuffle(list);
        System.out.println(list);
    }
}
