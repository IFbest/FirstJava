package kh1224;

public class OrderedPair<T,E> {
    private T t;
    private E v;

    public OrderedPair(T t, E v) {
        this.t = t;
        this.v = v;
    }
    public T getKey(){
        return t;
    }
    public E getValue(){
        return v;
    }
    public void setFirst(T t){
        this.t = t;
    }
    public void setSecond(E v){
        this.v = v;
    }
}