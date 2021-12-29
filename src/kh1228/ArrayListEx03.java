package kh1228;

import java.util.ArrayList;

public class ArrayListEx03 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("MILK");
        list.add("BREAD");
        list.add("BUTTER");
        list.add(1,"APPLE");//1번 인덱스에 APPLE추가 BREA와 BUTTER밀림
        list.set(2, "GRAPE");//2번 인덱스를 GRAPE로 대체
        list.remove(3);//butter제거
        for (int i = 0; i<list.size();i++)
            System.out.println(list.get(i));
    }
}
