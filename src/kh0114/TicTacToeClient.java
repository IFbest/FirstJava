package kh0114;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TicTacToeClient extends Thread {
    private JButton[][] buttons = new JButton[3][3];
    // 버튼들의 배열로 보드를 표현
    private char me, other; // 나의 문자와 상대방 문자를 여기에 저장
    private JFrame frame; // 프레임 객체
    private JPanel panel; // 패널 객체, 여기에 보드가 보여진다.
    private JLabel message; // 서버로부터 오는 메세지를 보여주는 레이블이다.
    private Socket socket; // 서버와 연결된 소켓
    private BufferedReader input; // 입력 스트림
    private PrintWriter output; // 출력 스트림

    public TicTacToeClient() throws UnknownHostException, IOException {
        socket = new Socket("localhost", 9001); // 현재는 로컬 컴퓨터에서만 실행(바인딩)
        // 소켓으로부터 입력 스트림과 출력 스트림을 구한다.
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);

        // 애플리케이션의 GUI를 생성. Lab과 동일
        frame = new JFrame();//프레임 객체생성
        panel = new JPanel();//패널 객체생성
        //패널의 레이아웃설정 3열 3행 간격
        panel.setLayout(new GridLayout(3, 3, 5, 5));
        //폰트 설정
        Font font = new Font("Dialog", Font.ITALIC, 50);
        //라벨 설정
        message = new JLabel("여기에 메세지가 표시됩니다.");
        //창 닫으면 프로세스 종료
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.CENTER);//프레임에 패널중앙에 추가
        frame.add(message, BorderLayout.SOUTH);//프레임에 아래쪽에 라벨추가
        frame.setSize(300, 300);//프레임 사이즈 설정
        frame.setVisible(true);//보이게 설정

        // 패널에 3*3 격자형식으로 버튼을 추가
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                final int ii = i;
                final int jj = j;
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setFont(font);
                // 각 버튼에 이벤트 처리기를 붙인다. 람다식을 사용(단순하게표현가능)
                buttons[i][j].addActionListener(e -> {
                    buttons[ii][jj].setText("" + me);//나의 플레이마크를 저장
                    output.println("MOVE " + ii + " " + jj);//클릭한 위치 전송
                    if (me == 'X') {//'X'일 때 이부분 실행
                        if (checkWin("X", ii, jj))//mark
                            //checkWin("x",i,j)이겼는지 검사
                            System.out.println("X가 이겼음");
                        else if (isDraw())
                            //isDraw() 비겼는지 검사
                            System.out.println("비겼습니다.");
                    } else {//'o'일때 이부분 실행
                        if (checkWin("O", ii, jj))//mark
                            //checkWin("o",i,j)이겼는지 검사
                            System.out.println("O가 이겼음");
                        else if (isDraw())
                            //isDraw() 비겼는지 검사
                            System.out.println("비겼습니다.");
                    }
                });
                panel.add(buttons[i][j]);//패널에 버튼 추가
            }
        }
        panel.repaint();//진행상황 업데이트
    }
    // 스레드 클래스에서 작업을 기술하는 메소드
    public void run() {
        String response;
        try {
            response = input.readLine(); // 서버로부터 첫번째 명령어를 읽는다.

            if (response.startsWith("START")) { // START 명령어이면 경기를 시작
                me = response.charAt(6);//playerMark를 문자열에서 뽑아냄
                other = (me == 'X') ? 'O' : 'X';//3항연산자 조건이참이면 O 거짓이면 X(적설정)
                message.setText("경기가 시작됩니다.");//메시지(하단)에 문자열표시
                frame.setTitle("현재 경기자는 " + me);//프레임제목에 현재 플레이어를 표시
            }
            // 서버로부터 반복적으로 명령어를 읽어서 처리
            while (true) {
                response = input.readLine();//명령어를 입력받음
                if (response.startsWith("OTHER")) { // 상대방의 수를 보드에 표시
                    //명렁어에서 ?를 추출하여 정수형으로 변환하여 i에 대입
                    int i = Integer.parseInt(response.substring(6, 7));//행에 상대가 놓은 행자리를 입력
                    int j = Integer.parseInt(response.substring(8, 9));//열에 상대가 놓은 열자리를 입력
                    buttons[i][j].setText("" + other);//버튼에 위에서 설정한 적(O,X)을 대입
                    message.setText("상대방이 두었습니다. ");//하단 메시지 출력
                } else if (response.startsWith("PRINT")) { //명령어가 PRINT로 시작하면
                    message.setText(response.substring(6));//하단메시지에 출력
                }
                try {//0.2초마다 작동하도록 슬립 설정
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e ) {
            e.printStackTrace();
        } finally {
            try {//소켓 연결 끊기
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isDraw() {//비겼는지 검사
        for (int row=0;row<3;++row){
            for (int col=0;col<3;++col){
                if (buttons[row][col].getText().equals(" ")){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean checkWin(String mark, int r, int c){//이겼는지 검사
        return (buttons[r][0].getText().equals(mark)
                && buttons[r][1].getText().equals(mark)
                && buttons[r][2].getText().equals(mark))//행검사
                || (buttons[0][c].getText().equals(mark)
                && buttons[1][c].getText().equals(mark)
                && buttons[2][c].getText().equals(mark))//열검사
                || (buttons[0][0].getText().equals(mark)
                && buttons[1][1].getText().equals(mark)
                && buttons[2][2].getText().equals(mark))//대각선
                || (buttons[0][2].getText().equals(mark)
                && buttons[1][1].getText().equals(mark)
                && buttons[2][0].getText().equals(mark)//대각선
        );
    }
    public static void main(String[] args) throws UnknownHostException, IOException {
        TicTacToeClient client = new TicTacToeClient();
        client.start();//쓰레드 실행
    }
}
