package day22;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.PageAttributes;
import java.awt.Panel;

public class MyFrame3 extends Frame{

	public MyFrame3() {
		// TODO Auto-generated constructor stub
		BorderLayout bl = new BorderLayout(20,20);
		this.setLayout(bl);
		
		// 중단 영역
		Panel p_center = new Panel();
		this.add(p_center, BorderLayout.CENTER);
		p_center.setBackground(Color.PINK);
		
		GridLayout gl = new GridLayout(2, 2, 10, 10);
		p_center.setLayout(gl);
		
		Button bt1 = new Button("bt1");
		Button bt2 = new Button("bt2");
		Button bt3 = new Button("bt3");
		Button bt4 = new Button("bt4");
		
		p_center.add(bt1);
		p_center.add(bt2);
		p_center.add(bt3);
		p_center.add(bt4);
		
		// 하단 영역
		Panel p_south = new Panel();
		BorderLayout bl2 = new BorderLayout(10, 10);
		p_south.setLayout(bl2);
		p_south.setBackground(Color.BLUE);
		
		Button bt5 = new Button("bt5");
		Button bt6 = new Button("bt6");
	
		p_south.add(bt5, BorderLayout.NORTH);
		p_south.add(bt6, BorderLayout.SOUTH);
		
		this.add(p_south, BorderLayout.SOUTH);
	}
	
	@Override
	public Insets insets() {
		// TODO Auto-generated method stub
		Insets i = new Insets(30, 20, 20, 20);
		return i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		MyFrame3 mf3 = new MyFrame3();
		mf3.setSize(300, 300);
		mf3.setVisible(true);
	}

}
