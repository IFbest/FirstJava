package kh1224;

public class Point02 {
    int x, y;

    public Point02(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean equals(Object o){
        Point02 p1 = (Point02)o ;//다운캐스팅
        if (x == p1.x && y == p1.y)
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        Point02 a = new Point02(2,3);
        Point02 b = new Point02(2,3);
        Point02 c = new Point02(3,4);
        if (a == b)//false
            System.out.println("a == b");
        if (a.equals(b))//true
            System.out.println("a is eqaul to b");
        if (a.equals(c))//false
            System.out.println("a is eqaul to c");
    }
}