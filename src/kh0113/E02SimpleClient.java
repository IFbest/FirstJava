package kh0113;

import java.io.*;
import java.net.Socket;

public class E02SimpleClient {
    public static void main(String[] args) throws IOException {
        if (args.length == 0){
            System.out.println("사용법 : java SimpleClient [server_name]");
            System.out.println("server_name을 입력하지 않으셔서 localhost로 접속을 시도합니다.");
            args = new String[] {"127.0.0.1"};
        } try {
            try {
                Socket s1 = new Socket(args[0], 5434);//소켓 객체 생성
                //인풋 스트림 데이터를 읽어들이는 BufferedReader객체 생성
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                //인풋 아웃풋 스트림 객체 생성
                ObjectOutputStream oos = new ObjectOutputStream(s1.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(s1.getInputStream());

                System.out.print("접속완료..");
                //서버에서 전송받은 문자열을 출력
                System.out.println((String) ois.readObject());

                System.out.println("서버에게 먼저 메시지를 보내십시오 !!");
                while (true) {
                    System.out.println("<Client> : ");
                    String temp = in.readLine();
                    if (temp.equals("exit")) {
                        System.out.println("bye~");
                        break;
                    }
                    //writeObject 메소드를 활용해 아웃풋 스트림 객체에 문자열을 실어 보냄
                    oos.writeObject("<Clent> : " + temp);
                    //인풋 스트림의 입력 내용을 콘솔창에 출력함
                    System.out.println((String) ois.readObject());
                }
                //객체 종료
                ois.close();
                s1.close();
            }catch (EOFException eof){}
        }catch (ClassNotFoundException eof){
            System.out.println("Server로 부터 연결이 끊어졌습니다. 종료합니다...");
            System.exit(0);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
