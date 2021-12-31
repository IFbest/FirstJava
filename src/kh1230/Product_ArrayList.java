package kh1230;

public class Product_ArrayList <T,V> {
    private T n;
    private T m;
    private T c;
    private V v;

    public Product_ArrayList(T n,T m,T c, V v) {
        this.n = (T) n;
        this.m = (T) m;
        this.c = (T) c;
        this.v = (V) v;
    }

    public T getCode() {
        return (T) n;
    }

    public T getName() {
        return (T) m;
    }

    public T getColor() {
        return (T) c;
    }

    public V getQty() {
        return (V) v;
    }
}

