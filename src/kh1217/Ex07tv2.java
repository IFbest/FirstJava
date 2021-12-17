package kh1217;

public class Ex07tv2 {
	// Ex07tv 클래스에는 필드만 존재함
	   public static void main(String[] args) {
	       //myTv객체 생성
	       Ex07television2 myTv = new Ex07television2();
	       myTv.channel = 7;
	       myTv.volume = 9;
	       myTv.onOff = true;
	       myTv.print(); // 메소드 활용

	       // yourTv 객체 생성
	       Ex07television2 yourTv = new Ex07television2();
	       yourTv.channel = 9;
	       yourTv.volume = 12;
	       yourTv.onOff = true;
	       yourTv.print(); // 메소드 활용
	   }
	   // 객체 변수의 원형 클래스느 ㄴ동일하지만 저장된 데이터는 서로 다르다
	    //이는 int형 변수라도 분수명에 따라 저장된 데이터가 다른 것과 마찬가지 이치
	    // 객체 역시 변수의 한 형태라는 것을 알 수 있다.
	}
	class Ex07television2 {
	    //필드(클래스 내 변수)
	    int channel;
	    int volume;
	    boolean onOff;

	    //print 메소드 : 변수 출력 양식
	    void print() {
	        System.out.println("채널은 " + channel + "이고 볼륨은 " + volume + "입니다.");
	    }
	}