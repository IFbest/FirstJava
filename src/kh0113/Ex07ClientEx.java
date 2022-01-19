package kh0113;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Ex07ClientEx {
    public static void main(String[] args) {
        BufferedReader in = null;
        BufferedWriter out = null;
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            //클라이언트 소켓 생성, 서버에 연결
            socket = new Socket("localhost",9999);
            //인풋 아웃풋 스트림 객체 생성
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true){
                //프롬프트
                System.out.print("보내기>>");
                //메시지 입력 후 전송
                String outputMesage = scanner.nextLine();
                //bye를 입력하면 프로그램 종료
                if (outputMesage.equalsIgnoreCase("bye")){
                    out.write(outputMesage + "\n");
                    out.flush();
                    break;
                }
                //입력한 문장을 out 객체로 즉시 전송
                out.write(outputMesage + "\n");
                out.flush();
                //서버로 부터 한 행 수집
                String inputMessage = in.readLine();
                //수집한 문장을 출력
                System.out.println("서버 : " + inputMessage);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                scanner.close();
                if (socket != null) socket.close();//클라이언트 소켓 닫기
                //서버가 종료되는 경우 등
            }catch (IOException e){
                System.out.println("서버와 채팅 중 오류가 발생했습니다.");
            }
        }
    }
}
