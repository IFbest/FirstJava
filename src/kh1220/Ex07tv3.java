package kh1220;

public class Ex07tv3 {
	public static void main(String[] args) {
        // myTV 객체를 생성하고 데이터를 입력
        Ex07television3 myTv = new Ex07television3();
        myTv.channel = 7;
        myTv.volume = 9;
        myTv.onOff = true;
        // myTV의 channel 값 받아들임
        int ch = myTv.getChannel(); // myTv.channel의 값을 받아들임
        System.out.println("현재 채널은 " + ch + "입니다.");
        //myTv.channel값 출력
        //tv 객체 생성
        Ex07television3 tv = new Ex07television3();
        // tv 객체에 저장된 값은 없으므로 출력값도 없음
        tv.print();
    }
}// tv클래스는 myTv와 구조는 같지만 내부 데이터는 다른 별개의 인스턴스

class Ex07television3{
	int channel;
	int volume;
	int getChannel;
	boolean onOff;	
	//print 메소드 출력양식
	void print(){
		System.out.println("채널은 " + channel + "이고 볼륨은 " + volume + "입니다.");
	}
	//getChannel메소드 리턴양식
	int getChannel() {
		return 7;//myTv.getChannel();에 7리턴
	}
}