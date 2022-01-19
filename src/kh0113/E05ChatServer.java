package kh0113;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class E05ChatServer {
    public static void main(String[] args) {
        try {
            //ServerSocket 객체로 서버 가동
            ServerSocket ss = new ServerSocket(5005);
            System.out.println("서버 가동중");
            while (true){
                Socket client = ss.accept();
                //BufferedReader로 인풋 스트림 생성
                //클라이언트의 아웃풋 스트림을 전송받는 부분
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                //reader 한글로 보낼 때
                System.out.println(client.getInetAddress() + ">" + br.readLine());
                br.close();
                client.close();
            }
        }catch (Exception e){System.out.println(e.getMessage());
        }
    }
}


