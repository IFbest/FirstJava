package kh1228;

public class GenMethodTest {
    //메소드에서 타입변수 T는 Number를 상속하는 하위 타입만,V는 T와 T를 상속하는 Number만 상속받는다.
    static <T extends Number, V extends T> boolean isInclude(T num,V[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] inum = {1,2,3,4,5};
        Double[] dnum = {1.0, 2.0, 3.0, 4.0, 5.0};
        String[] snum = {"one","two","three","four","five"};

        boolean b1 = isInclude(3, inum);
        System.out.println("결과 : " + b1);

        boolean b2 = isInclude(5.0, dnum);
        System.out.println("결과 : " + b2);

        //boolean타입의 b2에 dnum 5.0이 저장되어 있으면 출력값은 참, 그렇지 않으면 거짓
        //isInclude("one", snum);

        GenMethodTest.<Integer, Integer>isInclude(3, inum);
        GenMethodTest.<Double, Double>isInclude(5.0, dnum);
        //GenMethodTest.<String, String>isInclude("one",snum);
    }
}
