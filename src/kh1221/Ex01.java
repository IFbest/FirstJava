package kh1221;

public class Ex01 {
    public static void main(String[] args) {
        // ex11Constructor [] c = new ex11Constructor[5];
        // 위와 같이 작성해도 되고, 객체 변수를 배열 형태로 생성하는 것도 가능하다.
        // 배열의 크기를 5로 지정
        Ex01Constructor[] c;
        c = new Ex01Constructor[5];

        // ex11Constructor(num) 메소드에 for문 변화에 맞춘 0 1 2 3 4 값을 입력
        for (int i = 0; i<c.length;i++)
            c[i] = new Ex01Constructor(i);

        // 이전 for문에서 입력 받은 0 1 2 3 4로 면적을 구하는 메소드 실행
        for (int i = 0; i<c.length; i++)
            // (int)c[i].getArea() 앞의 (int)를 활용해 부동소수점 데이터를 int형으로 형변환
            // 만약 소수점을 살리고 싶다면(int)를 없애면 되고
            // 소수점 자리를 조절하고 싶으면 printf 내부에 %.2f를 활용하면 가능
            System.out.print((int) c[i].getArea() + " ");
    }
}
//This의 필요성
// - 객체의 멤버 변수와 메소드 변수의 이름이 같은 경우
// - 다른 메소드 호출시 객체 자신의 레퍼런스를 전달할 때
// - 메소드가 객체 자신의 레퍼런스를 반환할 때
