package day16;

import java.io.IOException;

abstract class Animal {

	public abstract void crySound();

	abstract public void getBaby(int i);
}

class Dog extends Animal {

	@Override
	public void crySound() {
		// TODO Auto-generated method stub
		System.out.println("강아지는 왈왈 하고 짖습니다.");
	}

	@Override
	public void getBaby(int i) {
		// TODO Auto-generated method stub
		System.out.println("강아지가 " + i + " 마리 태어났어요");
	}
}

class Cat extends Animal {

	@Override
	public void crySound() {
		// TODO Auto-generated method stub
		System.out.println("고양이는 야옹 하고 웁니다.");
	}

	@Override
	public void getBaby(int i) {
		// TODO Auto-generated method stub
		System.out.println("고양이가 " + i + " 마리 태어났어요");
	}
}

class Duck extends Animal {

	@Override
	public void crySound() {
		// TODO Auto-generated method stub
		System.out.println("오리는 꽥괙 하고 소리냅니다.");
	}

	@Override
	public void getBaby(int i) {
		// TODO Auto-generated method stub
		System.out.println("오리가  " + i + " 마리 태어났어요");
	}
}

public class AnimalTest {
	public static void main(String[] args) throws IOException {

		Animal ani = null;

		System.out.println("1. 강아지 2. 고양이 3. 오리");

		System.out.print("어떤 동물이 태어났나요 ? : ");
		switch (System.in.read() - '0') {
		case 1:
			ani = new Dog();
			break;
		case 2:
			
			ani = new Cat();
			break;
		case 3:
			ani = new Duck();
			break;
		default:
			break;
		}

		System.in.skip(2);

		System.out.print("몇마리 태어났나요 ? : ");
		ani.getBaby(System.in.read() - '0');
		ani.crySound();
		System.in.skip(2);
		
		
	}
}
