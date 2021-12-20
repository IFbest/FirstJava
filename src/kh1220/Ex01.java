package kh1220;

public class Ex01 {
	public static void main(String[] args) {
		String str = "  한글 ABCD efgh  ";
		String result = "";
		
		for (int i=0; i<str.length(); i++) {
			//if문 조건을 활용해, 문자열의 공백문자 제거
			//이쯤 되면 보이겠지만 변수 역시 객체와 동일한 활용방식임을 알 수 있음
			//str.charAt(i) : str은 변수이면서 문자열 객체이고, charAt(i):문자열 관련 메소드임
			//str.charAt(num) : 문자열 str의num-1번째 문자를 획득
			//문자열 변수는 배열과 같이 주소값 처럼 돼 있음을 알 수 있음
			if(str.charAt(i) != ' ')
				//공백이 제거된 문자열을 result변수에 저장
				result += str.charAt(i);
		}
		System.out.println("원 문자열 ==>[" + str + "]");
		System.out.println("공백제거 ==>[" + result + "]");
	}
}
