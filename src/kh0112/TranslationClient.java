package kh0112;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
//클라이언트가 사용하게 될 클래스(JFrame상속과 액션리스너 구현)
public class TranslationClient extends JFrame implements ActionListener {

    private BufferedReader in;
    private PrintWriter out;
    private JTextField field;
    private JTextArea area;
    //미리 예외처리한 생성자
    public TranslationClient() throws Exception, IOException{
        setTitle("클라이언트");//제목설정
        setSize(500,300);//사이즈설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//닫으면 프로세스종료
        setVisible(true);//보이게 설정

        field = new JTextField(50);//필드텍스트 생성자 50자까지 생성자
        field.addActionListener(this);//필드에 액션리스너 추가 (엔터감지용)

        area = new JTextArea(10,50);//10열50칸짜리 텍스트영역 생성자

        area.setEditable(false);//텍스트 에리어 수정 불가 설정(서버에서 나오는 출력값 수정 못하게)
        add(field, BorderLayout.NORTH);//보더레이아웃형식 위쪽에 텍스트필드 추가
        add(area, BorderLayout.CENTER);//보더레이아웃형식 중앙에 텍스트에어리어 추가
        //127.0.0.1 == localhost
        Socket socket = new Socket("localhost",9101);//클라이언트 소켓 생성자
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//사전값을 받아올 버퍼리더
        out = new PrintWriter(socket.getOutputStream(),true);//찾을 값을 입력할 프린트라이터

        //읽어들인 문자열을 JTextArea 끝에 추가한다.
        area.append(in.readLine() + "\n");//\n은 엔터
        area.append(in.readLine() + "\n");
    }
    @Override//엔터입력을 감지해줄 actionPerformed
    public void actionPerformed(ActionEvent arg0){
        out.println(field.getText());//클라이언트의 입력값
        String response = null;//null값 대입한 response
        try {//respnese에 입력대기
            response = in.readLine();
        }catch (IOException e){//readLine사용을위한 예외처리
            e.printStackTrace();
        }
        area.append(response + "\n");//에어리어에 리스폰값과 엔터(줄바꿈) 추가
    }
    //실행문
    public static void main(String[] args) throws Exception {
        TranslationClient client = new TranslationClient();
    }
}
