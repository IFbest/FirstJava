package kh1220;

public class Ex09{
	public static void main(String[] args) {
	Ex09television tv = new Ex09television();
	tv.channel = 11;
	
	System.out.println("현재 채널은 " + tv.channel + "입니다.");
	tv.print();
	}
}
