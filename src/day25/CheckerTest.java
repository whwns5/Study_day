package day25;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CheckerTest extends Frame implements ActionListener{

	/** 공통 컴포넌트 */
	MenuBar mb;
	Menu m_menu;
	MenuItem mi_add; 
	MenuItem mi_reset, mi_list, mi_close;
	
	/** 메인화면용 컴포넌트 */
	Label lb_main_title;
	
	Panel p_main;
	
	HashMap<String, Boolean> map;
	/** 예약용 컴포넌트 */
	Label lb_add_title, lb_add_msg;
	Checkbox cbs[];
	Button bt_add_result;
	
	/** 예약 취소하기 컴포넌트 */
	Label lb_reset_title, lb_reset_room, lb_reset_msg;
	TextField tf_reset_room;
	Button bt_reset_result;
	Label a;
	/** 예약 현황보기 컴포넌트 */
	Label lb_list_title;
	TextArea ta_list_content;
	
	public CheckerTest() {
		
		mb = new MenuBar();
		this.setMenuBar(mb);
		
		m_menu = new Menu("메뉴");
		mb.add(m_menu);
		
		mi_add = new MenuItem("예약하기");
		mi_reset = new MenuItem("예약취소하기");
		mi_list = new MenuItem("현황보기");
		mi_close = new MenuItem("종료");
		
		m_menu.add(mi_add);
		m_menu.add(mi_reset);
		m_menu.add(mi_list);
		m_menu.addSeparator();
		                                                    
		m_menu.add(mi_close);
		
		p_main = new Panel(new BorderLayout());
		lb_main_title = new Label("숙박 예약 관리 프로그램 v2.0", Label.CENTER);
		
		p_main.add(lb_main_title);
		
		this.add(p_main, "Center");
		
		mi_add.addActionListener(this);
		mi_reset.addActionListener(this);
		mi_list.addActionListener(this);
		mi_close.addActionListener(this);
		
		map = new HashMap<String, Boolean>();
		
		map.put("101", false);
		map.put("102", false);
		map.put("103", false);
		map.put("201", true);
		map.put("202", false);
		map.put("203", false);
		map.put("301", false);
		map.put("302", false);
		map.put("303", false);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == mi_add) {
			this.remove(p_main);
			makeAddView();
			this.add(p_main);
		} else if (obj == mi_reset) {
			this.remove(p_main);
			makeResetView();
			this.add(p_main);
		} else if (obj == mi_list) {
			this.remove(p_main);
			makeListView();
			this.add(p_main);
		} else if (obj == mi_close) {
			System.exit(0);
		} else if (obj == bt_add_result) {
			for (int i = 0; i < cbs.length; i++) {
				if (cbs[i].getState()) {
					map.put(cbs[i].getLabel(), true);
				}
			}
			lb_add_msg.setText("메세지 : 예약 완료 됨 !");
		} else if (obj == bt_reset_result) {
			String key = tf_reset_room.getText();
			if(map.get(key)){
				map.put(key, false);
				lb_reset_msg.setText("메세지 :" + key + "호실의 예약이 취소되었습니다.");
			}else{
				lb_reset_msg.setText("메세지 : 예약된 방이 아닙니다.");
			}
		}

		this.validate();
	}

	/** 등록관련 화면 구현 메서드 */
	public void makeAddView() {
		p_main = new Panel(new BorderLayout(5, 5));
		
		// 상단
		lb_add_title = new Label("숙박 예약 하기", Label.CENTER);
		p_main.add(lb_add_title, BorderLayout.NORTH);
		
		// 중단
		Panel p_temp2 = new Panel(new GridLayout(3, 3, 10, 10));
	
		cbs = new Checkbox[map.size()];
		Iterator<String> key = map.keySet().iterator();
		int index = 0;
		while(key.hasNext()){
			String key_s = key.next();
			Boolean status = map.get(key_s);
		
			cbs[index] = new Checkbox(key_s, status);
			if(status){
				cbs[index].setEnabled(false);
			}
			p_temp2.add(cbs[index]);
			index++;
		}
		
		p_main.add(p_temp2, BorderLayout.CENTER);
		
		// 하단
		Panel p_temp1 = new Panel(new BorderLayout());
		lb_add_msg = new Label("메세지 :", Label.LEFT);
		bt_add_result = new Button("예약하기");
		p_temp1.add(lb_add_msg, BorderLayout.CENTER);
		p_temp1.add(bt_add_result, BorderLayout.EAST);
		p_main.add(p_temp1, BorderLayout.SOUTH);
		
		bt_add_result.addActionListener(this);
	}
	
	/** 취소관련 화면 구현 메서드 */
	public void makeResetView(){
		p_main = new Panel(new BorderLayout(5, 5));
		
		// 상단
		lb_reset_title = new Label("예약 취소", Label.CENTER);
		p_main.add(lb_reset_title, BorderLayout.NORTH);
		
		// 중단
		Panel p_temp1 = new Panel(new BorderLayout());
		Panel p_temp2 = new Panel(new BorderLayout());
		
		p_temp1.add(p_temp2, BorderLayout.NORTH);
		lb_reset_room = new Label("방번호 :");
		tf_reset_room = new TextField();
		bt_reset_result = new Button("예약취소");
		
		p_temp2.add(lb_reset_room, BorderLayout.WEST);
		p_temp2.add(tf_reset_room, BorderLayout.CENTER);
		p_temp2.add(bt_reset_result, BorderLayout.EAST);
		
		p_main.add(p_temp1, BorderLayout.CENTER);
		
		// 하단
		lb_reset_msg = new Label("메세지 :", Label.LEFT);
		p_main.add(lb_reset_msg, BorderLayout.SOUTH);
		
		
		bt_reset_result.addActionListener(this);
		
	}
	
	/** 모든 현황보기 화면 관련 메서드 */
	public void makeListView(){
		p_main = new Panel(new BorderLayout());
		
		lb_list_title = new Label("예약 현황 목록", Label.CENTER);
		ta_list_content = new TextArea();
		
		p_main.add(lb_list_title, BorderLayout.NORTH);
		p_main.add(ta_list_content, BorderLayout.CENTER);
		
		Iterator<String> keys = map.keySet().iterator();
		String str = "";
		while(keys.hasNext()){
			String key = keys.next();
			Boolean value = map.get(key);
			
			str += key + "호실 상태 : " + (value ? "예약됨" : "비어있음") + "\n";
		}
		
		ta_list_content.setText(str);
	}

	public static void main(String[] args) {

		CheckerTest ct = new CheckerTest();
		ct.setSize(300, 300);
		ct.setVisible(true);

	}

}
