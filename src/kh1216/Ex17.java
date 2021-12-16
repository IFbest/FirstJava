package kh1216;

public class Ex17 {
    //1부터 입력된 값 까지 더하는 메소드
    public int summarize(int a){
        int sum = 0;
        //매개변수 a까지 합을 구함
        for (int i = 1; i <= a; i++){
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        int num3 = 100;
        int result = 0;
        //객체 변수 생성
        Ex17 m = new Ex17();
        result = m.summarize(num1);
        System.out.println("1에서 10 까지의 합은 : " + result);
        result = m.summarize(num2);
        System.out.println("1에서 20 까지의 합은 : " + result);
        //System.out.println("1에서 100까지의 합은 : " + m.summarize(100));
        result = m.summarize(num3);
        System.out.println("1에서 100 까지의 합은 : " + result);
    }
}