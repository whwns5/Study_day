package telTest;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.util.ArrayList;

public class AllViewDisplay extends Panel{

	// �� ������Ʈ
	Label lb_title;
	
	// �ؽ�Ʈ�Ʒ��� ������Ʈ
	TextArea ta_result;
	
	Biz biz;
	
	public AllViewDisplay(Biz biz){
		this.biz = biz;
		initDisplay();
	}

	public void initDisplay() {
		this.setLayout(new BorderLayout());
		// this.setFont(new Font("Courier New", Font.PLAIN, 70));
		// ���
		lb_title = new Label("��� ��ȭ��ȣ", Label.CENTER);

		// �ߴ�
		ta_result = new TextArea(getAllTel().toString());
		// ta_result.setFont(new Font("Courier New", Font.PLAIN, 45));
		this.add(lb_title, BorderLayout.NORTH);
		this.add(ta_result, BorderLayout.CENTER);
	}

	/** ��ü �˻� ó�� �޼��� */
	public StringBuffer getAllTel(){
		StringBuffer sb = new StringBuffer();
		
		ArrayList<Object> result_tel_List = new ArrayList<Object>();
		result_tel_List = biz.getAll();
		
		for(int i = 0 ; i < result_tel_List.size() ; i++){
			Object obj = result_tel_List.get(i);
			if(obj instanceof TelVo){
				TelVo telvo = (TelVo) obj;
				sb.append(telvo.toViewString()+"\n");
			}
		}
		
		return sb;
	}
}