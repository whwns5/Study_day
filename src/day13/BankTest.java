package day13;

public class BankTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���α׷� ����");
		
		//Bank b1 = new Bank("������", "010-4140-6421", 5000, 0.07);
		Bank b1 = new Bank("ȫ�浿", "111-1111");
		b1.bSave(5555);
		b1.bLoad(1000);
		b1.getInfo();
		
		System.out.println("-----------------------");
		Bank b2 = new Bank("�Ѹ�", "222-2222");
		b2.bSave(50000);
		b2.bLoad(5000);
		b2.getInfo();
		
		System.out.println("���α׷� ��");
		System.out.println("-----------------------");
		b1.bLoad(1000);
		b1.getInfo();
		b2.getInfo();
		
		b1.accInterestRate = 0.1;
		
		//Bank.accInterestRate = 0.2;
		
		b1.getInfo();
		System.out.println("-----------------------");
		b2.getInfo();
	
//		Bank b3 = new Bank("������", "010-4140-6421", 5000, 0.07);
//		b1.getInfo();
//		b2.getInfo();
		
	}

}
