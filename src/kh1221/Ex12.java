package kh1221;

import java.util.Scanner;

public class Ex12 {
    String title;
    String author;
    
    //접근제어자가 default인 출력 메소드
    void show() {
        System.out.print("(" + title + ", " + author + ")" + " ");
    }
    //클래스와 이름이 동일한 생성자
    public Ex12(String title, String author){
        this.title = title;
        this.author = author;
    }

    public static void main(String[] args) {
        //객체 변수를 각각 한 개씩 만드는 것이 아니라
        //배열을 활용해 하나 처럼 묶을 수 있음
        //이런 변수 묶음이 나중에 다양한 형태로 나타남
        Ex12[] book = new Ex12[2];
        
        //변수 입력을 돕는 Scanner 객체 변수 생성
        Scanner scanner = new Scanner(System.in);
        //for문을 활용해 정보를 입력
        for (int i = 0; i<book.length; i++){
            System.out.print("제목>>");
            //Scanner.nextLine() : 이 메소드를 활용해 문자열 데이터를 입력
            String title = scanner.nextLine();
            System.out.print("저자>>");
            //scanner.lextLine() :
            String author = scanner.nextLine();
            //입력된 데이터를 생성자 메소드를 활용해 묶음으로 입력
            book[i] = new Ex12(title,author);
        }
        //출력도 for문을 통해 한 번에 출력
        for (int i = 0; i<book.length; i++){
            book[i].show();
        }
        //System의 Input, Output과 관련된 객체는 종료해 주는 것이 좋음
        //안해준다고 컴퓨터가 파괴되는 것은 아니지만 꼭 close()메소드로 종료해주는 것이 좋음
        scanner.close();
    }
}
//기본 자료형 배열은 선언과 동시에 배열의 크기만큼의 메모리가 할당된다.
//하지만 객체 배열의 경우 요소가 되는 객체의 주소가 들어갈 메모리만 할당된다.
//예를 들어, 배열 5개를 선언한다고 해서 객체 5개가 만들어지는 것이 아니다.
//객체 5개가 들어갈 수 있는 주소들이 만들어지는 것이다.
//각 요소 객체는 직접 생성하여 저장해야 한다.

