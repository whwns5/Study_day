package day14;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseCar car1 = new BaseCar("����īƮ", 200);
		
	
		car1.getInfo();
		
		System.out.println("--------------------------------");
		
		Gadian car2 = new Gadian("�����", 220, "Ȳ�ݾ�����");
		car2.getInfo();
		
		System.out.println("--------------------------------");
		
		
		car2.getInfo("���� ���� �ڵ���");
	}

}
