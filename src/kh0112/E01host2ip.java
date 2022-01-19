package kh0112;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class E01host2ip {
    public static void main(String[] args) {
        String hostname = "www.naver.com";
        try {
            //InetAddress : 네이버의 IP 번호를 읽어들이는 클래스
            //getByName : 웹 주소로 부터 IP 정보를 읽어들임
            InetAddress address = InetAddress.getByName(hostname);
            //getHostAddress : 웹 주소의 IP 주소를 출력함
            System.out.println("IP 주소 : " + address.getHostAddress());
            //UnknownHostException : 호스트 주소가 정확하지 않을 때 실행되는 Exception
        }catch (UnknownHostException e){
            System.out.println(hostname + "의 ip주소를 찾을 수 없습니다.");
        }
    }
}
