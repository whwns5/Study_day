package day14;

public class BaseCar {
	
	String carName;
	int maxSpeed;
	
	public BaseCar() {
		// TODO Auto-generated constructor stub
		System.out.println("���̽�ī ����1");
	}
	
	public BaseCar(String carName, int maxSpeed) {
		// TODO Auto-generated constructor stub
		System.out.println("���̽�ī ����2");
		
		this.carName = carName;
		this.maxSpeed = maxSpeed;
		
	}
	
	public void getInfo(){
		System.out.println("īƮ�̸� : " + carName);
		System.out.println("�ְ�ӵ� : " + maxSpeed);
	}
}
