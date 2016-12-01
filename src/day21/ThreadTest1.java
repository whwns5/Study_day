package day21;

class ThreadA extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread temp2 = Thread.currentThread();
		System.out.println(temp2);
		
		
		System.out.println("!! ThreadA의 시작 !!");
		
		for(int i = 1 ; i <= 10 ; i++){
			System.out.println("!! ThreadA의 값 : " + i + " !!");
		}
		
		System.out.println("!! ThreadA의 끝 !!");
		
		
	}
}

class ThreadB implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("** ThreadB의 시작 **");
		
		for(int i = 1 ; i <= 10 ; i++){
			System.out.println("** ThreadB의 값 : + " + i + " **");
		}
		
		System.out.println("** ThreadB의 끝 **");
	}
	
}

public class ThreadTest1 {

	//싱글 스레드
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadA ta = new ThreadA();
		
		ThreadB tb = new ThreadB();
		
		Thread tb2 = new Thread(tb);
		
		

		//ta.run(); // 절차지향적으로 진행된다.
		ta.start();
		tb2.start();
		
		System.out.println("ta의 이름은 ? " + ta.getName());
		
		ta.setPriority(Thread.MIN_PRIORITY);
		tb2.setPriority(Thread.MAX_PRIORITY);
		
		
		ta.setName("firstThread");
		
		System.out.println("ta의 이름은 ? " + ta.getName());
	
		//Thread.yield();
		try {
			tb2.join();
			ta.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("= main 의 시작 =");
		
		for(int i = 1 ; i <= 10 ; i++){
			System.out.println("= main의 값 : " + i + " =");
			
		}
		
		
		System.out.println("= main 의 끝 =");
	
		Thread temp = Thread.currentThread(); //Thread[Thread-0,5,main]
		System.out.println(temp);
		
	}

	
}
