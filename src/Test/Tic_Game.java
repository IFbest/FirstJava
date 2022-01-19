package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tic_Game extends JPanel implements ActionListener {
    JButton [][] buttons = new JButton[3][3];
    private char turn = 'X';
    public JButton resetButton = new JButton("리셋");


    public Tic_Game(){
        setLayout(new BorderLayout());
        //setLayout(new GridLayout(0,3,-5,-5));
        // GridLayout(행-3, 열-3, 수평간격-5, 수직간격-5)격자모양으로 배치
        Font f = new Font("Dialog",Font.ITALIC, 50);
        //Font(String name, int style,int size)
        for (int i =0; i<3; i++){// 게임판을 나타내는 2차원 배열을 초기화
            for (int j=0;j<3;j++){// 버튼을 격자모양으로 배치
                buttons[i][j] = new JButton(" ");//2차원 배열의 버튼 생성
                buttons[i][j].setFont(f);//버튼의 폰트 생성한 것 설정
                buttons[i][j].addActionListener(this);//액션 이벤트에 등록
                add(buttons[i][j]);//2차원 버튼 삽입
            }
        }
        add(resetButton,BorderLayout.SOUTH);
        //리셋버튼 폰트설정
        resetButton.setFont(new Font("Dialog", Font.BOLD,15));
        //리셋버튼에 이벤트액션 추가
        resetButton.addActionListener(this);
        //리셋버튼 크기를 따로 지정하기 위해 setPreferredSize사용
        resetButton.setPreferredSize(new Dimension(200,40));
    }
    @Override
    public void actionPerformed(ActionEvent e){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){//이벤트
                if (e.getSource() == buttons[i][j] && buttons[i][j].getText().equals(" ") == true) {
                    //텍스트가 ""버튼이 클릭되면 보드에 표시
                    if (turn == 'X') {//'X'일 때 이부분 실행
                        buttons[i][j].setText("X");
                        turn = 'o';
                        if (checkWin("X", i, j))
                            //checkWin("x",i,j)이겼는지 검사
                            System.out.println("X가 이겼음");
                        else if (isDraw())
                            //isDraw() 비겼는지 검사
                            System.out.println("비겼습니다.");
                    } else {//'o'일때 이부분 실행
                        buttons[i][j].setText("o");
                        turn = 'X';
                        if (checkWin("o", i, j))
                            //checkWin("o",i,j)이겼는지 검사
                            System.out.println("o가 이겼음");
                        else if (isDraw())
                            //isDraw() 비겼는지 검사
                            System.out.println("비겼습니다.");
                    }
                }
            }
        }
        if(e.getSource()==resetButton){//초기화 하는 버튼
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setText(" ");//빈칸넣으면 됨
                }
            }
            resetButton.setText("리셋");
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

    public static void main(String[] args) {
        JFrame f = new JFrame(); //객체생성
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Tic_Game());
        f.setSize(300,300);
        f.setVisible(true);
        f.setLocation(500,500);
    }
}