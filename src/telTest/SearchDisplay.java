package telTest;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SearchDisplay extends Panel implements ActionListener {

	// �г� ������Ʈ
	Panel p_north;
	Panel p_north_p_south;
	Panel p_center;
	
	// �� ������Ʈ
	Label p_north_lb_north;
	Label p_north_p_south_lb_name;
	
	// �ؽ�Ʈ�ʵ� ������Ʈ
	TextField p_north_p_south_tf_name;
	
	// �ؽ�Ʈ�Ʒ��� ������Ʈ
	TextArea p_center_ta_result;
	
	// ��ư ������Ʈ
	Button p_north_p_south_bt_search;

	public SearchDisplay() {
		initDisplay();
	}
	
	public void initDisplay() {
		this.setLayout(new BorderLayout());
		this.setFont(new Font("Courier New", Font.PLAIN, 70));
		// ���
		p_north = new Panel(new BorderLayout());
		// ��� - ���
		p_north_lb_north = new Label("��ȭ��ȣ �˻�", Label.CENTER);
		
		// ��� - �ϴ�
		p_north_p_south = new Panel();
		p_north_p_south_lb_name = new Label("�̸� :");
		p_north_p_south_tf_name = new TextField(25);
		p_north_p_south_bt_search = new Button("�˻�");
		
		p_north_p_south_bt_search.addActionListener(this);

		p_north_p_south.add(p_north_p_south_lb_name);
		p_north_p_south.add(p_north_p_south_tf_name);
		p_north_p_south.add(p_north_p_south_bt_search);
		//////////////////////////

		p_north.add(p_north_lb_north, BorderLayout.NORTH);
		p_north.add(p_north_p_south, BorderLayout.SOUTH);
		// �ߴ�
		p_center = new Panel(new BorderLayout());
		p_center_ta_result = new TextArea();
		p_center_ta_result.setFont(new Font("Courier New", Font.PLAIN, 45));
		
		p_center.add(p_center_ta_result, BorderLayout.CENTER);
		//////////////////////////////////

		this.add(p_north, BorderLayout.NORTH);
		this.add(p_center, BorderLayout.CENTER);
	}

	
	/** �̸� �˻� ó�� �޼��� */
	public void getTel(){
		StringBuffer sb = new StringBuffer();
		
		Biz biz = new TelTestBiz();
		ArrayList<Object> result_tel_List = new ArrayList<Object>();
		
		result_tel_List = biz.get(new TelVo(p_north_p_south_tf_name.getText()));
	
		for(int i = 0 ; i < result_tel_List.size() ; i++){
			Object obj = result_tel_List.get(i);
			if(obj instanceof TelVo){
				TelVo telvo = (TelVo) obj;
				sb.append(telvo.toViewString()+"\n");
			}
		}
		
		p_center_ta_result.setText(sb.toString());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == p_north_p_south_bt_search){ // �˻� ��ư �̸�
			getTel(); // �̸� �˻� ó�� �޼���
		}
		this.validate(); // ȭ���� �����Ѵ�.
	}
}