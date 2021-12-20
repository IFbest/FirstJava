package kh1220;

class Ex08_1 {
    int radius;
    String name;
    // 반지름 데이터를 받아들이는 메소드 setter 메소드 형태
    void set(int r){
        radius = r;
    }
    // donut 객체의 경우 반지름 정보가 없으므로 연산이 제대로 이루어지지 않음
    double getArea(){
        return 3.14 * radius * radius;
    }
    // 내부 내용이 없기 때문에 기본생성자
    public Ex08_1(){
        //radius = 0;
    }
    // 반지름과 이름을 받아들이는 메소드
    public Ex08_1(int r, String n){
        this.radius = r;
        this.name = n;
    }

    public static void main(String[] args) {
        Ex08_1 pizza = new Ex08_1(10, "모래");
        System.out.println(pizza.getArea() + "\n" + pizza.name);
        Ex08_1 donut = new Ex08_1();
        // 이것 수행하면 작동하지 않음 반지름 정보가 주어지지 않았기 때문
        System.out.println(donut.getArea());
    }
}