package kh0113;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class E01SimpleServer {
    public static void main(String[] args) {
        InputStream is;
        PrintWriter pw = null;
        ServerSocket serverSocket;
        Socket s1 = null;
        String data;
        BufferedReader br_in;
        try {
            //FileWriter 클래스로 파일 생성
            FileWriter writer = new FileWriter("out.txt");
            //ServerSocket 객체를 활용해 서버 생성
            serverSocket = new ServerSocket(5435);
            System.out.println("서버 실행 중");
            //소켓과 아이피를 확인해 클라이언트의 접근을 허용
            s1 = serverSocket.accept();
            //인풋 스트림 객체 생성
            is = s1.getInputStream();
            //인풋 스트림 정보를 BufferedReader에 저장
            br_in = new BufferedReader(new InputStreamReader(is));
            //PrintWriter 객체를 생성하고 writer 객체를 통해 생성된 out.txt 파일에
            pw = new PrintWriter(writer, true);
            while ((data = br_in.readLine()) != null){
                //System.out.println(data);
                //인풋스트림으로 전달받은 데이터를 파일에 한 줄씩 저장
                pw.println(data);
            }
            //out.close();
            //인풋아웃풋 스트림 관련 객체 종료
            pw.close();
            s1.close();
        }catch (IOException ie){
            ie.printStackTrace();
        }
    }
}
