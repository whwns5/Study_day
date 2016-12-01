package day21;

import java.util.Calendar;

public class ThreadTest4 {
	public static void main(String[] args){
		
		while(true){
			Calendar now = Calendar.getInstance(); // ΩÃ±€≈Ê≈∏¿‘ 
			
			int h = now.get(Calendar.HOUR);
			int m = now.get(Calendar.MINUTE);
			int s = now.get(Calendar.SECOND);
			
			System.out.print("\r" + h + "Ω√ " + m + "∫– " + s + "√ ");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
