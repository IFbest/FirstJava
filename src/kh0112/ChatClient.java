package kh0112;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("서버 IP");
        String ip = sc.nextLine();// nextLine():줄단위로 입력한 값을 반환
        System.out.println("보낼 메세지");
        String msg = sc.nextLine();
        Socket sk = new Socket(ip, 5005);//Socket(String host,int port)
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
        bw.write(msg);//객체를 쓴다(보낸다)
        bw.flush();//바로 보내라. 모든 데이터를 전송하라. //버퍼의 내용을 강제로 출력해라
        bw.close();//출력 객체 닫기
        sk.close();//소켓 객체 닫기
        System.out.println("보내기 성공");
    }
}
