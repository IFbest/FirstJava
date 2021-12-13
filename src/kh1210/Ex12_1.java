package kh1210;

public class Ex12_1 {
	public static void main(String[] args) {
        String str = "no news is good news";//해당 문자열
        int i, result = 0;
        char c;

        for (i = 0; i < str.length(); i++) {
            c = str.charAt(i);//c에 i값 문자열위치를 대입
            if (c != 'n') {//값이 n일경우 
                continue;
            } else
            result++;//result = result +1
        }
        System.out.printf(" 개수 : %d\n", result);
    }
}