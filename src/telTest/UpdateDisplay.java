package telTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdateDisplay extends Panel implements ActionListener{

	// �г� ������Ʈ
	Panel p_north;
	Panel p_north_p_south;
	Panel p_center;
	Panel p_cetner_p_center;
	Panel p_cetner_p_center_p_first;
	Panel p_cetner_p_center_p_second;
	Panel p_cetner_p_center_p_third;
	Panel p_cetner_p_center_p_fourth;
	Panel p_south;

	// �� ������Ʈ
	Label p_north_lb_title;
	Label p_north_p_south_lb_name;
	Label p_center_lb_title;
	Label p_cetner_p_center_p_first_lb_name;
	Label p_cetner_p_center_p_second_lb_age;
	Label p_cetner_p_center_p_third_lb_addr;
	Label p_cetner_p_center_p_fourth_lb_tel;
	Label p_south_lb_resultMessage;

	// �ؽ�Ʈ�ʵ� ������Ʈ
	TextField p_north_p_south_tf_name;
	TextField p_cetner_p_center_p_first_tf_name;
	TextField p_cetner_p_center_p_second_tf_age;
	TextField p_cetner_p_center_p_third_tf_addr;
	TextField p_cetner_p_center_p_fourth_tf_tel;

	// ��ư ������Ʈ
	Button p_north_p_south_bt_search;
	Button p_south_bt_update;

	Biz biz;

	public UpdateDisplay(Biz biz){
		this.biz = biz;
		initDisplay();
	}

	public void initDisplay() {
		this.setLayout(new BorderLayout());

		// ���
		p_north = new Panel(new BorderLayout());
		// ��� - ���
		p_north_lb_title = new Label("��ȭ��ȣ ����", Label.CENTER);
		// ��� - �ϴ�
		p_north_p_south = new Panel();
		p_north_p_south_lb_name = new Label("�̸� :");
		p_north_p_south_tf_name = new TextField(25);
		p_north_p_south_bt_search = new Button("�˻�");

		p_north_p_south_bt_search.addActionListener(this);

		p_north_p_south.add(p_north_p_south_lb_name);
		p_north_p_south.add(p_north_p_south_tf_name);
		p_north_p_south.add(p_north_p_south_bt_search);
		///////////////////////

		p_north.add(p_north_lb_title, BorderLayout.NORTH);
		p_north.add(p_north_p_south, BorderLayout.SOUTH);

		// �ߴ�
		p_center = new Panel(new BorderLayout());
		// �ߴ� - ���
		p_center_lb_title = new Label("�� ��", Label.CENTER);
		// �ߴ� - �ߴ�
		p_cetner_p_center = new Panel(new GridLayout(4, 1));
		p_cetner_p_center_p_first = new Panel();
		p_cetner_p_center_p_second = new Panel();
		p_cetner_p_center_p_third = new Panel();
		p_cetner_p_center_p_fourth = new Panel();

		p_cetner_p_center_p_first_lb_name = new Label("�̸� :");
		p_cetner_p_center_p_first_tf_name = new TextField(25);
		p_cetner_p_center_p_first_tf_name.setEditable(false);
		p_cetner_p_center_p_second_lb_age = new Label("���� :");
		p_cetner_p_center_p_second_tf_age = new TextField(25);
		p_cetner_p_center_p_third_lb_addr = new Label("�ּ� :");
		p_cetner_p_center_p_third_tf_addr = new TextField(25);
		p_cetner_p_center_p_fourth_lb_tel = new Label("���� :");
		p_cetner_p_center_p_fourth_tf_tel = new TextField(25);

		p_cetner_p_center_p_first.add(p_cetner_p_center_p_first_lb_name);
		p_cetner_p_center_p_first.add(p_cetner_p_center_p_first_tf_name);

		p_cetner_p_center_p_second.add(p_cetner_p_center_p_second_lb_age);
		p_cetner_p_center_p_second.add(p_cetner_p_center_p_second_tf_age);

		p_cetner_p_center_p_third.add(p_cetner_p_center_p_third_lb_addr);
		p_cetner_p_center_p_third.add(p_cetner_p_center_p_third_tf_addr);

		p_cetner_p_center_p_fourth.add(p_cetner_p_center_p_fourth_lb_tel);
		p_cetner_p_center_p_fourth.add(p_cetner_p_center_p_fourth_tf_tel);

		p_cetner_p_center.add(p_cetner_p_center_p_first);
		p_cetner_p_center.add(p_cetner_p_center_p_second);
		p_cetner_p_center.add(p_cetner_p_center_p_third);
		p_cetner_p_center.add(p_cetner_p_center_p_fourth);

		//////////////////////////

		p_center.add(p_center_lb_title, BorderLayout.NORTH);
		p_center.add(p_cetner_p_center, BorderLayout.CENTER);

		// �ϴ�
		p_south = new Panel(new BorderLayout());
		p_south_lb_resultMessage = new Label("�޼��� :", Label.LEFT);
		p_south_bt_update = new Button("����");

		p_south_bt_update.addActionListener(this);

		p_south.add(p_south_lb_resultMessage, BorderLayout.WEST);
		p_south.add(p_south_bt_update, BorderLayout.EAST);
		//////////////////////////

		this.add(p_north, BorderLayout.NORTH);
		this.add(p_center, BorderLayout.CENTER);
		this.add(p_south, BorderLayout.SOUTH);

	}
	
	/** �̸� �˻� ó�� �޼��� */
	public void getTel(){
		ArrayList<Object> result_tel_list = new ArrayList<Object>();
		
		result_tel_list = biz.get(new TelVo(p_north_p_south_tf_name.getText()));
	
		for(int i = 0 ; i < result_tel_list.size() ; i++){
			Object obj = result_tel_list.get(i);
			if(obj instanceof TelVo){
				TelVo telvo = (TelVo) obj;
				p_cetner_p_center_p_first_tf_name.setText(telvo.getName());
				p_cetner_p_center_p_second_tf_age.setText(Integer.toString(telvo.getAge()));
				p_cetner_p_center_p_third_tf_addr.setText(telvo.getAddr());
				p_cetner_p_center_p_fourth_tf_tel.setText(telvo.getTel());
			}
		}
	}
	
	/** ���� ���� ó�� �޼��� */
	public void modifyTel(){
		String name; // �̸�
		int age; // ����
		String addr; // �ּ�
		String tel; // ����
		
		try{
			if(p_cetner_p_center_p_second_tf_age.getText().equals("")){
				throw new InputNullException("����");
			}
			name = p_cetner_p_center_p_first_tf_name.getText();
			age = Integer.parseInt(p_cetner_p_center_p_second_tf_age.getText());
			addr = p_cetner_p_center_p_third_tf_addr.getText();
			tel = p_cetner_p_center_p_fourth_tf_tel.getText();
		} catch (InputNullException e) { // ����ڰ� �Է����� ���� �ʵ尡 ���� ��
			p_south_lb_resultMessage.setText("�޼��� : " + e.getExceptionString());
			return;
		} catch (NumberFormatException e) { // ���̿� ���ڿ��� �Է��� ��
			p_cetner_p_center_p_second_tf_age.setText("");
			p_south_lb_resultMessage.setText("�޼��� : ���̸� �߸� �Է� �ϼ̽��ϴ�.");
			return;
		} catch (Exception e){
			e.printStackTrace();
			return;
		}
		
		TelVo input_user_data = new TelVo(name, age, addr, tel);
		
		if (biz.modify(input_user_data)) { // ���� ó���� true �̸� ���� false �� ����
			p_south_lb_resultMessage.setText("�޼��� : " + name + " ���� ���� �Ǿ����ϴ�.");
			initTextField();
		} else {
			p_south_lb_resultMessage.setText("�޼��� : ������ ���� �Ͽ����ϴ�.");
			initTextField();
		}
	}

	/** �ؽ�Ʈ �ʵ� �ʱ�ȭ �޼��� */
	public void initTextField(){
		p_north_p_south_tf_name.setText("");
	
		p_cetner_p_center_p_first_tf_name.setText("");
		p_cetner_p_center_p_second_tf_age.setText("");
		p_cetner_p_center_p_third_tf_addr.setText("");
		p_cetner_p_center_p_fourth_tf_tel.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == p_north_p_south_bt_search) { // �˻� ��ư �̸�
			getTel(); // �̸� �˻� ó�� �޼���
		} else if (obj == p_south_bt_update) { // ���� ��ư �̸�
			modifyTel(); // ���� ���� ó�� �޼���
		}
		this.validate();
	}
}
