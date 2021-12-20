package kh1220;

class Ex07 {
    String title;
    String author;
    // 본 예제에서는 위 아래 생성자의 매개변수 수가 다름
// 위의 경우 작자 미상일 경우 활용하고
public Ex07(String t){
    title = t;
    author = "작자미상";
}
// 아래 생성자는 작자를 알 때 사용
public Ex07(String t, String a){
    title = t;
    author = a;
}

public static void main(String[] args) {
    // 두 클래스 모두 객체를 생성했으므로 static 을 사용하지 않아도 됨
    Ex07 littlePrince = new Ex07("어린왕자", "생택쥐페리");
    Ex07 loveStory = new Ex07("춘향전");
    System.out.println(littlePrince.title + " " + littlePrince.author);
    System.out.println(loveStory.title + " " + loveStory.author);
}
}