package day13;

public class Bank {
	
	 String accName; // 예금주
	 String accNum; // 계좌번호
	 private int accMoney; // 잔액 				// 멤버 변수
	 static double accInterestRate = 0.07; 	// 클래스 변수 (static 변수) 
	
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
	
	//기능
	//setter -- 반환타입 x, 매개변수 o
	public void setAccMoney(int accMoney){
		this.accMoney = accMoney;
	}
	//getter
	public int getAccMoney(){
		return this.accMoney;
	}
	
	public void bSave(int accMoney){  // 입금
		this.accMoney += accMoney;
		System.out.println(accMoney + "원이 입금되어 " + this.accMoney + "원 잔액이 남았습니다.");
	}
	
	public void bLoad(int accMoney){ // 출금
		
		if(this.accMoney < accMoney){
			System.out.println("잔액이 부족합니다.");
			return;
		}
		
		this.accMoney -= accMoney;
		System.out.println(accMoney + "원이 출금되어 " + this.accMoney + "원 잔액이 남았습니다.");
	}
	/** 정보 출력*/
	public void getInfo(){
		System.out.println("예금주 : " + this.accName);
		System.out.println("계좌번호 : " + this.accNum);
		System.out.println("이자율 : " + this.accInterestRate);
		System.out.println("잔액 : " + (int)(this.accMoney+(this.accMoney*accInterestRate)) + " 원");
		
	}
}
