package day21;
/*
 * 
 * 3���� ����
 * 6���� thread ��� Ŭ����
 * 9���� runnable �������̽� ��� Ŭ����
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
		
		System.out.println("���� ���� �ִ� �� = " + Thread.activeCount());
	
		
		
		//secondThread.danPrint();
		//thirdThread.danPrint();
		
		
	}

}
