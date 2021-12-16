package kh1216;

public class Ex10 {
    //static 메소드 선언(형광등을 키면 바로 켜지듯 바로 메모리에 상주)
    //static를 선언하면 객체가 활용되는 순간
    //static 메소드에 메모리가 할당돼 바로 활용할 수 있게 됨
    static int[] makeArray() {
        //크기 4짜리 temp 배열 생성
        int temp[] = new int[4];
        for (int i = 0; i< temp.length;i++){
            //배열 길이 만큼, 0~3까지 수를 배열에 저장
            //temp.length : 배열에 저장된 데이터 수를 계산
            temp[i] = i;
        }
        //return 을 통해 값을 intArray 배열에 저장
        return  temp;
    }
    public static void main(String[] args) {
        int intArray[];
        //makeArray() 메소드 결과를 배열 변수에 입력
        intArray = makeArray();
        //for문을 통해 makeArray() 메소드의 결과값을 출력함
        for (int i = 0; i<intArray.length; i++){
            System.out.print(intArray[i] + " ");
        }
    }
}