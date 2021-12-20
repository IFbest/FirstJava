package kh1220;

class Ex04 {
    public static void main(String[] args) {
        String str1 = "Java Programming";
        String str2 = "Java Programming";
        String str3 = new String("Java Programming");

        System.out.println("원 문자열1 ==> [" + str1 + "]");
        System.out.println("원 문자열2 ==> [" + str2 + "]");
        System.out.println("원 문자열2 ==> [" + str3 + "]");
        // 문자열 변수의 저장방식
        // 문자열 변수는 특정 메모리*RAM)주소에 고정적으로 저장됨
        // 서로 다른 변수에 동일한 문자열을 저장했더라도 저장된 경로(주소)는 서로 다름
        // 내용이 같더라도 완전히 같은 데이터가 될 수 없음
        // 문자열1과 문자열2의 저장 결과가 같더라도 == 연산자를 사용하면 false가 뜨게됨
        // 저장 데이터만 비교하기 위해서 문자열1.equals(문자열2) equals 메소드를 활용해야 함
        System.out.println("문자열1 == 문자열2 결과 :\t" + (str1 == str2));
        System.out.println("문자열1.equals(문자열2) 결과 :" + str1.equals(str2));
        System.out.println("문자열1 == 문자열3 결과 :\t" + (str1 == str3));
        System.out.println("문자열1.equals(문자열3) 결과 :" + str1.equals(str3));
    }
}