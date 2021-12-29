package kh1228;

import java.util.Vector;

public class Vector01 {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();
        v.add(5);
        v.add(4);
        v.add(-1);
        v.add(2, 100);
        //size : 벡터 내부에 저장된 데이터 수
        System.out.println("벡터 내의 요소 객체 수 : " + v.size());
        //capacity : 벡터 내부 총 저장곤간, 벡터는 변수의 개수가 증가함에 따라
        //10개 씩 저장공간을 늘리는 특징이 있다.
        //데이터 저장공간을 별도로 정하지 않으면서도 정한 것과 같은 효과를 얻으려는 의도로 보인다
        System.out.println("벡터의 현재 총량 : " + v.capacity());

        //벡터 내부에 저장된 데이터 출력
        for (int i = 0; i<v.size(); i++){
            int n = v.get(i);
            System.out.println(n);
        }
        int sum = 0;
        for (int i = 0;i< v.size();i++){
            //elementAt : 해당 번호에 저장된 데이터를 호출한다. get과 유사하다
            int n = v.elementAt(i);
            sum += n;
        }
        System.out.println("벡터에 있는 정수의 합 : " + sum);
    }
}
