package day13;

public class MakaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���α׷� ����");
		
		Maka m1 = new Maka();
		m1.color = "����";
		m1.makaWrite();
		
		Maka m2 = new Maka();
		m2.color = "�Ķ�";
		m2.makaWrite();
		
							
		Maka m3 = new Maka(); // new Maka(); <- �� �� ������ ȣ��
		m3.makaWrite();
		
		System.out.println("���α׷� ��");
		
	}

}
