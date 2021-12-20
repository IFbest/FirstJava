package kh1220;

class Ex03 {
    public static void main(String[] args) {
        String str1 = "Java Programming";
        String str2 = "Java IT CookBook";

        System.out.println("원 문자열1 ==> [" + str1 + "]");
        System.out.println("원 문자열2 ==> [" + str2 + "]");
        // A.compareTo(B) : A와 B의 문자열 단어 중 차이가 나는 첫 단어의 ASCII 코드  차이
        // ASCII 코드 : 숫자만 인식할 수 있는 컴퓨터에 문자를 활용하기 위한 표
        // 컴퓨터에 문자 데이터로 숫자 데이터가 들어오면
        // ASCII 코드나 UNICODE 등 지정된 코드표에 숫자 데이터와 매칭되는 문자데이터로 변환
        // 숫자만 아는 컴퓨터에 문자 데이터를 주고 받기 위해 만들어진 표
        // 영화 마션에 나옴
        System.out.println(str1.compareTo(str2));
        //아스키 코드 기반 A B 같으면 0  A B보다 크면 양수반환 A B 작으면 음수
        System.out.println(str1.contains("Java"));
        //"Java"문자열을 포함하고 있냐? true/false
    }
}
