package kh1231;

import java.io.File;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) throws IOException {
        // #1-0. C드라이브내에 temp 폴더가 없는 경우 생성
        File tempDir = new File("C://temp");
        if (!tempDir.exists())//temp폴더가 없으면
            tempDir.mkdir();//temp폴더 생성

        // #1-1.파일객체 생성
        File newFile = new File("C:/temp/newFile.txt");

        // #1-2.파일이 없는 경우 실제 파일 생성
        if (!newFile.exists())//파일이 없으면
            newFile.createNewFile(); //파일 생성
        // temp 폴더가 없는 경우 예외 발생

        // #2. 파일 구분자
        File newFile2 = new File("C:\\temp\\newFile.txt");
        File newFile3 = new File("C:" + File.separator + "temp" + File.separator + "newFile.txt");
        File newFile4 = new File("C:/temp/newFIle.txt");

        System.out.println(newFile2.exists());
        System.out.println(newFile3.exists());
        System.out.println(newFile4.exists());
    }
}