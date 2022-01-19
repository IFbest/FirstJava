package kh0113;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class E02SimpleServer {
    public static void main(String[] args) {
        try {
            System.out.println("서비스 하기 위해 준비중입니다.");
            ServerSocket s = new ServerSocket(5434);
            System.out.println("서버가 동작중입니다.");
            //클라이언트의 접속을 허용(소켓과 ip를 맞춰야 함)
            Socket s1 = s.accept();
            //BufferedReader 객체에 InputSteram 정보를 입력한다
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //인풋아웃풋 스트림을 생성한다
            ObjectInputStream ois = new ObjectInputStream(s1.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(s1.getOutputStream());
            oos.writeObject("Simple Server에 접속하신걸 환영합니다.");
            while (true){
                //클라이언트에서 전송된 데이터를 출력한다
                System.out.println((String)ois.readObject());
                System.out.print("<Server> : ");
                //readLine 메소드를 활용해 콘솔창에 작성한 데이터가 저장된 in 객체의 문자열 내용을 획득
                String temp = in.readLine();
                //exit를 쓰면 종료
                if (temp.equals("exit")){
                    System.out.println("bye");
                    break;
                }
                //서버에서 입력한 문자를 아웃풋 스트림 객체에 실어 클라이언트로 전송
                oos.writeObject("<Server> : " + temp);
            }
            //객체들 종료
            oos.close();
            s1.close();
            //연결이 끊기면
        }catch (ClassNotFoundException eof){
            System.out.println("Client로 부터 연결이 끊어졌습니다. 종료합니다...");
            //시스템 종료
            System.exit(0);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
