package telTest;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SearchDisplay extends Panel implements ActionListener {

	// 패널 컴포넌트
	Panel p_north;
	Panel p_north_p_south;
	Panel p_center;
	
	// 라벨 컴포넌트
	Label p_north_lb_north;
	Label p_north_p_south_lb_name;
	
	// 텍스트필드 컴포넌트
	TextField p_north_p_south_tf_name;
	
	// 텍스트아레아 컴포넌트
	TextArea p_center_ta_result;
	
	// 버튼 컴포넌트
	Button p_north_p_south_bt_search;

	public SearchDisplay() {
		initDisplay();
	}
	
	public void initDisplay() {
		this.setLayout(new BorderLayout());
		this.setFont(new Font("Courier New", Font.PLAIN, 70));
		// 상단
		p_north = new Panel(new BorderLayout());
		// 상단 - 상단
		p_north_lb_north = new Label("전화번호 검색", Label.CENTER);
		
		// 상단 - 하단
		p_north_p_south = new Panel();
		p_north_p_south_lb_name = new Label("이름 :");
		p_north_p_south_tf_name = new TextField(25);
		p_north_p_south_bt_search = new Button("검색");
		
		p_north_p_south_bt_search.addActionListener(this);

		p_north_p_south.add(p_north_p_south_lb_name);
		p_north_p_south.add(p_north_p_south_tf_name);
		p_north_p_south.add(p_north_p_south_bt_search);
		//////////////////////////

		p_north.add(p_north_lb_north, BorderLayout.NORTH);
		p_north.add(p_north_p_south, BorderLayout.SOUTH);
		// 중단
		p_center = new Panel(new BorderLayout());
		p_center_ta_result = new TextArea();
		p_center_ta_result.setFont(new Font("Courier New", Font.PLAIN, 45));
		
		p_center.add(p_center_ta_result, BorderLayout.CENTER);
		//////////////////////////////////

		this.add(p_north, BorderLayout.NORTH);
		this.add(p_center, BorderLayout.CENTER);
	}

	
	/** 이름 검색 처리 메서드 */
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
		if(obj == p_north_p_south_bt_search){ // 검색 버튼 이면
			getTel(); // 이름 검색 처리 메서드
		}
		this.validate(); // 화면을 갱신한다.
	}
}