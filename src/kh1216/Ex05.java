package kh1216;

public class Ex05 {
    public static void main(String[] args) {
        int [][] array = {{10,20,30,40},
                {50,60,70,80},
                {90,100,110,120}};
        //3행 4열 크기의 배열
        for (int r = 0; r< array.length; r++){// 각 행 반복
            for (int c = 0; c<array[r].length; c++){ // 각 열 반복
                System.out.println(r + "행" + c + "열: " + array[r][c]);
            }
        }
    }
}
