package kh1216;
//동일 패키지 내에 제작된 클래스는 import가 필요없다
//만약 동일 패키지가 아니라면 import를 통해 해당 패키지의 클래스를 import해줘야 한다.
public class Ex14 {
    public void plus(int a){
        System.out.println("결과값 = " + a);
    }

    public static void main(String[] args) {
        int a = 11;
        int b = 22;
        int result = 0;
        
        //11번과 12번 메소드를 활용
        Ex11 m = new Ex11();
        Ex13 m1 = new Ex13();
        //이전 예제에서 생성된 클래스를 끌어다 쓴다
        
        result = a + b;
        m1.print(10);
        m1.print(b);
        m1.print(result);
        m.print();
    }
}