package kh1230;

import java.util.HashSet;
import java.util.Set;

public class FindDupplication {
    public static void main(String[] args) {
        //HashSet<String> s = new HashSet<String>(); 차이점은 뭘까?
        Set<String> s = new HashSet<String>();
        String[] sample = {"단어", "중복", "구절", "중복"};
        for (String a : sample)
            if (!s.add(a)) // 중복으로 인해 HashSet에 저장되지 않는 데이터를 확인하는 방법
                System.out.println("중복된 단어 " + a);
        System.out.println(s.size() + "중복되지 않은 단어 : " + s);
    }
}
