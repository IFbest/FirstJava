package kh0112;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class WebImageDownload {
    public static void main(String[] args) throws  Exception {
        String website = "https://t2.daumcdn.net/thumb/R720x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/guest/image/xahGXVwHnCHQlx7z4PyWOPFTyxw.JPG";
        System.out.println("" + website + "사이트에서 이미지를 다운로드합니다.");
        URL url = new URL(website);
        byte[] buffer = new byte[2048];
        //한번에 가져올 수 있는 크기를 지정하면 좋다.
        //보통 적게는 1024,2048 많게는 4096 정도의 크기로 지정
        try
            (InputStream in = url.openStream();
            //url.openStream : url주소를 inputStream에 넣어 준다.
            //InputStream : 바이트 단위 입력 스트림
            FileOutputStream out = new FileOutputStream("test.jpg");){
            //주어진 이름의 파일을 쓰기 위한 객체를 생성
            //기존의 파일이 존재할 때는 그 내용을 지우고 새로운 파일을 작성
            int length = 0;
            while ((length = in.read(buffer))!= -1){
                System.out.println("" + length + "바이트크기만큼 읽었음!");
                out.write(buffer,0,length);
            }
            in.close();
            out.close();
        }catch (Exception e){
            System.out.println("예외: " + e.getMessage());
        }
    }
}
