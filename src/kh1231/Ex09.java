package kh1231;

import java.io.BufferedReader;
import java.io.FileReader;


public class Ex09 {
    public static void main(String[] args) throws Exception{
        FileReader fReader = new FileReader("c:/Windows/win.ini");
        //FileReader로 c:/...ini파일 열기
        BufferedReader bReader = new BufferedReader(fReader);
        //행단위로 읽기 위해 BufferedReader 클래스 활용
        String str = null;
        //readLine : 파일 내용 행 단위로 읽어오는 메소드
        while ((str = bReader.readLine()) != null){
            //BufferedReader에서 파일의 한 행씩 읽기
            System.out.println(str);
        }
        bReader.close();
        fReader.close();        
    }
}
