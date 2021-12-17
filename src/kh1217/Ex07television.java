package kh1217;

public class Ex07television {
	///클래스 내부 필드
	static int channel;
	static int volume;
	static boolean onOff;
	//int channel;
	//int volume;
	//boolean onOff;

	public static void main(String[] args) {
		//객체 생성
		Ex07television tv = new Ex07television();
		//객체에 데이터 입력
		//객체에 데이터 입력 과정 객체명.필드명(클래스 변수명) = 수치;
		//tv.channel = 7;
		//tv.volume = 9;
		//tv.onOff = true;		
		channel = 7;
		volume = 9;
		onOff = true;
		//System.out.println("텔레비전의 채널은 " + tv.channel + "이고 볼륨은 " + tv.volume + "입니다.");
		System.out.println("텔레비전의 채널은 " + channel + "이고 볼륨은 " + volume + "입니다.");
	}
}