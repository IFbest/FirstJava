package kh0113;

import java.io.*;
import java.net.Socket;

public class E01SimpleClient {
    public static void main(String[] args) {
        OutputStream os;
        BufferedReader br_out;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            String data = null;
            //소켓 객체를 활용해 서버와 연동
            Socket s1 = new Socket("127.0.0.1",5435);//자신의 아이피 주소
            //아웃풋 스트림 객체를 생성
            os = s1.getOutputStream();
            //BufferedReader 객체에 FileReader 클래스를 활용해 write.txt 파일 정보 저장
            br_out = new BufferedReader(new FileReader("wrtie.txt"));
            //BufferedWriter 객체에 아웃풋 스트림의 결과로 전송될 데이터 저장 할 수 있는 객체 생성
            bw = new BufferedWriter(new OutputStreamWriter(os));
            //PrintWiter 객체를 생성해 파일에 저장된 데이터를 전송할 수 있도록 함
            pw = new PrintWriter(bw, true);
            while ((data = br_out.readLine()) != null){
                pw.println(data);
            }
            System.out.println("파일을 전송했습니다.");
            //전송이 완료되면 해당 객체들을 종료
            pw.close();
            s1.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
