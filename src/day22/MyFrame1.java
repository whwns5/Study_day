package day22;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

public class MyFrame1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Frame 
		Frame f = new Frame("나의 첫 프레임 !");
		
		f.setSize(300, 300);
		//////////////////////////////////////////////////////
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dim = tool.getScreenSize();
		int x = (int) dim.getWidth()/2 - (int)f.getSize().getWidth() / 2;
		int y = (int) dim.getHeight()/2 - (int)f.getSize().getHeight() / 2;
		
		//int x = (int) dim.getWidth()/2 - 150;
		//int y = (int) dim.getHeight()/2 - 150;
		System.out.println("x = " + x + ", y = " + y);
		
		f.setLocation(x, y);
		
//		FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 30 ,30);
//		
//		f.setLayout(fl);
		
		BorderLayout bl = new BorderLayout(10,10);
		f.setLayout(bl);
		
		
		Button bt1 = new Button("bt1");
		Button bt2 = new Button("bt2");
		Button bt3 = new Button("bt3");
		Button bt4 = new Button("bt4");
		Button bt5 = new Button("bt5");
		
		f.add(bt1, BorderLayout.NORTH);
		f.add(bt2, BorderLayout.EAST);
		f.add(bt3, "Center");
		f.add(bt4, "West");
		f.add(bt5, "South");
		
		//////////////////////////////////////////////////////
		f.setVisible(true);
		
		
	}

}
