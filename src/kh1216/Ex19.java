package kh1216;

//Call by reference
//참조연산
//c언어의 포인터와 유사
public class Ex19 {
  //해당 메소드에는 return값이 없지만 배열 매개변수에 의 해 참조연산이 실행돼 저장된 변수의 값이 바뀜
  public void increase(int[] n){
      for (int i = 0;i<n.length;i++){
          n[i]++;
      }
  }
  public static void main(String[] args){
      int [] ref1 = {100,800,1000};
      Ex19 ref = new Ex19();
      //초기 배열 변수의 값만 출력
      for (int i = 0;i<ref1.length;i++){
          System.out.println("ref1[" + i + "] : " + ref1[i]);
      }
      //increase메소드 실행
      ref.increase(ref1);
      System.out.println();

      System.out.println("메소드 호출 후");
      //메소드 실행 후 배열 변수의 성분값이 변화한 것을 확인
      //이것이 Call by Reference의 힘
      for (int i = 0; i<ref1.length; i++){
          System.out.println("ref1[" + i + "] :" + ref1[i]);
      }
  }
}