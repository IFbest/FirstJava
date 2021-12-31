package kh1230;

import java.util.HashSet;
import java.util.TreeSet;

public class HashSetEx {
    public static void main(String[] args) {
        //HashSet : Set 인터페이스를 상속받는 클래스
        //저장 데이터의 중복을 허용하지 않고 null은 하나만 허용함(이또한 중복을 허용하지 않는다는 뜻)
        //데이터 크기 가변
        //해당 객체 요소의 출력도 Iterator 클래스의 도움을 필요로 하는 듯(hasNext,Next,remove)
        HashSet<String> set = new HashSet<String>();
        set.add("Milk");
        set.add("Bread");
        set.add("Butter");
        set.add("Cheese");
        set.add("Ham");
        System.out.println(set);
        //TreeSet : HashSet과 유사하며 트리 구조로 돼 있어 데이터 검색 기능이 더 좋은 편
        TreeSet<String> st = new TreeSet<String>();
        st.add("Milk");
        st.add("Bread");
        st.add("Butter");
        st.add("Cheese");
        st.add("Ham");
        System.out.println(st);
    }
}
