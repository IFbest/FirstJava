package kh0112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TranslationServer {
    public static void main(String[] args) throws Exception {
        System.out.println("영어 번역 서버가 실행중입니다.");
        int clientId = 0;//클라이언트 1개당 1증가될 변수
        ServerSocket ss = new ServerSocket(9101);//서버소켓 생성자 포트 9101
        try {
            while (true){
                clientId++;//클라이언트 카운트1증가
                //클라이언트 접속을 기다리는 통역가 쓰레드 객체생성
                Translator t = new Translator(ss.accept(), clientId);
                t.start();//통역가 쓰레드 실행
            }//위에서 throws로 예외처리를 했기 때문에 catch필요 없음
        }finally {//예외처리 발생여부를 떠나 무조건 실행
            ss.close();//서버 소켓 닫기
        }
    }//쓰레드 상속하는 스태틱 통역가 클래스
    private static class Translator extends Thread {
        private Socket socket;
        private int myId;

        public Translator(Socket socket,int clientId){
            this.socket = socket;//소켓
            this.myId = clientId;//정수형 고객아이디
        }
        public void run() {
            try {//클라이언트소켓으로부터 입력을 받는 버퍼리더 생성자
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //클라이언트소켓한테 출력을 해줄 프린트라이터 생성자
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                out.println("안녕하세요?클라이언트 번호는 " + myId + "입니다.");//1씩증가하는 myId
                out.println("단어를 입력하세요");
                while (true){//버퍼리더의 메소드인 readLine
                    String input = in.readLine();//문자열 입력받음
                    if (input == null){//입력값이 없다면 탈출
                        break;
                    }
                    if (input.equals("java") == true)//입력값이 java와 같다면
                        out.println("java->자바");//통역값 출력
                    else//저장되지 않은 단어는 의외의 조건으로
                        out.println("조금 쉬운 단어를 보내주세요.");
                }
            }catch (IOException e){//readLine입력을 위한 예외처리
                System.out.println("클라이언트 번호: " + myId + "처리 실패" + e);
            }finally {//예외발생과 상관없이 무조건 실행
                try {
                    socket.close();//소켓 닫기
                }catch (IOException e){//소켓을 닫기위한 예외처리
                    System.out.println("소켓 종료 오류" + e);//예외 발생시 출력
                }
                System.out.println("클라이언트 번호: " + myId + "처리 처리 종료");
            }
        }
    }
}
