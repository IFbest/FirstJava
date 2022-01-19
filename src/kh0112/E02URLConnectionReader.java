package kh0112;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class E02URLConnectionReader {
    public static void main(String[] args) throws Exception {
        //URL 클래스를 생성하고
        URL site = new URL("http://www.erum4ever.kr/");
        //URL site = new URL("https://www.seoultech.ac.kr/index.jsp");
        //URLConnection 클래스를 활용해 URL 클래스에 Connection 설정
        URLConnection url = site.openConnection();
        //url.getInputStream : URLConnection 클래스에서 인풋 스트림(입력) 설정
        //입력받은 정보를 BufferedReader 객체에 저장하고
        BufferedReader in = new BufferedReader(new InputStreamReader(url.getInputStream()));
        //줄 단위로 String 변수에 저장
        String inLine = in.readLine();
        //inLine에 저장된 모든 데이터를 콘솔창에 출력
        while ((inLine = in.readLine()) != null)
            System.out.println(inLine);
        in.close();
    }
}
