package kh1228;

public class MyStudent<T> {
    T name;
    public MyStudent(String n) {
        this.name = (T) n;
    }
    public T setName(T n){
        return name = n;
    }
    public T getName() {
        return name;
    }
}
