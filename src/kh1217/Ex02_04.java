package kh1217;

public class Ex02_04 {
	// 문자열을 정수로 변환 할 때 발생하는 예외를 처리하는 프로그램 작성
    public static void main(String[] args) {
        String[] StringNumber = {"23", "12", "3.141592", "998"};

        int i =  0;
        try {
            for (i = 0; i< StringNumber.length; i++){
                int j = Integer.parseInt(StringNumber[i]);
                System.out.println("숫자로 변환된 값은 " + j);
            }
        }catch (NumberFormatException e){
            System.out.println(StringNumber[i] + "는 정수로 변환할 수 없습니다.");
        }
    }
}