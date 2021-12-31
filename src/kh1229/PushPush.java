package kh1229;

import java.util.Stack;

public class PushPush {
        public static void main(String[] args) {
            Stack<Integer> stack = new Stack<>();//push, pop, peek, empty, seach 지원
            for(int i=1; i<=5 ; i++) {
                stack.push(i);
                //System.out.println(stack.peek());
            } //1, 2, 3, 4, 5 출력
            for (int i=0;i<5;i++){
                System.out.println(stack.pop());
            }
//            stack.pop();
//            System.out.println(stack.peek());    //4출력
//            System.out.println(stack.search(3));    //2출력
//            System.out.println(stack.empty());    //false출력
        }
}

