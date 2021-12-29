package kh1228;

import java.util.Vector;

public class PointVector {
    public static void main(String[] args) {
        //Point객체를 요소로 가지는 벡터 생성
        Vector<Point> v = new Vector<Point>();
        //Point 클래스 타입에 있는 x,y 변수값을 입력한다
        v.add(new Point(2, 3));
        v.add(new Point(-5,20));
        v.add(new Point(30, -8));

        v.remove(1);
        //1번 요소 -5, 20 삭제

        for (int i = 0;i<v.size();i++){
            //저장정보 출력
            Point p = v.get(i);
            //객체 자체를 println에 넣으면 toString 메소드가 자동 실행된다.
            System.out.println(p);
        }
    }
}
