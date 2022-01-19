package kh0113;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class E04Server {
    public static void main(String[] args) throws IOException {
        //ServerSocket 클래스를 생성해 클라이언트의 요청을 받기 위한 준비를 한다
        //이 부분이 서버가 됨
        ServerSocket ss = new ServerSocket(9100);
        try {
            while (true){
                //클라이언트의 요청을 받아들이는 accept 메소드를 활용해
                //Socket 객체 속성 지정
                Socket socket = ss.accept();
                try {
                    //PrintWriter 객체로 전송 받은 정보를 출력
                    //socket.getOutputStream으로 전송받은 정보의 OutputSteram생성
                    PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                    //OutputStream 정보 중 날짜 정보를 출력
                    out.println(new Date().toString());
                    //모든 명령이 종료되면 socket 객체와 ServerSocket객체를 종료시킴
                }finally {
                    socket.close();
                }
            }
        }finally {
            ss.close();
        }
    }
}
