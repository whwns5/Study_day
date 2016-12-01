package day21;

public class ThreadTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1 ; i <= 20; i++){
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
