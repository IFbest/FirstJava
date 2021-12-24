package kh1224;

public class SimplePair<T> {
    private T t;
    private T v;

    public SimplePair(T apple, T tomato) {
        this.t = apple;
        this.v = tomato;
    }
    public T getFirst(){
        return t;
    }
    public T getSecond(){
        return v;
    }
    public void setFirst(T t){
        this.t = t;
    }
    public void setSecond(T v){
        this.v = v;
    }
}