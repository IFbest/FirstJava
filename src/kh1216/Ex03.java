package kh1216;

public class Ex03 {
    public static void main(String[] args) {
        //부동소수점 타입인 2차원 배열 score 변수 생성
        double score[][] = {{3.3, 3.4}, {3.5, 3.6}, {3.7, 4.0}, {4.1, 4.2}};
        //변수를 합할 double 타입 sum 변수 생성
        double sum = 0;
        //이전 예제와 동일한 2차원 for문을 활용해 2차원 배열의 데이터를 활용
        //score.length 를 활용해 score의 행의 개수 획득
        for (int year = 0; year < score.length; year++) {
            //score[year].length를 활용해 score의 열의 개수 획득
            for (int term = 0; term < score[year].length; term++) {
                sum += score[term][year];//score배열의 행의 개수와 열의 개수를 획득               
            }//sum/(n*m)을 활용해, 배열의 모든 변수 개수를 구하고 그 값으로 sum을 나눠 평균을 구함
            int n = score.length;
            int m = score[0].length;
            System.out.println("4년 전체 평점 평균은 " + sum / (n * m));
        }
    }
}