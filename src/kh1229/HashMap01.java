package kh1229;

import java.util.HashMap;
import java.util.Scanner;

public class HashMap01 {
    public static void main(String[] args) {
        //Map 객체도 자료구조형의 한 종류이고
        //키-값의 형태로 자료를 저장한다
        //그렇기 때문에 저장된 변수의 번호나 이런 것들이 중요하지 않다
        //HashMap 클래스는 대용량 자료를 검색하는데 뛰어난 능력을 발휘함
        HashMap<String, String> dic = new HashMap<>();
        //put 메소드를 활용해 키-값의 형태로 데이터를 저장한다
        dic.put("baby", "아기");
        dic.put("love", "사랑해");
        dic.put("apple", "사과");
        //Scanner 변수를 통해 데이터를 입력받음
        Scanner scanner = new Scanner(System.in);
        //while 내부에 true를 써 무한루프를 만듬
        while (true){
            System.out.print("찾고 싶은 단어는? : ");
            String eng = scanner.next();
            //if문을 활용해 조건을 만족하면 while문을 탈출하고 종료
            if (eng.equals("exit")){
                System.out.println("종료합니다");
                break;
            }
            //영문명(키)을 통해 조회된 맞는 것이 있으면 한글(값)으로 출력
            String kor = dic.get(eng);
            if(kor == null)
                System.out.println(eng + "는 없는 단어입니다.");
            else System.out.println(kor);
        }
        //Scanner 객체는 close() 메소드를 활용해 종료시켜 줘야함
        scanner.close();
    }
}
