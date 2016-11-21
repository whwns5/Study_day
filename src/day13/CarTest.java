package day13;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c1 = new Car();
		c1.name = "아반떼";
		c1.color = "블랙";
		c1.wheel = 4;
		c1.carOwner = "조준현";
		
		Car c2 = new Car();
		c2.name = "방구차";
		c2.color = "똥색";
		c2.wheel = 3;
		c2.carOwner = "안병민";
		
		c1.getInfo();
		
		c1.carForwardMovement();
		c1.carBackwardMovement();
		
		
		c2.getInfo();
		
		c2.carForwardMovement();
		c2.carBackwardMovement();
		
		
		
	}

}
