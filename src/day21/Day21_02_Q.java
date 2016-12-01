package day21;

import java.util.Calendar;


class Watch implements Runnable{
	
	
	public Watch(){
		
	}
	
	public void timePrint(){
	
		
	
		
		Calendar c = Calendar.getInstance();
		int Month = c.get(Calendar.DAY_OF_MONTH);
		int hour =  c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		System.out.print("\r" + hour + "Ω√ " + minute + "∫– " + second + "√ ");
	
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			timePrint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class Day21_02_Q {
	public static void main(String[] args){

		Watch wc = new Watch();
		Thread timeThread = new Thread(wc);
		timeThread.start();
	
		
	}
}
