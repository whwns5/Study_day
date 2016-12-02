package day22;

import java.awt.*;

public class MyFrame2 extends Frame {

	public MyFrame2(){
		
		Button bt1 = new Button("bt1");
		Button bt2 = new Button("bt2");
		Button bt3 = new Button("bt3");
		Button bt4 = new Button("bt4");
		Button bt5 = new Button("bt5");
		
		
		GridLayout gl = new GridLayout(2, 3, 10, 10);
		
		this.setLayout(gl);
		this.add(bt1);
		this.add(bt2);
		this.add(bt3);
		this.add(bt4);
		this.add(bt5);
		
		Panel p =  new Panel();
		p.setBackground(Color.YELLOW);
		this.add(p);
		
		BorderLayout bl = new BorderLayout();
		p.setLayout(bl);
		
		Button bt6 = new Button("bt6");
		Button bt7 = new Button("bt7");
		p.add(bt6, "North");
		p.add(bt7, "South");
		
	}
	
	@Override
	public Insets getInsets() {
		// TODO Auto-generated method stub
		Insets i = new Insets(45, 20, 20, 20);
		return i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame2 mf2 = new MyFrame2();
		mf2.setSize(300, 300);
		mf2.setVisible(true);
	}

}
