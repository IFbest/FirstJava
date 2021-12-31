package kh1231;

import java.io.*;

public class Ex10 {
    public static void main(String[] args) throws IOException {
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            int c;
            //아웃풋 스트림을 활용해 data.bin 파일 생성(프로젝트 폴더 안에 생성됨)
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.bin")));
            out.writeDouble(3.14);
            out.writeInt(100);
            //writeUTF()메소드는 문자열 UTF-8의 변형된 형식으로 출력
            out.writeUTF("자신의 생각을 바꾸지 못하는 사람은 결코 현실을 바꿀 수 없다.");

            out.flush(); //flush() : 버퍼를 수동으로 비우기, 남은 것이 있다면 전부 비운다
            //먼저 버퍼된 파일 출력 바이트 스트림을 생성하고 이것을 생성자의 매개변수로 전달
            //data.bin 파일에 저장된 내용을 읽어들임
            in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.bin")));
            //data.bin 객체에 저장된 내용을 저장 형식에 맞춰 읽어들임
            System.out.println(in.readDouble());
            System.out.println(in.readInt());
            System.out.println(in.readUTF());
        }finally {//정상적이던 예외발생이던 실행한다.
            //코드가 정상 작동되면 finally를 통해 input, output 객체들을 종료시킴
            if (in != null){
                in.close();
            }
            if (out != null){
                out.close();
            }
        }

    }
}
