package kh0107;

import javax.swing.*;

public class E07CarGameThread extends JFrame {
    class MyThread extends Thread {
        private JLabel label;
        private int x,y;

        public MyThread(String fname, int x, int y){
            this.x = x;
            this.y = y;
            //System.out.println(fname);
            label = new JLabel();
            //ImageIcon 타입으로 label 객체 생성
            label.setIcon(new ImageIcon(fname));
            //ImageIcon icon = new ImageIcon(fname);
            //label.setIcon(icon);
            label.setBounds(x,y,100,100);
            //사진이 출력되는 패널 설정(x,y,w-100,h-100)
            add(label);
        }
        public void run(){
            for (int i = 0;i<200;i++){
                //객체의 x좌표를 랜덤으로 더해서 갱신하고
                x += 10 * Math.random();
                //그 결과를 표시
                label.setBounds(x,y,100,100);
                repaint();
                Thread.yield();
                try {
                    //Thread 실행 간격을 0.1초로 지정
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                    //실행 결과를 System.out 객체가 아닌 String객체
                }
            }
        }
    }
    public E07CarGameThread() {
        //JFame 기본 설정
        setTitle("CarRace");//제목설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창을끄면 프로세스종료
        setSize(600,200);//창사이즈설정
        setLayout(null);//기본 레이아웃 배열 삭제
        //이후 3가지 쓰레드 객체 생성
        //아래 주석 코드와 다음 세 줄 코드는 같은 의미
//        (new MyThread("car1.gif",100,0)).start();
//        (new MyThread("car2.gif",100,50)).start();//항상 두번째가 승리하도록 조작
//        (new MyThread("car3.gif",100,100)).start();
        MyThread car1 = new MyThread("car1.gif",100,0);
        MyThread car2 = new MyThread("car2.gif",100,50);
        MyThread car3 = new MyThread("car3.gif",100,100);

        car2.start();
        setVisible(true);

        try {
            car1.sleep(100000);//차1번은 10초 쉬고 출발
            car3.join();//차3번은 10초쉬는 것이 끝나면 출발
            car1.yield();//runnable과 run상태를 오가게 한다. 근데 무조건양보하는 것은 아니다.
            car3.yield();//yield만으로는 조작이 불가능. 양보는 하나 그 양보가 무조건적인 양보는 아니다.
            car1.start();
            car3.start();
        }catch (InterruptedException e){
            return;
        }

    }

    public static void main(String[] args) {
        new E07CarGameThread();
    }
}
