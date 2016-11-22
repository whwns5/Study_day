package day14;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseCar car1 = new BaseCar("연습카트", 200);
		
	
		car1.getInfo();
		
		System.out.println("--------------------------------");
		
		Gadian car2 = new Gadian("가디안", 220, "황금아이템");
		car2.getInfo();
		
		System.out.println("--------------------------------");
		
		
		car2.getInfo("나의 루찌 자동차");
	}

}
