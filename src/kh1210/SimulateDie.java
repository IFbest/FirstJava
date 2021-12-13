package kh1210;
import java.util.Random;

public class SimulateDie {
    public static void main(String[] args) {
        Random generator = new Random();
        int randomnumber;
        randomnumber = generator.nextInt(6) + 1;
        System.out.println("난수: " + randomnumber);
    }
}//왜 6까지 나올까? 0부터 시작하여 +1을 해주는 값이므로 최대값은 6

