package kh1220;

public class Ex09television {
	int channel;
	int volume;
	boolean onOff;
	
	void print() {
		System.out.println("채널은 " + channel + "이고 볼륨은 " + volume + "입니다.");
	}
	int getChannel() {
		return channel;
	}
	void setChannel(int ch) {
		channel = ch;
	}
}

/*
 * class Ex09{ public static void main(String[] args) { Ex09television tv = new
 * Ex09television(); tv.channel = 11;
 * 
 * System.out.println("현재 채널은 " + tv.channel + "입니다."); } }
 */
