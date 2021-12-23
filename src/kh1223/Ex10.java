package kh1223;

public class Ex10 extends Ex10Calculator {
    //@Override : 오버라이딩 되는 메소드임을 표시하는 어노테이션
    @Override
    //여기 추상 메소드들이 상세하게 표현됨
    public int add(int a, int b){
        return a + b;
    }
    public int subtract(int a, int b){
        return a - b;
    }
    public double average(int[] a){
        double sum = 0;
        for (int i = 0; i<a.length;i++)
            sum += a[i];
        return sum / a.length;
    }

    public static void main(String[] args) {
        //추상클래스의 객체를 생성할 수 없으므로 메인 클래스의 객체를 생성했다(업캐스팅)
        Ex10Calculator c = new Ex10();
        //추상 메소드 연산 결과가 표시됨
        System.out.println(c.add(2,3));
        System.out.println(c.subtract(2, 3));
        System.out.println(c.average(new int [] {2, 3, 4}));
    }
}