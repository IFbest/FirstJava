package Test;

import java.util.Random;
import java.util.Scanner;

public class Ex00 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random generator = new Random();

        System.out.print("이름을 입력해 주세요: ");
        String name = sc.nextLine();

        System.out.print("생년월일을 입력해 주세요 ex)yyyy/mm/dd: "); // '/'는 indexof < 해당 문자의 위치를 숫자로 반환
        String birthdate = sc.nextLine();

        int ramdomnumber;
        //int year = Integer.parseInt(birthdate.substring(0, 4));
        int month = Integer.parseInt(birthdate.substring(5, 7));
        int days = Integer.parseInt(birthdate.substring(8, 10));
        int num = birthdate.indexOf("/");
        //int rest; // rest는 나머지..

        ramdomnumber = generator.nextInt(10);
        while (true){
            if (num != -1){
                System.out.println("이름 : " + name);
                System.out.print("생년월일 : " + birthdate.substring(0, 4) + "년");
                if (month <= 9) {
                    System.out.print(birthdate.substring(6, 7) + "월");
                }else System.out.print(birthdate.substring(5, 7) + "월");

                if (days <= 9) {
                    System.out.println(birthdate.substring(9, 10) + "일");
                }else System.out.println(birthdate.substring(8, 10) + "일");

                System.out.print("학번 : 17100" + ramdomnumber);
                break;
            }else System.out.println("'/'를 포함하여 입력해 주세요.");
           
        }
        }
    }

