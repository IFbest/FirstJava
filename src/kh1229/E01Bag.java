package kh1229;

class Solid{}
class Liquid{}

class Book extends Solid{}
class PencilCase extends Solid{}
class NoteBook extends Solid{}

class Water extends Liquid{}
class Coffe extends Liquid{}


public class E01Bag<T extends Solid> {
    //Bag클래스를 고체 매개변수만 상속 받을 수 있도록 제한
    //T는 Solid나 Solid를 상속받는 하위 객체로만 대체
    private T thing;
    private String owner;

    public E01Bag(T thing){
        this.thing = thing;
    }
    public T getThing(){
        return thing;
    }
    void showType(){
        System.out.println("T의 타입은 " + thing.getClass().getName());
    }
    public String getOwner(){
        return owner;
    }
    public void setOwner(String owner){
        this.owner = owner;
    }
    //boolean isSameOwner(E01Bag<2> obj)
    boolean isSameOwner(E01Bag<?> obj){
        //어떤 타입의 매개변수도 지정할 수 있는 와일드 카드 사용
        if (this.owner.equals(obj.getOwner()))
            return true;
        return false;
    }
    //owner가 Owner에서 가져오는 obj와 같다면 참이고 아니면 거짓
}
