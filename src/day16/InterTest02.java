package day16;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class InterTest02 extends Frame{
	
	public InterTest02(){
		//.addWindowListener(l);
		WindowAdapter wa = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
			}
		};
		
		this.addWindowListener(wa);
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterTest02 it2 = new InterTest02();
		
		it2.setSize(300, 300);
		it2.setVisible(true);
		
		
	}

}
