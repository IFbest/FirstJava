package kh1222;

class Weapon {
	// protected 타입이기 때문에 같은 패키지 안에서는 문제 없이 활용할 수 있다
	//(상속 받은 경우도 마찬가지)
	protected int fire() {
		return 1;
	}
}

class Cannon extends Weapon{
	@Override
	// 그래서 Cannon 클래스의  fire 메소드가 호출돼
	protected int fire() {
		return 10;
	}
}
public class Ex12 extends Shape {
	public static void main(String[] args) {
		//아래 두 문장을 하나로 만들면
		//Weapon weapon = new Weapon(); 이렇게 Weapon 객체 변수를 생성한 것이 된다
		Weapon weapon;
		weapon = new Weapon();
		//Weapon 클래스의 메소드를 활용하면 1이 리턴된다
		System.out.println("기본 무기의 살상 능력은 " + weapon.fire());
		//그러나 애라와 같은 경우 업 캐스팅이 되므로 동적 바인딩이 발생한다
		weapon = new Cannon();
		//살상 능력이 10이 된다
		System.out.println("대포의 살상 능력은 " + weapon.fire());
	}
}
