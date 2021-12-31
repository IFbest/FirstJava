package kh1229;

public class InterfaceEx {
    //Comparable<T> 인터페이스 : compareTo(T obj)추상 메소드를 활용할 수 있음
    class NumUtil<T extends Comparable<T>> implements Maximum<T>{
        //NumUtil은 Comparable을 상속 받는 타입만 전달 받을 수 있고 Maximum을 구현
        T[] value;
        //데이터를 입력하는 메소드
        NumUtil(T[] value){
            this.value = value;
        }
        //배열 요소 중 가장 큰 값을 찾는 메소드
        public T max(){
            T v = value[0];
            //변수 v를 value의 첫 번째 값에 저장
            for (int i=0;i< value.length;i++){
                if (value[i].compareTo(v)>0) v = value[i];
        //value[i]의 값이 더 크면 v 변수 값이 저장, 가장 큰 값 추출
        //copareTo 메소드는 현재 객체와 매개변수로 전달받은 객체의 순서를 비교하여 작으면 음수
        //같으면 0 크면 양수를 반환
            }
            return v;
        }
    }//Comparable<T>는 제네릭 인터페이스로서 compareTo(T o)메소드가 선언되었습니다.
}
