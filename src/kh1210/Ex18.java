package kh1210;
public class Ex18 {
    public static void main(String[] args) {
       int num = 0;

       while (true){//true일 경우 반복되는 조건문
           System.out.print(num + " ");
           num++;//num변수를 1증가
           if (num == 10)//num변수가 10이 되면
               break;//그만! 탈출!
       }
    }
}