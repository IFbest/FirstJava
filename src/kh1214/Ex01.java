package kh1214;

public class Ex01 {
	public static void main(String[] args) {
        int[] a = new int[6];//before)int[5]선언(앞)과 생성(뒤)을 동시에
        a[0] = 7;
        a[1] = 34;
        a[2] = 67;
        a[3] = 6;
        a[4] = 234;
        a[5] = 3244;
 
        System.out.println("배열의 갯수 : " + a.length);
        for (int i = 0;  i< a.length; i++){
            System.out.println("a[" + i + "] ="+ a[i]);
        }
    }
 }//에러이유를 적으시고 조치사항을 적어주세요!