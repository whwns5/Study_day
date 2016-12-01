package day21;
/*
 * 
 * 3단은 메인
 * 6단은 thread 상속 클래스
 * 9단은 runnable 인터페이스 상속 클래스
 */

interface GuGuDan{
	public void danPrint();
}

class SamDan implements GuGuDan{
	int dan;
	
	public SamDan(){
		this.dan = 3;
	}
	
	@Override
	public void danPrint() {
		for(int i = 1 ; i < 10 ; i ++){
			System.out.println(this.dan + " * " + i + " = " + (this.dan*i));
		}
	}
}

class YoukDan extends Thread implements GuGuDan{
	int dan;
	
	public YoukDan() {
		this.dan = 6;
	}
	
	@Override
	public void danPrint() {
		for(int i = 1 ; i < 10 ; i ++){
			System.out.println(this.dan + " * " + i + " = " + (this.dan*i));
		}	
	}
	
	@Override
	public void run() {
		this.danPrint();
	}
	
}

class GuDan implements GuGuDan, Runnable{
	int dan;
	
	public GuDan() {
		this.dan = 9;
	}

	@Override
	public void danPrint() {
		for(int i = 1 ; i < 10 ; i ++){
			System.out.println(this.dan + " * " + i + " = " + (this.dan*i));
		}	
	}

	@Override
	public void run() {
		this.danPrint();
	}
}


public class Day21_01_Q {
	
	
	public static void main(String[] args) {
		
		SamDan firstThread = new SamDan();
		//SamDan firstThread = new Thread(new Samdan)
		
		YoukDan secondThread = new YoukDan();
		GuDan thirdThread = new GuDan();
		
		Thread runThirdThread = new Thread(thirdThread);
		Thread temp = Thread.currentThread();
		System.out.println("temp = " + temp);
		
		
		firstThread.danPrint();
		secondThread.start();
		runThirdThread.start();
		
		System.out.println("현재 돌고 있는 수 = " + Thread.activeCount());
	
		
		
		//secondThread.danPrint();
		//thirdThread.danPrint();
		
		
	}

}
