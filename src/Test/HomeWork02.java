package Test;

import java.util.Random;
import java.util.Scanner;

public class HomeWork02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
        String name = sc.next();
        System.out.println("생년월일을 입력하세요(yyyy/mm/dd): ");
        String birthdate = sc.next();
        
        int index = birthdate.indexOf("/");
        String year = birthdate.substring(0,4);
        int number;
        Random generator = new Random();
        number = generator.nextInt(10) + 1000;

        System.out.println("이름: " + name);
        System.out.println("생년월일: " + birthdate);
        System.out.println("학번: 17" + number);
        
        sc.close();
    }
 }
