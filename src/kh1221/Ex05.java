package kh1221;

public class Ex05 {
	public static void main(String[] args) {
        //생성자를 통해 학생 정보 입력
        Ex05Student s1 = new Ex05Student("홍길동", 3);
        
        //default 접근 제어자인 name은 동일 패키지 내부에서 사용이 가능하지만
        System.out.println("학생의 이름은 : " + s1.name);
        //private 접근 제어자인 grade는 getter 메소드를 통한 간접 참조만 가능
        System.out.println("학생의 학년은 : " + s1.getGrade());
    }
}