package kh1229;

public class Student <T,V> {
    public T id;
    public V tel;

    public Student(T id, V tel) {
        this.id = (T) id;
        this.tel = (V) tel;
    }
}
