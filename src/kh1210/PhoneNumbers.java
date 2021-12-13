package kh1210;

import java.util.Random;

public class PhoneNumbers {
    public static void main(String[] args) {
        Random rand = new Random();
        String pnumber = "0";
        pnumber += rand.nextInt(6) + 2;
        pnumber += rand.nextInt(7) + 1;
        pnumber += "-";
        int i;
        for (i =0; i<3; i++) {
            pnumber += rand.nextInt(10);
        }

        pnumber += "-";
        int b;
        for (b =0; b<4; b++) {
            pnumber += rand.nextInt(10);
        }

        System.out.println(pnumber);
    }
}
