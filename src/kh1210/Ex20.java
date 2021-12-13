package kh1210;
import java.util.Scanner;

public class Ex20 {
    public static void main(String[] args) {
        double a, b, c;
        Scanner scan = new Scanner(System.in);

        System.out.print("밑변의 길이를 입력하세요: ");
        a = scan.nextDouble();
        System.out.print("높이의 길이를 입력하세요: ");
        b = scan.nextDouble();

        //빗변의 길이를 구한다
        c = Math.sqrt(a * a + b * b);
        System.out.println("빗변의 길이는 " + c + "이다.");
        scan.close();
    }
}

