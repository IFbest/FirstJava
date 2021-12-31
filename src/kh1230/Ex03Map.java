package kh1230;

import java.util.HashMap;
import java.util.Map;

public class Ex03Map {
    public static void main(String[] args) {
        Map<String, Student> st = new HashMap<String, Student>();
        st.put("20090001", new Student(2009001, "구준표"));
        st.put("20090002", new Student(2009001, "금잔디"));
        st.put("20090003", new Student(2009001, "윤지후"));
        //얘들의 value값은 Student 클래스에 값만 전달하는 역할, 값은 조작이 가능하다
        System.out.println(st);

        st.remove("20090002");//금잔디 삭제
        st.put("20090003", new Student(20090003, "소이정"));//윤지후 -> 소이정 교체
        System.out.println(st.get("20090003"));
        //확장 for문으로 데이터 획득
        for (Map.Entry<String, Student> s : st.entrySet()){
            //저장된 키 값 출력
            String key = s.getKey();
            Student value = s.getValue();
            System.out.println("key =" + key + ", value = " + value);
        }
    }
}

class Student  {
    private int i;
    private String n;

    public Student(int i,String n) {
        this.i = i;
        this.n = n;
    }
    //toString : object 클래스의 내장 메소드로
    //Object 는 모든 클래스가 상속 받으므로 그 특성을 사용 가능
    @Override
    public String toString(){
        return n;
    }
}