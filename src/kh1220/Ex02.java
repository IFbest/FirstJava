package kh1220;

public class Ex02 {
	public static void main(String[] args) {
		String str = "    ABCD efgh   ";
		
		System.out.println("원 문자열 ==>[" + str + "]");
		//.toUpperCase() : 문자열 변수를 모두 대문자로 변경
		System.out.println("원 문자열 ==>[" + str.toUpperCase() + "]");
		//.toLowerCase() : 문자열 변수를 모두 소문자로 변경
		System.out.println("원 문자열 ==>[" + str.toLowerCase() + "]");
		//.trim() : 문자열 양 끝단의 공백문자를 제거
		System.out.println("원 문자열 ==>[" + str.trim() + "]");
		//.replaceAll("A", "B") : 좌변의 문자 A를 B로 교체함
		System.out.println("원 문자열 ==>[" + str.replaceAll(" ", "") + "]");
	}
}
