package day13;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c1 = new Car();
		c1.name = "�ƹݶ�";
		c1.color = "��";
		c1.wheel = 4;
		c1.carOwner = "������";
		
		Car c2 = new Car();
		c2.name = "�汸��";
		c2.color = "�˻�";
		c2.wheel = 3;
		c2.carOwner = "�Ⱥ���";
		
		c1.getInfo();
		
		c1.carForwardMovement();
		c1.carBackwardMovement();
		
		
		c2.getInfo();
		
		c2.carForwardMovement();
		c2.carBackwardMovement();
		
		
		
	}

}
