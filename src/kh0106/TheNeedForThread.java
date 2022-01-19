package kh0106;

public class TheNeedForThread {
    public static void main(String[] args) {
        //#1 비디오 프레임 1~5
        int[] intArray = {1,2,3,4,5};
        //#2. 자막 번호 하나~다섯
        String[] strArray = {"하나","둘","셋","넷","다섯"};
        //#3. 비디오 프레임 출력
        for (int i=0;i<intArray.length;i++){
            System.out.println("(비디오프레임) " + intArray[i]);
            try {Thread.sleep(200);} catch (InterruptedException e){}
        }
        //#4. 자막번호 출력
        for (int i=0;i<strArray.length;i++){
            System.out.println("(자막번호) "+ strArray[i]);
            try {Thread.sleep(200);} catch (InterruptedException e){}
        }
    }//Thread는 CPU를 사용하는 최소단위이다
}//즉, 영화 끝나고 자막나오기 시작 --> 동시에 진행될 필요성 --> Multi-Thread
//Thread는 동시성(Concurrency)과 병렬성(Parallelism)을 가지고 수행
