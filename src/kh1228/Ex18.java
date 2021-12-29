package kh1228;

public class Ex18 {
    public static void main(String[] args) {
        GOrigin<String> t = new GOrigin<String>();
        String str = "안녕하세요";
        t.set(str);
        t.getData();

        GOrigin<Integer> t1 = new GOrigin<Integer>();
        int num = 1;
        t1.set(num);
        //t1.set(str);
        t1.getData();
        //set를 두 번 했기 때문에 에러 발생
        GOrigin t3 = new GOrigin();
        //GenericOrigin <Object> t3 = new GenericOrigin<Object> ();
        //getter & setter 메소드를 사용하는데 사용하는 메소드에 저장되는 인수가 달라도 모두 활용 가능하다
        t3.set(str);
        t3.getData();
        t3.set(num);
        t3.getData();
    }
}
