package kh1220;

class Ex14 {
    String title;
    String author;

    void show() {
        System.out.println(title + " " + author);
    }

    // 첫 번째 메소드라서 무조건 출력
    public Ex14() {
        //this는 지금 현재 클래스의 메소드를 의미함(중요)
        //여기서 다시 오버로딩이 되므로 Ex14(String title, STring author)
        //Ex14()를 호출한 객체 emptyBook에 필드 변수 title,author에는 아무것도 저장되지 않음
        this("",""); // 첫줄
        System.out.println("생성자 호출됨");
    }
    public Ex14(String title){
        this(title, "작자미상");
    }
    public Ex14(String title, String author){
        this.title = title;
        this.author = author;
    }// 매개변수 명을 다르게 하면 정상 작동함
    // 변수명 중복 오류를 해결하기 위해 사용하는 느낌

    public static void main(String[] args) {
        Ex14 littlePrince = new Ex14("어린왕자", "생텍쥐페리");
        //춘향전의 작자가 없으므로, Ex14(String title) 생성자로 데이터를 저장함
        // 저장 방식은 this를 활용
        Ex14 loveStory = new Ex14("춘향전");
        // ex14() 생성자를 호출하므로 그 결과가 출력됨 -> 생성자 호출됨
        Ex14 emptyBook = new Ex14();
        // 춘향전 객체에 저장된 정보를 출력함, author은 인수로 받지 않고 자체 저장된 작자
        // this(title, "작자미상")이 부분을 통해 저장됨
        loveStory.show();
    }
}