package kh1216;

public class Ex04 {
    public static void main(String[] args) {
        // new int[4][]을 활용해 배열의 행 개수만 지정함
        int intArray[][] = new int[4][];
        // 각 행의 열 개수는 아래와 같이 별도로 지정할 수 있음
        intArray[0] = new int[3];
        intArray[1] = new int[2];
        intArray[2] = new int[3];
        intArray[3] = new int[2];

        //2차원 for문을 활용해, 배열 각 요소에 데이터 입력
        for (int i = 0; i< intArray.length; i++){
            for (int j = 0; j<intArray[i].length; j++)
            //아래 식을 통해 배열 성분의 행과 열의 위치에 따라 저장되는 값을 다르게 함
            //행 : 10의 자리, 열:1의 자리
                intArray[i][j] = (i + 1) * 10 + j;
            //2차원 for문을 활용해 저장된 배열변수를 출력함
        for (i = 0; i<intArray.length; i++){
            for (int j = 0; j < intArray.length; j++)
                System.out.print(intArray[i][j]+ " ");
            System.out.println();
                }
            }
        }
    }