package kh1231;

import java.io.FileInputStream;

public class Ex08 {
    public static void main(String[] args) throws Exception {
        //c://aaa//data1.txt : 해당 경로의 파일을 객체로 만듦
        FileInputStream fis = new FileInputStream("c://aaa//data1.txt");
        int ch;
        byte[] bt = new byte[1024];

        int i = 0;
        //read 메소드를 활용하면 내부에 작성된 문자를 한 글짜식 읽어들인다
        while ((ch = fis.read()) != -1){
            bt[i] = (byte) ch;
            i++;
        }
        System.out.println(new String(bt));
        fis.close();
    }
}
