package kh1224;

class Point4 {
    int x, y;
    public Point4(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Ex09 {
    public static void main(String[] args) {
        //a, b, c 모두 저장되는 값은 같지만 객체의 저장 위치가 다르므로
        //c = a 로 대입 연산을 받은 a, c만 완전히 같은 값을 갖는다
        Point4 a = new Point4(2, 3);
        Point4 b = new Point4(2, 3);
        Point4 c = a;

        if (a == b)
            System.out.println("a == b");
        if (a == c)
            System.out.println("a == c");
    }
}