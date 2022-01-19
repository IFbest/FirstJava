package kh0110;

import java.io.*;

public class WriteFile {
    public static void main(String[] args) {
        File file = new File("wrtie.txt");
        try {
            BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(new FileWriter(file,true));
            //true면 기존 파일의 내용에 추가한다.
            //PrintWriter : 출력과 관련된 클래스
            //FileWriter : 텍스트(문자) 파일을 저장할 때 사용
            //FileWritre("경로",true) : 경로명만 지정하면 기존 파일을 갱신하고
            //true를 쓰면 기존 파일에 추가 작성된다.

            String s;
            System.out.println("Exit : ctrl + Z");
            while ((s = in.readLine()) != null){
                out.println(s);//파일에 키보드로 입력한 문자열을 행단위로 출력한다.
                //out.print(s);
            }
            in.close(); out.close();
        }catch (IOException e){
            System.out.println("IOException");
        }
    }
}
