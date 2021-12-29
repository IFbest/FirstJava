package kh1228;

public class Point {
    private int x, y;
    public Point(int x, int y){
        //this 지시어를 통해 전송받은 데이터를 객체에 저장한다.
        this.x = x;
        this.y = y;
    }
    //Object 클래스에 존재하는 메소드이다, 클래스의 정보를 표시한다
    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
