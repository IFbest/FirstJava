package kh1228;

public class GenericMethods {
    public <T> T method1(T t){
        return t;
    }
    public <T> boolean method2(T t1,T t2){
        return t1.equals(t2);
    }
    public <K, V> void method3(K k, V v){
        System.out.print(k + " : ");
        System.out.println(v);
    }
}
