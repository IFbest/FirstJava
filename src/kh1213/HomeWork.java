package kh1213;

import java.util.Scanner;

public class HomeWork {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double totalscore;//소수점표시 필요하므로 실수형 변수
        String flag;
        String grade;
       

        do {
            System.out.print("과목의 이름을 입력하세요 : ");
            String coursename = sc.next();//coursename변수에 문자열 타입으로 받음
            System.out.print("출석점수를 입력하세요 : ");
            int attendscore = sc.nextInt();//attendscore변수에 정수형 타입으로 받음
            System.out.print("과제점수를 입력하세요 : ");
            int assignmentscore = sc.nextInt();
            System.out.print("중간점수를 입력하세요 : ");
            int midtermexamscore = sc.nextInt();
            System.out.print("기말점수를 입력하세요 : ");
            int finalexamscore = sc.nextInt();
            System.out.print("수시시험점수를 입력히세요 : ");
            int quizscore = sc.nextInt();
            totalscore = ((attendscore * 0.1) + (assignmentscore * 0.4) + (midtermexamscore * 0.2) + (finalexamscore * 0.2) + (quizscore * 0.1));

            if (totalscore >= 90){// 학점 등급을 위한 조건문
                grade = "A";
            }else if (totalscore >= 80){
                grade = "B";
            }else if (totalscore >= 70){
                grade = "C";
            }else if (totalscore >= 60){
                grade = "D";
            }else {
                grade = "F";
            }
            System.out.println("과목" + coursename + "의 총점 : " + totalscore);
            System.out.println("과목" + coursename + "의 학점 : " + grade);
            System.out.println("평점 : " + totalscore/25);//totalscore올림 표시 후 나누기25
            System.out.println("계속하기를 원하세요? 그렇다면 y를 아니면 n을 입력하세요 : ");
            flag = sc.next();
        }while (flag.equals("y"));
    }
}