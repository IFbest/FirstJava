package kh1229;

public class MyStack {
    public static void main(String[] args) {
        //GStack 클래스의 매개변수를 제네릭으로 설정해, 정수형/문자형 관계없이 활용 가능
        GStack<String> stringStack = new GStack<String>();
        //푸시를 통해 데이터 저장
        stringStack.push("seoul");
        stringStack.push("busan");
        stringStack.push("LA");

        for (int i =0;i<3;i++)
            //팝을 통해 최근에 저장된 데이터 순서대로 출력하며 데이터를 모두 삭제함
            System.out.println(stringStack.pop());
        //아래 부분도 동일함
        GStack<Integer> intStack = new GStack<Integer>();
        intStack.push(1);
        intStack.push(3);
        intStack.push(5);

        for (int i=0;i<3;i++)
            System.out.println(intStack.pop());
    }
}
