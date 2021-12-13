package kh1210;
import java.util.Scanner;

public class Ex05_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("정수를 입력하세요: ");
        int time = sc.nextInt(); // 참조변수를 써야한다 sc
        int second = time % 60; //나머지 계산
        int minute = (time / 60) % 60;
        int hour = (time / 60) / 60;

        System.out.print(time + "초는");
        System.out.print(hour + "시간");
        System.out.print(minute + "분");
        System.out.print(second + "초입니다");

        sc.close();// 참조변수를 써야한다 sc
    }
}
