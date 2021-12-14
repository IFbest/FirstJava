package kh1214;

public class Ex12 {
	public static void main(String[] args) {
        String[] str =
                new String[] {"산토끼", "집토끼", "판토끼","죽은토끼","알카리토끼"};
        for (int k = 0; k < str.length; k++){
            System.out.println("k= " + str[k]);
        }
        System.out.println("==========================================");

        for (String c: str)
            System.out.println("k= " + c);
    }
 }