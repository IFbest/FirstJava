package kh0113;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class E08MessengerB {
    protected JTextField textField;
    protected JTextArea textArea;
    DatagramSocket socket;
    DatagramPacket packet;
    InetAddress address = null;
    final int myPort = 5555;//수신용 포트 번호
    final int otherPort = 2222;//송신용 포트 번호

    public E08MessengerB() throws IOException{
        MyFrame f = new MyFrame();
        address = InetAddress.getByName("127.0.0.1");//자신 IP
        //DatagramSocket : 데이터 접속을 허용하는 객체
        //UDP 방식으로 데이터를 전송하거나 받는 동작이 완료되면 연결을 끊는 방식이다
        socket = new DatagramSocket(myPort);
    }
    public void process(){
        while (true){
            try {
                byte[] buf = new byte[256];
                packet = new DatagramPacket(buf,buf.length);
                socket.receive(packet);//패킷을 받는다
                //받은 패킷을 텍스트 영역에 표시한다
                textArea.append("Recived : " + new String(buf) + "\n");
            }catch (IOException ioException){
                ioException.printStackTrace();
            }
        }
    }
    //내부 클래스 정의, ActionListener 를 통해 이벤트 발생시 동작
    class MyFrame extends JFrame implements ActionListener{
        //JFrame 객체를 활용해 GUI 생성
        public MyFrame() {
            //기본 설정 후
            super("MessengerB");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //JTextField 객체 삽입
            textField = new JTextField(30);
            textField.addActionListener(this);
            textArea = new JTextArea(20, 30);
            textArea.setEditable(false);
            JScrollPane scroll = new JScrollPane(textArea);
            JPanel panel = new JPanel();
            panel.add(scroll);

            //한 줄만 표시하는 JTextField 객체는 입력 창으로
            add(textField, BorderLayout.PAGE_END);
            //여러줄을 표시하는 textArea 객체는 출력 창으로 활용
            add(textArea, BorderLayout.CENTER);
            pack();
            setVisible(true);
        }
        //전송 이벤트가 실행되면
        public void actionPerformed(ActionEvent evt) {
            //textField에 작성된 데이터를 획득하고
            String s = textField.getText();
            //작성된 문자열 크기 만큼의 버퍼를 생성
            byte[] buffer = s.getBytes();
            DatagramPacket packet;

            //패킷을 생성한다
            //데이터를 전송하거나 받을 때 호라용되며, 데이터를 묶는 클래스
            //데이터를 받을 때는 new DatagramPacket(buuffer,buffer.length,address,otherPort);
            //이렇게 4가지 변수가 필요하며, 앞의 두 자리는 버퍼의 크기에 관련된 것이고
            //전송할 주소와 상대방의 포트번호가 필요로 한다
            //buffer 변수 안에 이미 s 문자열 정보가 들어있으므로 정송할 때 입력된 문자열을 가지고 있다
            packet = new DatagramPacket(buffer,buffer.length,address,otherPort);
            try {
                //패킷을 보낸다
                //send(packet) : packet 데이터그램 전송
                socket.send(packet);
            }catch (IOException e){
                e.printStackTrace();
            }
            //append 메소드를 활용해 문자열의 가장 마지막에 해당 멘트를 추가한다
            textArea.append("SENT : " + s + "\n");
            textField.selectAll();
            //문자상자의 출력 위치를 결정하는 메소드
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }

    public static void main(String[] args) throws IOException {
        E08MessengerB n = new E08MessengerB();
        n.process();
    }
}