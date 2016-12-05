package day23;

import java.awt.*;
import java.awt.event.*;

public class MyEvent2 extends Frame implements ActionListener{
	
	Label lb_num1, lb_num2, lb_result;
	TextField tf_num1, tf_num2, tf_result;
	Button bt_result, bt_reset;
	
	public MyEvent2() {
		// TODO Auto-generated constructor stub
		GridLayout gl = new GridLayout(4, 2, 10, 10);
		this.setLayout(gl);
		
		lb_num1 = new Label("첫번째 수 :");
		lb_num2 = new Label("두번째 수 :");
		lb_result = new Label("결과 값 :");
		
		tf_num1 = new TextField();
		tf_num2 = new TextField();
		tf_result = new TextField();
		tf_result.setEditable(false);
		
		bt_result = new Button("계산하기");
		bt_reset = new Button("초기화");
		
		this.add(lb_num1); this.add(tf_num1);
		this.add(lb_num2); this.add(tf_num2);
		this.add(lb_result); this.add(tf_result);
		this.add(bt_result); this.add(bt_reset);
		
		bt_result.addActionListener(this);
		bt_reset.addActionListener(this);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyEvent2 me2 = new MyEvent2();
		me2.setSize(300, 300);
		me2.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj == bt_result) {
			String num1_s = tf_num1.getText();
			int num1 = Integer.parseInt(num1_s);
			int num2 = Integer.parseInt(tf_num2.getText());
			int result = num1 + num2;
			//tf_result.setText( new Integer(result).toString() );
			tf_result.setText(""+result);
		} else if (obj == bt_reset) {
			tf_num1.setText("");
			tf_num2.setText("");
			tf_result.setText("");
			
			//tf_num1.setText(null);
			//tf_num2.setText(null);
			//tf_result.setText(null);
		}

	}

}
