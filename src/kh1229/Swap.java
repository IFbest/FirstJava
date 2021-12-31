package kh1229;

class MyArrayAlg_Swap {
    public static <T> void swap(T[] a, int i, int j){
        //1번과 2번의 데이터를 교환함
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

public class Swap {
    public static void main(String[] args) {
        String[] language = { "C++", "C#", "JAVA"};
        MyArrayAlg_Swap.swap(language, 1, 2);
        for (String value: language)
            System.out.println(value);
    }
}
