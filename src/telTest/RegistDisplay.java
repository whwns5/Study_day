package telTest;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;





public class RegistDisplay extends Panel implements ActionListener {

	// �г� ������Ʈ
	Panel p_center;
	Panel p_south;
	Panel p_center_p_first;
	Panel p_center_p_second;
	Panel p_center_p_third;
	Panel p_center_p_fourth;
	Panel p_south_p_center;
	
	// �� ������Ʈ
	Label lb_title;
	Label p_center_lb_name;
	Label p_center_lb_age;
	Label p_center_lb_addr;
	Label p_center_lb_tel;
	Label p_south_lb_resultMessage;
	
	// �ؽ�Ʈ�ʵ� ������Ʈ
	TextField p_center_tf_name;
	TextField p_center_tf_age;
	TextField p_center_tf_addr;
	TextField p_center_tf_tel;

	// ��ư ������Ʈ
	Button p_south_bt_reigst;
	
	Biz biz;
	
	public RegistDisplay(Biz biz){
		this.biz = biz;
		initDisplay();
	}
	
	public void initDisplay(){
		this.setLayout(new BorderLayout(0, 0));
		//this.setFont(new Font("Courier New", Font.PLAIN, 70));
		// ���
		lb_title = new Label("��ȭ��ȣ ���", Label.CENTER);
		
		// �ߴ�
		p_center = new Panel(new GridLayout(4, 1));
		p_center_p_first = new Panel();
		p_center_p_second = new Panel();
		p_center_p_third = new Panel();
		p_center_p_fourth = new Panel();

		p_center_lb_name = new Label("�̸� :");
		p_center_tf_name = new TextField(25);
		p_center_lb_age = new Label("���� :");
		p_center_tf_age = new TextField(25);
		p_center_lb_addr = new Label("�ּ� :");
		p_center_tf_addr = new TextField(25);
		p_center_lb_tel = new Label("���� :");
		p_center_tf_tel = new TextField(25);

		p_center_p_first.add(p_center_lb_name);
		p_center_p_first.add(p_center_tf_name);
		p_center_p_second.add(p_center_lb_age);
		p_center_p_second.add(p_center_tf_age);
		p_center_p_third.add(p_center_lb_addr);
		p_center_p_third.add(p_center_tf_addr);
		p_center_p_fourth.add(p_center_lb_tel);
		p_center_p_fourth.add(p_center_tf_tel);
		
		p_center.add(p_center_p_first);
		p_center.add(p_center_p_second);
		p_center.add(p_center_p_third);
		p_center.add(p_center_p_fourth);
		
		// �ϴ�
		p_south = new Panel(new BorderLayout());
		p_south_p_center = new Panel(new BorderLayout());
		p_south_lb_resultMessage = new Label("�޼��� :", Label.LEFT);
		p_south_bt_reigst = new Button("���");
		
		p_south_bt_reigst.addActionListener(this);

		p_south_p_center.add(p_south_lb_resultMessage, BorderLayout.WEST);
		p_south_p_center.add(p_south_bt_reigst, BorderLayout.EAST);
		
		p_south.add(p_south_p_center, BorderLayout.CENTER);
		//////////////////////////////////////////////

		this.add(lb_title, BorderLayout.NORTH);
		this.add(p_center, BorderLayout.CENTER);
		this.add(p_south, BorderLayout.SOUTH);
	}
	
	/** ���� ��� ó�� �޼��� */
	public void registTel(){
		String name; // �̸�
		int age; // ����
		String addr; // �ּ�
		String tel; // ����
		
		try{
			if((p_center_tf_name.getText().equals(""))){
				throw new InputNullException("�̸�");
			}
			name = p_center_tf_name.getText();
			age = Integer.parseInt(p_center_tf_age.getText());
			addr = p_center_tf_addr.getText();
			tel = p_center_tf_tel.getText();
		} catch (InputNullException e) { // ����ڰ� �Է����� ���� �ʵ尡 ���� ��
			p_south_lb_resultMessage.setText("�޼��� : " + e.getExceptionString());
			return;
		} catch (NumberFormatException e) { // ���̿� ���ڿ��� �Է��� ��
			p_center_tf_age.setText("");
			p_south_lb_resultMessage.setText("�޼��� : ���̸� �߸� �Է� �ϼ̽��ϴ�.");
			return;
		} catch (Exception e){
			e.printStackTrace();
			return;
		}

		TelVo input_user_data = new TelVo(name, age, addr, tel);
	
		if(biz.register(input_user_data)){ // ��� ó���� true �� ���� false �� ����
			p_south_lb_resultMessage.setText("�޼��� : " + name + " ���� ����� �Ǿ����ϴ�.");
			initTextField(); // �ؽ�Ʈ �ʵ� �ʱ�ȭ �޼���
		}else{
			p_south_lb_resultMessage.setText("�޼��� : ��Ͽ� �����Ͽ����ϴ�.");
			initTextField(); // �ؽ�Ʈ �ʵ� �ʱ�ȭ �޼���
		}
	}
	
	/** �ؽ�Ʈ �ʵ� �ʱ�ȭ �޼��� */
	public void initTextField(){
		p_center_tf_name.setText("");
		p_center_tf_age.setText("");
		p_center_tf_addr.setText("");
		p_center_tf_tel.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == p_south_bt_reigst){ // ��� ��ư �̸�
			registTel(); // ���� ��� ó�� �޼���
		} 
		this.validate(); // ȭ���� �����Ѵ�.
	}
}
