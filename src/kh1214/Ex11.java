package kh1214;

import java.util.Scanner;

public class Ex11 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[] { 23, 45, 67, 789, 2 };

        for (int k : a){
            System.out.println("k= " + k);
        }
        int[] c;
        c = new int[] { 23, 45, 67, 789, 2 };
        System.out.println("====================");
        
        for (int k : c){
            System.out.println("k= " + k);
        }
        scanner.close();
    }
 }