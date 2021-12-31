package kh1231;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex07 {
    public static void main(String[] args) {
        InputStreamReader in = null;
        FileInputStream fin = null;

        try {
            fin = new FileInputStream("c://aaa//data1.txt");
            //인코딩을 UTF-8 로 한다
            in = new InputStreamReader(fin, "UTF-8");
            int c;
            //getEncoding : 인코딩 형태를 읽어들임
            System.out.println("인코딩 문자 집합은 " + in.getEncoding());
            while ((c = in.read()) != -1){
                System.out.print((char)c);
            }
            //스트림 메소드는 코드가 종료될 때 같이 종료해줘야 한다
            in.close();
            fin.close();
       }catch (IOException e){
            System.out.println("입출력 오류");
        }
    }
}
