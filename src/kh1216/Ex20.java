package kh1216;

//Call by String
public class Ex20 {
  //메소드 생성
  public void setAddress(String addr){
      //매개변수를 받아들인 후 내부 문자열 변수 값 받아들임
      //하지만 지역변수이기 때문에 소멸
	//리턴값을 반환하지 않는 이상 값의 변동은 없다.
      addr = "경기도 성남시 중원구";
  }
  

  public static void main(String[] args) {
      String address = "서울시 강남구 논현동";
      Ex20 st = new Ex20();

      System.out.println("메소드 호출 전");
      //메소드 호출 전 저장된 변수 출력
      System.out.println("address = " + address);
      //메소드 실행
      st.setAddress(address);

      System.out.println("메소드 사용 후");
      //메소드 실행 후 변수 출력, 결과값 변화 없음
      System.out.println("address = " + address);
  }
}
//메소드 호출 전
//address = 서울시 강남구 논현동
//메소드 사용 후
//address = 서울시 강남구 논현동