package kh1229;


public class E01BagTest {
    public static void main(String[] args) {
        E01Bag<Book> bag = new E01Bag<>(new Book());
        //Bag<Book> bag은 제네릭 타입으로 Book을 포함하는 Bag 객체를 참조하는 변수
        //(new Book())은 Bag 클래스의 인스턴스를 생성하면서 Book을 생성한 후 인자로 전달
        E01Bag<PencilCase> bag2 = new E01Bag<>(new PencilCase());
        //Bag<PencilCase> bag2는 제네릭 타입으로 PencilCase를 포함하는 Bag객체를 참조하는 변수
        //(new PencilCase());은 Bag클래스의 인스턴스를 생성하면서 PencilCase를 생성한 후 인자로 전달

        bag.setOwner("김자바");
        bag2.setOwner("김샘이");
        //Owner가 김자바로 저장된 bag를 불러옴
        //Owner가 김자바로 저장된 bag2를 불러옴
        boolean result = bag.isSameOwner(bag2);
        //bag과 bag2 객체의 타입 매개변수가 다르기 때문에 오류 발생, isSameOwner()메소드에서
        //구현하고 싶은 것은 물품 소유주가 같은 지를 비교하여 같으면 true,
        //다르면 faulse를 반환하는 것이므로 매개변수가 같을 필요 없음
        //이 때 사용하는 것이 와일드카드
        if (result) System.out.println("소유자가 동일합니다.");
        else System.out.println("소유자가 다릅니다.");
        //E01Bag<Water> bag4 = new E01Bag<>(new Water());
        //E01Bag<Coffe> bag5 = new E01Bag<>(new Coffe());
        //Solid로  상속되지 않는 Water coffee는 타입 인자로 생성 불가
        //public class E01Bag<T extends Solid>에 의해 Solid 하위 클래스만 활용 가능
    }
}