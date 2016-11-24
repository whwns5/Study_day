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
		System.out.println("�������� �п� �ϰ� ¢���ϴ�.");
	}

	@Override
	public void getBaby(int i) {
		// TODO Auto-generated method stub
		System.out.println("�������� " + i + " ���� �¾���");
	}
}

class Cat extends Animal {

	@Override
	public void crySound() {
		// TODO Auto-generated method stub
		System.out.println("����̴� �߿� �ϰ� ��ϴ�.");
	}

	@Override
	public void getBaby(int i) {
		// TODO Auto-generated method stub
		System.out.println("����̰� " + i + " ���� �¾���");
	}
}

class Duck extends Animal {

	@Override
	public void crySound() {
		// TODO Auto-generated method stub
		System.out.println("������ �ЂE �ϰ� �Ҹ����ϴ�.");
	}

	@Override
	public void getBaby(int i) {
		// TODO Auto-generated method stub
		System.out.println("������  " + i + " ���� �¾���");
	}
}

public class AnimalTest {
	public static void main(String[] args) throws IOException {

		Animal ani = null;

		System.out.println("1. ������ 2. ����� 3. ����");

		System.out.print("� ������ �¾���� ? : ");
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

		System.out.print("��� �¾���� ? : ");
		ani.getBaby(System.in.read() - '0');
		ani.crySound();
		System.in.skip(2);
		
		
	}
}
