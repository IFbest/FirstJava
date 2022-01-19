package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Bingo extends JPanel implements ActionListener {
    private JButton[][] buttons = new JButton[3][3];			// 3x3 빙고 위치
    private int time=-1;										// 리셋 값
    private char turn = 'X';									//현재 표시할 모양 X,O인지 구분
    public JButton resetButton = new JButton("시작!!!");
    private JLabel resetLabel =new JLabel("리셋 횟수:"+"0");
    private JLabel whoIsWinner =new JLabel(" ");
    public Bingo() {
        setSize(1000, 350);
        setVisible(true);
        setLayout(new GridLayout(0, 3, 5, 5));
        Font f = new Font("Dialog", Font.ITALIC, 50);
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setFont(f);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }
        //


        for (int i = 0; i < 3; i++)			//시작 전 Tic-Tae-Toe 모양 띄워주기
        {
            buttons[i][0].setText("T");
        }
        buttons[0][1].setText("I");
        buttons[0][2].setText("C");
        buttons[1][1].setText("A");
        buttons[1][2].setText("C");
        buttons[2][1].setText("O");
        buttons[2][2].setText("E");
        resetButton.setFont(new Font("Dialog", Font.BOLD,15));
        resetButton.setBackground(new Color(150,50,70));
        add(resetButton);
        add(resetLabel);
        add(whoIsWinner);
        resetButton.addActionListener(this);			//리스너 및 버튼,라벨 부착
    }

    @Override
    public void actionPerformed(ActionEvent e) {				//마우스 클릭 리스너 오버라이딩
        for (int i = 0; i < 3; i++) {      //For문 돌리기
            for (int j = 0; j < 3; j++) {
                if (e.getSource() == buttons[i][j]      // 눌린 버튼이 공백인지 아닌지 확인하기
                        && buttons[i][j].getText().equals(" ") == true) {
                    if (turn == 'X') {               //X일 경우
                        buttons[i][j].setText("X");
                        turn = 'O';
                        if (checkWin("X", i, j))
                        {
                            System.out.println("X가 이겼음!");
                            whoIsWinner.setText("X가 이겼음!");

                        }
                        else if (isDraw())
                        {
                            System.out.println("비겼습니다.");
                            whoIsWinner.setText("비겼습니다.");
                        }
                    } else {
                        buttons[i][j].setText("O");
                        turn = 'X';
                        if (checkWin("O", i, j))
                        {
                            System.out.println("O가 이겼음!");
                            whoIsWinner.setText("O가 이겼음!");
                        }
                        else if (isDraw())
                        {
                            System.out.println("비겼습니다.");
                            whoIsWinner.setText("비겼습니다.");
                        }
                    }
                }
            }
        }

        if(e.getSource()==resetButton){         //초기화 하는 버튼
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setText(" ");
                    buttons[i][j].setBackground(null);
                }
            }
            resetButton.setText("리셋");
            time++;
            resetLabel.setText("리셋 횟수:"+time);
            turn='X';
            whoIsWinner.setText(" ");
        }
    }
    public boolean isDraw() {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                if (buttons[row][col].getText().equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(String mark, int r, int c)
    {
        if(buttons[r][0].getText().equals(mark)
                && buttons[r][1].getText().equals(mark)
                && buttons[r][2].getText().equals(mark))
        {
            for(int i=0;i<3;i++)
                buttons[r][i].setBackground(new Color(0,0,255));
            return true;
        }
        else if(buttons[0][c].getText().equals(mark)
                && buttons[1][c].getText().equals(mark)
                && buttons[2][c].getText().equals(mark))
        {
            for(int i=0;i<3;i++)
                buttons[i][c].setBackground(new Color(0,0,255));
            return true;
        }
        else if(
                buttons[0][0].getText().equals(mark)
                        && buttons[1][1].getText().equals(mark)
                        && buttons[2][2].getText().equals(mark))
        {
            buttons[0][0].setBackground(new Color(0,0,255));
            buttons[1][1].setBackground(new Color(0,0,255));
            buttons[2][2].setBackground(new Color(0,0,255));
            return true;
        }
        else if(
                buttons[0][2].getText().equals(mark)
                        && buttons[1][1].getText().equals(mark)
                        && buttons[2][0].getText().equals(mark))
        {
            buttons[0][2].setBackground(new Color(0,0,255));
            buttons[1][1].setBackground(new Color(0,0,255));
            buttons[2][0].setBackground(new Color(0,0,255));
            return true;
        }
        else{
            return false;
        }
    }
}

//


/*
class Ball{					//띄워줄 볼
    private int x=100;
    private int y=100;
    private int size=30;
    private int xSpeed=10;

    public Ball(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, size, size);
    }

    public void update()
    {
        x+=xSpeed*0.3*Math.random();
        if((x+size)>MyPanel.BOARD_WIDTH-size||x<0)
            xSpeed=-xSpeed;
    }
}*/


/*
public class MyPanel extends JPanel				//볼을 사용해서 만들 패널
{
    static final int BOARD_WIDTH=600;
    static final int BOARD_HEIGHT=500;
    private Ball ball=new Ball(100,100);		//공1의 위치지정
    private Ball ball2=new Ball(100,150);		//공2의 위치지정
    public MyPanel()
    {
        //this.setBackground(Color.GRAY);
        Runnable task=()->{				//Thread 설정
            while(true)
            {
                ball.update();
                ball2.update();
                repaint();
                try{
                    Thread.sleep(50);
                } catch(InterruptedException ignore){
                }
            }
        };
        new Thread(task).start();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        ball.draw(g);
        ball2.draw(g);
    }

    public static void main(String[] args)				//Main
    {
        JFrame frame= new JFrame();
        frame.setSize(1000, 1000);
        frame.setSize(MyPanel.BOARD_WIDTH,MyPanel.BOARD_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(new Bingo());
        frame.add(new MyPanel());

    }
}

*/
