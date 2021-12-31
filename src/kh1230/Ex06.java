package kh1230;

import java.io.FileInputStream;

public class Ex06 {
    // Stream
    // 스트림이란 데이터의 흐름
    // 인풋은 데이터를 수용
    // 아웃풋은 데이터를 외부로 전송
    // 인풋, 아웃풋은 수용하는 관점에 따라 변화한다
    // 데이터를 받아들이는 쪽은 인풋이지만 그 데이터를 전송한 쪽에서는 아웃풋이 되는 것이다
    public static void main(String[] args) throws Exception{
        //FileInputStream의 예외를 처리하기 위해 throws Exception을 추가한다
        //해당 경로에 저장된 파일의 내용을 읽어온다

        FileInputStream fis = new FileInputStream("c:/aaa/data1.txt");
        //FileInputStream을 준비하고 파일을 연다

        int ch;
        //지정된 파일의 입력된 내용을 한 개의 문자씩 읽어들인다.
        //모든 문자를 읽어들이면 -1을 출력해 while문을 빠져나온다
        while ((ch = fis.read()) != -1) // 파일에서 문자 하나를 read()로 읽어온다
                                        // 문자가 끝일 경우  -1을 반환한다.
            System.out.print((char) ch);// char로 변수형 변경
        fis.close();                    // 파일의 모든 내용을 처리한 후 닫는다
    }
}
