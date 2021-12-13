package kh1213;

public class Return {
	public static void main(String[] args) {
		int hap = 0;
		int i;
		
		for (i = 1; i <= 100; i++) {
			hap += i; // 1~100 sum
			
			System.out.printf("1부터 100까지의 합은 %d입니다 \n", hap);//sum
			if (hap > 5000)
				return; //현재 메소드를 호출한 곳으로 복귀한다
		}
		System.out.printf("프로그램의 끝입니다"); // 한번도 실행되지 않는다
	}

}
