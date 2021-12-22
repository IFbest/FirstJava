package kh1221;

//세 가지 클래스 객체를 생성해 활용
//코딩할 때 몇 개의 객체변수를 사용해도 상관 없음
public class Ex03 {
  public static void main(String[] args) {
      //회원정보 클래스, 필드 변수만 있을 뿐, 특별한 것 없음
      Ex03Member member = new Ex03Member();
      member.regMember();
      member.modMember();
      
      //차량 정보 클래스, 역시 변수 이외에 구현된 것 없음
      Ex03Car car = new Ex03Car();
      car.checkCarInfo();
      car.midCarInfo();
      
      //예약 메소드, 변수 외에 구현된 것 없음
      Ex03Reserve reserve = new Ex03Reserve();
      reserve.reserveCar();
      reserve.modReserveInfo();
      reserve.cancelReserveInfo();
  }
}
