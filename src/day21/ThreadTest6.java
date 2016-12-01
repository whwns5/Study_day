package day21;

class Bank{
	private int money;

	public Bank(){
		money = 0;
	}
	
	//�Ա�
	synchronized public void bSave(String name, int money){
		this.money += money;
	
		System.out.println(name + "��" + money + "���� �Ա��Ͽ� " + this.money + "���� �ܾ��� ���ҽ��ϴ�.");
	}
	
	// ���
	synchronized public void bLoad(String name, int money) {

		if (this.money < money) {
			System.out.println("�ܾ��� �����մϴ�.");
			return;
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.money = this.money - money;
		System.out.println(name + "��" + money + "���� ����Ͽ� " + this.money + "���� �ܾ��� ���ҽ��ϴ�.");
	}

}

class Parent extends Thread{
	String name;
	Bank bank;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i = 1; i <= 5; i++){
			int bsavem = (int)(Math.random()*4 + 1) * 100;
			int bloadm = (int)(Math.random()*4 + 1) * 100;
			
			bank.bSave(name, bsavem);
			bank.bLoad(name, bloadm);
		}
	}
}

public class ThreadTest6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank b = new Bank();
		
		Parent papa = new Parent();
		papa.name = "�ƺ�";
		papa.bank = b;
		
		Parent mama = new Parent();
		mama.name = "����";
		mama.bank = b;
		
		papa.start();
		mama.start();
	}

}
