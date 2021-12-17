package kh1217;

class Ex07tv{
    int channel;
    int volume;
    //boolean 타입은 true/false 두 가지
    boolean onOff;
}
public class Ex07{
    public static void main(String[] args) {
        //같은 패키지 내부 ex07tv 클래스 객체 활용
        //(복습)같은 패키지 내 다른 클래스는 import 불필요
        Ex07tv tv = new Ex07tv();
        //객체에 변수값 저장
        tv.channel = 7;
        tv.volume = 9;
        tv.onOff = true;
        System.out.println("텔레비전의 채널은 " + tv.channel + "이고 볼륨은 " + tv.volume + " 입니다");
    }

}
