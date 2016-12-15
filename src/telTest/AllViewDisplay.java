package telTest;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.util.ArrayList;

public class AllViewDisplay extends Panel{
	
	public AllViewDisplay(){
		initDisplay();
	}
	
	public void initDisplay(){
		this.setLayout(new BorderLayout());
		this.setFont(new Font("Courier New", Font.PLAIN, 70));
		// 상단
		Label lb_title = new Label("모든 전화번호", Label.CENTER);
		
		// 중단
		TextArea ta_result = new TextArea(getAllTel().toString());
		ta_result.setFont(new Font("Courier New", Font.PLAIN, 45));
		this.add(lb_title, BorderLayout.NORTH);
		this.add(ta_result, BorderLayout.CENTER);
	}
	
	/** 전체 검색 처리 메서드 */
	public StringBuffer getAllTel(){
		StringBuffer sb = new StringBuffer();
		
		Biz biz = new TelTestBiz();
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
