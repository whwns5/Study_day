package day14;

public class Gadian extends BaseCar{
	
	String item;
	
	public Gadian() {
		// TODO Auto-generated constructor stub
		System.out.println("����� ����");
	}

	public Gadian(String carName, int maxSpeed, String item) {
		// super(carName, maxSpeed);
		this.carName = carName;
		this.maxSpeed = maxSpeed;
		this.item = item;

		System.out.println("����� ����2");
	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		super.getInfo();
		
		System.out.println("������ : " + this.item);
	}
	

	public void getInfo(String title) {
		// TODO Auto-generated method stub
		System.out.println(title);
		super.getInfo();
		System.out.println("������ : " + this.item);
		
		System.out.println("this.carName : " + this.carName);
		System.out.println("super.carName : " + super.carName);
	}
	
}
