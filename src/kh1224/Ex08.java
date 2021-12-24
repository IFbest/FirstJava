package kh1224;
//제네릭 아주중요
//<T> 로 활용되며, 어떤 변수 타입이 오더라도 활용이 가능하다
//전달받을 변수 타입이 정해지지 않았을 때 사용 가능하다
interface  MyFunction6 <T>{
  // 인수에서 전달하는 변수 타입에 따라 String이 될 수도 있고 Integer가 될 수도 있다
  // 이런 대문자 변수들을 랩퍼 클래스라고 하며
  // 랩퍼 클래스 변수는 자체로 클래스가 된다(이미 정의돼있기 때문에 별도의 선언은 불필요)
  void print(T x);
}
public class Ex08 {
  public static void main(String[] args) {
      // 여기서 변수 타입은 String
      // toString 메소드를 통해 객체에 저장된 값을 출력할 수 있다
      MyFunction6<String> f1 = (x) -> System.out.println(x.toString());
      f1.print("ABC");
      // 여기서는 Integer로 서로 다르지만 변수 타입을 제네릭 변수로 받기 때문에 문제 없다
      // toString 메소드는 문자열만 출력 가능하기 때문에
      // Integer 변수의 경우 별도의 작업을 거쳐야 출력이 가능하다
      // 랩퍼 객체의 변환은 valueOf 메소드를, int의 변환은 parseInt()를 활용한다.
      MyFunction6<Integer> f2 = (x) -> System.out.println(x.toString());
      f2.print(Integer.valueOf(100));
  }
}