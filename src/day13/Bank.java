package day13;

public class Bank {
	
	 String accName; // ������
	 String accNum; // ���¹�ȣ
	 private int accMoney; // �ܾ� 				// ��� ����
	 static double accInterestRate = 0.07; 	// Ŭ���� ���� (static ����) 
	
	public Bank(String accName, String accNum, int accMoney, double accInterestRate){ 
		this.accName = accName;
		this.accNum = accNum;
		this.accMoney = accMoney;				 
		this.accInterestRate = accInterestRate; 
	}
	
	public Bank(String accName, String accNum){
		this.accName = accName;
		this.accNum = accNum;
		this.accMoney = 0;
		//this.accInterestRate = 0.07;
	}
	
	//���
	//setter -- ��ȯŸ�� x, �Ű����� o
	public void setAccMoney(int accMoney){
		this.accMoney = accMoney;
	}
	//getter
	public int getAccMoney(){
		return this.accMoney;
	}
	
	public void bSave(int accMoney){  // �Ա�
		this.accMoney += accMoney;
		System.out.println(accMoney + "���� �ԱݵǾ� " + this.accMoney + "�� �ܾ��� ���ҽ��ϴ�.");
	}
	
	public void bLoad(int accMoney){ // ���
		
		if(this.accMoney < accMoney){
			System.out.println("�ܾ��� �����մϴ�.");
			return;
		}
		
		this.accMoney -= accMoney;
		System.out.println(accMoney + "���� ��ݵǾ� " + this.accMoney + "�� �ܾ��� ���ҽ��ϴ�.");
	}
	/** ���� ���*/
	public void getInfo(){
		System.out.println("������ : " + this.accName);
		System.out.println("���¹�ȣ : " + this.accNum);
		System.out.println("������ : " + this.accInterestRate);
		System.out.println("�ܾ� : " + (int)(this.accMoney+(this.accMoney*accInterestRate)) + " ��");
		
	}
}
