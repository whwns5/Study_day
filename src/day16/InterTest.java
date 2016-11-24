package day16;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class InterTest extends Frame implements WindowListener{
	
	public InterTest(){
		this.addWindowListener(this);
	}
	
	public static void main(String[] args){
		
		InterTest it = new InterTest();
		
		it.setSize(300, 300);
		it.setVisible(true);
		
		
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
