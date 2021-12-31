package kh1229;

public class Ex01 {
    public static void main(String[] args) {
        Integer[] inum = {1,2,3,4,5};
        Double[] dnum = {1.0, 2.0, 3.0, 4.0, 5.0};
        String[] snum = {"1", "2", "3", "4", "5"};

        NumUtil<Integer>iutil = new NumUtil<Integer>(inum);
        //NumUtil<Integer>iutil은 제네릭 타입으로<Integer>inum을 포함하는 NumUtil객체를 참조하는 변수
        NumUtil<Double>dutil = new NumUtil<Double>(dnum);
        NumUtil<String>sutil = new NumUtil<String>(snum);
        System.out.println("inum 최댓값 : " + iutil.max());
        System.out.println("dnum 최댓값 : " + dutil.max());
        System.out.println("snum 최댓값 : " + sutil.max());
    }
}
