package day23;

import java.awt.*;
import java.awt.event.*;

public class MyEvent1 extends Frame implements ActionListener{
	
	Button bt_red , bt_blue , bt_green;
	
	public MyEvent1() {
		FlowLayout fl = new FlowLayout();
		this.setLayout(fl);
	
		
		bt_red = new Button("Red");
		bt_blue = new Button("Blue");
		bt_green = new Button("Green");
		
		this.add(bt_red);
		this.add(bt_blue);
		this.add(bt_green);
		
		bt_red.addActionListener(this);
		bt_blue.addActionListener(this);
		bt_green.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyEvent1 me1 = new MyEvent1();
		
		me1.setSize(300, 300);
		me1.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		String str = e.getActionCommand();
//		
//		if (str.equals("Red")) {
//			this.setBackground(Color.RED);
//		} else if (str.equals("Blue")) {
//			this.setBackground(Color.BLUE);
//		} else if (str.equals("Green")) {
//			this.setBackground(Color.GREEN);
//		}
		
		Object obj = e.getSource();

		if (obj == bt_red) { // 받아온 이벤트 소스의 주소값과 bt_red의 주소값이 같을 경우
			this.setBackground(Color.RED);
			this.setLayout(new FlowLayout(FlowLayout.LEFT));
		} else if (obj == bt_blue) {
			this.setBackground(Color.BLUE);
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
		} else if (obj == bt_green) {
			this.setBackground(Color.GREEN);
			this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		}
		
		this.validate();
		
		
	}

}
