package day23;

import java.awt.*;
import java.awt.event.*;

public class Day23_01_Q extends Frame implements ActionListener{
	
	TextField f_tf_firstInput;
	TextField f_tf_secondInput;
	TextField f_tf_result;
	
	Button f_bt_calc;
	Button f_bt_reset;
	
	public Day23_01_Q() {
		// TODO Auto-generated constructor stub
		this.setLayout(new GridLayout(4, 2));
		
		Label f_lb_firstInput = new Label("FirstInput");
		Label f_lb_secondInput = new Label("SeconInput");
		Label f_lb_result = new Label("Result");
		
		f_tf_firstInput = new TextField();
		f_tf_secondInput = new TextField();
		f_tf_result = new TextField();
		//f_tf_result.setEnabled(false);
		f_tf_result.setEditable(false);

		f_bt_calc = new Button("Calc");
		f_bt_reset = new Button("Reset");
		
		this.add(f_lb_firstInput);
		this.add(f_tf_firstInput);
		
		this.add(f_lb_secondInput);
		this.add(f_tf_secondInput);
		
		this.add(f_lb_result);
		this.add(f_tf_result);
		
		f_bt_calc.addActionListener(this);
		f_bt_reset.addActionListener(this);
		
		this.add(f_bt_calc);
		this.add(f_bt_reset);
	
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args){
		Day23_01_Q calcProgram = new Day23_01_Q();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object btObject = e.getSource();
		if (btObject == f_bt_calc) {
			try{
				f_tf_result.setText(Integer.toString(
						(Integer.parseInt(f_tf_firstInput.getText()) + Integer.parseInt(f_tf_secondInput.getText()))));
			}catch(NumberFormatException er){
				System.out.println("숫자를 입력해주세요.");
			}
		} else if (btObject == f_bt_reset) {
			f_tf_firstInput.setText(null);
			f_tf_secondInput.setText(null);
			f_tf_result.setText(null);
		}

		this.validate();
	
		
	}
}
