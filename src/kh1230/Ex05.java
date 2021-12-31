package kh1230;

import java.io.IOException;

public class Ex05 {
    public static void main(String[] args) {
        String userName = "han";
        String input = "";
        int key;

        try {//SYSTEM.IN.READ()메소드는 try-catch 문으로 묶어야 한다
            System.out.print("이름 ==> ");
            //System.in.read() : 아스키코드 값으로 입력된 문자를 원문 그대로 출력하는 메소드
            //13은 엔터를 뜻하기 때문에 엔터를 치지 않으면 while문이 계속 작동해 input에 계속 입력됨
            while ((key = System.in.read()) != 13){
                //13아스키코드 -> CR(Enter/커서를 옮긴다)
                input += Character.toString((char) key);
                //입력한 키가 아스키코드 13(Enter를 치지 않을 경우)이 아닐 경우 무한 반복
                //input에 계속 추가됨
            }
            
        }catch (IOException e){
            e.printStackTrace();
        }
        if (userName.equals(input))
            System.out.println(input + "님 어서오세요");
        else System.out.println((input + "님 등록이 안되어 있습니다."));
    }
}
