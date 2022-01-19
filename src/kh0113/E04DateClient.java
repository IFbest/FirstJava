package kh0113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class E04DateClient {
    public static void main(String[] args) throws IOException {
        //클라이언트 측의 소켓 넘버와 서버 측의 소켓 넘버가 같으면 연결이 가능하다
        Socket s = new Socket("localhost", 9100);//127.0.0.1
        //BufferedReader 객체를 활용해 데이터를 받아들이는 InputStream을 생성하고 저장
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //InputStream으로 전송받은 데이터를 저장
        String res = input.readLine();
        System.out.println(res);
        //출력 후 시스템 종료
        System.exit(0);
    }
}
