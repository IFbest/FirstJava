package kh1210;

public class Ex02_1 {
    public static void main(String[] args) {
        int i;
        for (i = 0; i <3; i++){
            System.out.printf("안녕하세요? \n");
            System.out.printf("##또 안녕하세요?## \n");
        }
        System.out.printf("\n\n");

        for (i = 0; i < 3; i++)
            System.out.printf("안녕하세요? \r\n");
        System.out.printf("##또 안녕하세요?## \n");
    }
}