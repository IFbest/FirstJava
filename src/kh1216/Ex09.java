package kh1216;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        char[][] borad = new char[3][3];
        int x, y;
        Scanner scanner = new Scanner(System.in);
        // 초기 2차원 배열지정
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                //초기 놔진 곳이 없으므로 빈 공간으로 표시
                borad[i][j] = ' ';

        do {
            // 그림판을 그림
            for (int i = 0; i < 3; i++) {
                //해당 위치에 ---을 표시할지, |을 표시할지 결정
                //그 사이 공간에 말을 표시
                System.out.println(" " + borad[i][0] + " | " + borad[i][1] + " | " + borad[i][2]);
                if (i != 2)
                    System.out.println("---|---|---");
            }
            System.out.print("다음 수의 좌표를 입력하시오(x y : ");
            //scanner를 활용해 int 타입의 값을 변수에 입력
            //nextInt(): 정수형 변수 입력
            x = scanner.nextInt();
            y = scanner.nextInt();
            //입력된 좌표의 배열값이 비어있지 않으면 에러 표시
            if (borad[x][y] != ' ') {
                System.out.println("잘못된 위치입니다.");
                continue;
            } else //아니라면 X표시(X표시가 플레이어)
                borad[x][y] = 'X';
            int i = 0, j = 0;
            // 이 부분은 컴퓨터가 자동으로 놓는 부분
            // 2차원 for문으로 비어있는 공간을 확인하면 for문을 빠져나감
            for (i = 0; i < 3; i++) {// 범위를 4까지로 늘리면 된다
                for (j = 0; j < 3; j++)
                    //0표시가 없는지 확인
                    if (borad[i][j] == ' ')
                        break;
                //이 조건을 실행하지 않으면 배열 범위를 넘어설 수 있음
                if (i == 3)
                    i--;
                if (j == 3)
                    j--;
                // X표시도 없는지 확인
                if (borad[i][j] == ' ')
                    break;
            }
            // 두 가지 모두 없는 것을 확인 한 후, 배열 범위 내에 좌표가 있으면 0출력
            if (i < 3 && j < 3)
                borad[i][j] = '0';
        } while (true);
    }
}