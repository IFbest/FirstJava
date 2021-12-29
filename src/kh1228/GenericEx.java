package kh1228;

public class GenericEx<T> {
    T[] data;
    public void setType(T[] _data){
        data = _data;
    }
    public void print(){
        for (int i = 0; i<data.length;i++){
            System.out.println(data[i]);
        }
    }
    public static void main(String[] args) {
//CharSequence : String과 다르게 인터페이스로 char 값을 읽을 수 있다
        GenericEx<CharSequence> gt = new GenericEx<>();//문자 배열
        String[] str = {"야호", "신난다", "화요일 이니까"};
        gt.setType(str);
        gt.print();
    }
}
//Integer 랩퍼 클래스로 인자 타입을 설정했다
//제네릭 매개변수로써 활요되기 위해서는 변수 타입을 랩퍼 클래스로 정의해야 한다
