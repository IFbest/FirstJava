package kh0113;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class E07ServerEx {
    public static void main(String[] args) {
        BufferedReader in = null;
        BufferedWriter out = null;
        ServerSocket listener = null;
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            //서버 소켓 생성
            listener = new ServerSocket(9999);
            System.out.println("연결을 기다리고 있습니다");
            //클라이언트로 부터 연결 요청 대기
            socket = listener.accept();
            System.out.println("연결되었습니다");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true){
                //클라이언트로 부터 한 행 읽기
                String inputMessage = in.readLine();
                //bye가 입력되면
                if (inputMessage.equalsIgnoreCase("bye")){
                    //채팅 종료
                    System.out.println("클라이언트가 bye로 연결을 종료하였음");
                    break;
                }
                System.out.println("클라이언트 : " + inputMessage);
                System.out.println("보내기 >>");//프롬프트?
                String outputMessage = scanner.nextLine();
                //키보드에서 읽은 문자열 전송
                //flush : oust 스트립 버퍼에 있는 모든 문자열 전송
                out.write(outputMessage + "\n");
                out.flush();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                //finally에서 프로그램이 종료될 때 입출력 관련 객체 종료
                scanner.close();
                socket.close();
                listener.close();
                //채팅을 강제 종료
            }catch (IOException e){
                System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");
            }
        }
    }
}
