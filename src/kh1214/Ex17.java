package kh1214;

public class Ex17 {
	public static void main(String[] args) {
        System.out.println("숫자들의 합 : " + sum(new int[] {1, 2, 3, 4}));
    }// 이름이 존재하지 않는 무명배열이 생성 sum으로 전달
    public static int sum(int[] numbers){
        // 무명배열은 numbers로 들어간다 numbers가 배열의 이름
        int total = 0;
        for (int i = 0; i<numbers.length; i++){
            total = total + numbers[i];
        }
        return  total;
    }// total 과 numbers를 이용해 주진 인덱스들의 합을 구하고 total을 다시 sum으로 반환
}// 무명배열은 즉 배열을 만들어서 함수의 인수로 전달하고자 할 때 많이 사용된다
