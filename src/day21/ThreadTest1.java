package day21;

class ThreadA extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread temp2 = Thread.currentThread();
		System.out.println(temp2);
		
		
		System.out.println("!! ThreadA�� ���� !!");
		
		for(int i = 1 ; i <= 10 ; i++){
			System.out.println("!! ThreadA�� �� : " + i + " !!");
		}
		
		System.out.println("!! ThreadA�� �� !!");
		
		
	}
}

class ThreadB implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("** ThreadB�� ���� **");
		
		for(int i = 1 ; i <= 10 ; i++){
			System.out.println("** ThreadB�� �� : + " + i + " **");
		}
		
		System.out.println("** ThreadB�� �� **");
	}
	
}

public class ThreadTest1 {

	//�̱� ������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadA ta = new ThreadA();
		
		ThreadB tb = new ThreadB();
		
		Thread tb2 = new Thread(tb);
		
		

		//ta.run(); // �������������� ����ȴ�.
		ta.start();
		tb2.start();
		
		System.out.println("ta�� �̸��� ? " + ta.getName());
		
		ta.setPriority(Thread.MIN_PRIORITY);
		tb2.setPriority(Thread.MAX_PRIORITY);
		
		
		ta.setName("firstThread");
		
		System.out.println("ta�� �̸��� ? " + ta.getName());
	
		//Thread.yield();
		try {
			tb2.join();
			ta.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("= main �� ���� =");
		
		for(int i = 1 ; i <= 10 ; i++){
			System.out.println("= main�� �� : " + i + " =");
			
		}
		
		
		System.out.println("= main �� �� =");
	
		Thread temp = Thread.currentThread(); //Thread[Thread-0,5,main]
		System.out.println(temp);
		
	}

	
}
