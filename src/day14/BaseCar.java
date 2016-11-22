package day14;

public class BaseCar {
	
	String carName;
	int maxSpeed;
	
	public BaseCar() {
		// TODO Auto-generated constructor stub
		System.out.println("베이스카 생성1");
	}
	
	public BaseCar(String carName, int maxSpeed) {
		// TODO Auto-generated constructor stub
		System.out.println("베이스카 생성2");
		
		this.carName = carName;
		this.maxSpeed = maxSpeed;
		
	}
	
	public void getInfo(){
		System.out.println("카트이름 : " + carName);
		System.out.println("최고속도 : " + maxSpeed);
	}
}
