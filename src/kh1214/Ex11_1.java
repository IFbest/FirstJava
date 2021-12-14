package kh1214;

import java.util.Scanner;

public class Ex11_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[] { 23, 45, 67, 789, 2 };

        int i;
        for (i=0;i<a.length;i++){
            int k = a[i];
            System.out.println("k= " + k);
        }

     /*   for (int k : a){
            System.out.println("k= " + k);
        }*/
        int[] c;
        c = new int[] { 23, 45, 67, 789, 2 };
        //System.out.println("====================");
        for(i=0; i < 42; i++){
            System.out.printf("=");
        }
        System.out.println("");

        for (i=0;i<c.length;i++){
            int k = c[i];
            System.out.println("k= " + k);
        }

        /*for (int k : c){
            System.out.println("k= " + k);
        }
        scanner.close();*/
    }
 }