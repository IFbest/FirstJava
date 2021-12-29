package kh1228;

//제네릭 인터페이스는 제네릭 클래스처럼 타입 매개변수를 사용하는 것입니다.
//선언하는 방법은 제네릭 클래스와 동일합니다.
interface Maximum<T extends Comparable<T>>{
    T max();
}
//제네릭 인터페이스 선언. Comparable을 상속받는 타입만 전달받을 수 있다.
class NumUtil<T extends Comparable <T>> implements Maximum<T>{
    T[] value;
    //NumUtil 은 Comparable 을 상속받는 타입만 전달 받을 수 있고, Maximum을 구현
    NumUtil(T[] value){
        this.value = value;
    }
    //제네릭 생성자 선언. 매개변수로 전달받은 배열을 value 필드에 참조
    public T max() {//max ()메소드를 타입 매개변수로 저장한다
        T v = value[0]	;
        //변수 v에 value 배열의 첫번째 값은 저장한다
        for(int i = 0; i < value.length; i++) {
            if (value[i].compareTo(v)>0)
                v = value[i];
        }
        return v;
    }
}
public class GenInterface {
    public static void main(String[] args) {
        Integer[] inum = {1,2,3,4,5};//Integer타입의 배열을 inum에 저장
        Double[] dnum = {1.0, 2.3, 3.0, 4.0, 5.0};
        //Double타입의 배열을 dnum에 저장
        String[] snum = {"1","2","3","4","5"};
        //String타입의 배열을 snum에 저장
        NumUtil<Integer> iutil = new NumUtil<Integer>(inum);
        //NumUtil<Integer> iutil은 제네릭 타입으로 <Integer> inum을 포함하는
        //NumUtil객체를 참조하는 변수
        NumUtil<Double> dutil = new NumUtil<Double>(dnum);
        //NumUtil<Double> dutil은 제네릭 타입으로 <Double> dnum을 포함하는
        //NumUtil객체를 참조하는 변수
        NumUtil<String> sutil = new NumUtil<String>(snum);
        //NumUtil<String> sutil은 제네릭 타입으로 <String> snum을 포함하는
        //NumUtil객체를 참조하는 변수
        //각 타입 매개변수를 Integer, Double, String으로 지정하는 제네릭 클래스의 언스턴스를 생성한다
        System.out.println("inum 최댓값 : " + iutil.max());
        System.out.println("dnum 최댓값 : " + dutil.max());
        System.out.println("snum 최댓값 : " + sutil.max());
    }
}
//제네릭 인터페이스를 선언했습니다.
//타입 매개변수는 extends Comparable로 선언했으므로 Comparable을 상속받는 타입만
//전달받을 수 있습니다.

//Comparable<T>는 java.lang에 제네릭 인터페이스로서 compareTo( T o ) 메소드가 선언되었습니다.
//compareTo() 메소드는 현재 객체와 매개변수로 전달받은 객체의 순서를 비교하여 작으면 음수, 같으면0,크면 양수를 반환합니다.