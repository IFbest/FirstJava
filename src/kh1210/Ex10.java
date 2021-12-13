package kh1210;
import java.util.Scanner;

public class Ex10{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("수를 입력하시오: ");
        int number = in.nextInt();

        if (number % 3 == 0)// =는 대입의개념 ==는 비교의개념
            System.out.println("3의 배수입니다.");
        else
            System.out.println("3의 배수가 아닙니다.");
        in.close();
    }
}