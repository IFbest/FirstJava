package kh1216;

public class Ex18 {
    // (반복)객체 생성 해줬기 때문에 static 사용 안해도 됨
    public int increase(int n){
        //++n : 전위 연산, ++연산을 먼저 한 후 출력
        // 해당 줄에서 가장 먼저 연산이 수행됨
        //n++ : 후위 연산, 연산 결과는 줄이 바뀐(;기호가 개행(줄바꿈)이라는 뜻)후 연산 수행
        // 기존값 출력(n 먼저) 후 ++연산 나중 이런 식으로 외우면 편하다
        ++n;
        return n;
    }

    public static void main(String[] args) {
        int var1 = 100; // 객체 생성
        Ex18 val = new Ex18(); // 객체의 메소드를 활용해 result에 연산 결과를 저장
        int result = val.increase(var1);
        System.out.println("val1 : " + var1 + ", result : " + result);
    }
}