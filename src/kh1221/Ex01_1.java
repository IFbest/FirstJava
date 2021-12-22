package kh1221;

public class Ex01_1 {
    public static void main(String[] args) {
        //객체 생성
        Ex01CarDesign myCar = new Ex01CarDesign();
        //setter 메소드를 활용해 객체 데이터 저장
        //setValuename(input) : 이런 식으로 이름지음
        myCar.setCarName("소나타");
        myCar.setCarColor("은색");
        myCar.setCarSize(2000);
        myCar.setCarVelocity(60);


        //getter 메소드를 활용해 데이터 출력
        //getValuename() : 이런 식으로 이름지음
        String carName = myCar.getCarName();
        String carColor = myCar.getCarColor();
        int carSize = myCar.getCarSize();
        int velocity = myCar.getVelocity();
        //speedUp 메소드를 활용하면 speed 속도가 향상
        myCar.speedUp();
        myCar.speedUp();
        //두 번의 speedUp()메소드를 실행해 증가된 속도를 출력
        velocity = myCar.getVelocity();

        System.out.println("내 차 정보 출력: ");
        System.out.println("차 이름: " + carName + ", 색상: " + carColor +
                ", 배기량: " + carSize + "cc"+ ", 현재속도: " + velocity + "입니다");
    }
}

//getter & setter 메소드를 활용하는 것을 캡슐화라고 함
//저장 객체의 변수는 private로 지정해서 외부 입력이 차단됨
//해당 객체의 변수는 객체 내부 getter과 setter 메소드로만 연동
//getter & setter 메소드는 public 이므로 간접적인 접근이 가능함
//캡슐화 함으로써 보안기능을 향상 시키고 클래스간 독립성을 강화할 수 있음
//이러한 변수와 메소드 모음을 JAVA Bean이라고 함
