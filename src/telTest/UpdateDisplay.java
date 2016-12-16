package telTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdateDisplay extends Panel implements ActionListener{

	// 패널 컴포넌트
	Panel p_north;
	Panel p_north_p_south;
	Panel p_center;
	Panel p_cetner_p_center;
	Panel p_cetner_p_center_p_first;
	Panel p_cetner_p_center_p_second;
	Panel p_cetner_p_center_p_third;
	Panel p_cetner_p_center_p_fourth;
	Panel p_south;

	// 라벨 컴포넌트
	Label p_north_lb_title;
	Label p_north_p_south_lb_name;
	Label p_center_lb_title;
	Label p_cetner_p_center_p_first_lb_name;
	Label p_cetner_p_center_p_second_lb_age;
	Label p_cetner_p_center_p_third_lb_addr;
	Label p_cetner_p_center_p_fourth_lb_tel;
	Label p_south_lb_resultMessage;

	// 텍스트필드 컴포넌트
	TextField p_north_p_south_tf_name;
	TextField p_cetner_p_center_p_first_tf_name;
	TextField p_cetner_p_center_p_second_tf_age;
	TextField p_cetner_p_center_p_third_tf_addr;
	TextField p_cetner_p_center_p_fourth_tf_tel;

	// 버튼 컴포넌트
	Button p_north_p_south_bt_search;
	Button p_south_bt_update;

	Biz biz;

	public UpdateDisplay(Biz biz){
		this.biz = biz;
		initDisplay();
	}

	public void initDisplay() {
		this.setLayout(new BorderLayout());

		// 상단
		p_north = new Panel(new BorderLayout());
		// 상단 - 상단
		p_north_lb_title = new Label("전화번호 수정", Label.CENTER);
		// 상단 - 하단
		p_north_p_south = new Panel();
		p_north_p_south_lb_name = new Label("이름 :");
		p_north_p_south_tf_name = new TextField(25);
		p_north_p_south_bt_search = new Button("검색");

		p_north_p_south_bt_search.addActionListener(this);

		p_north_p_south.add(p_north_p_south_lb_name);
		p_north_p_south.add(p_north_p_south_tf_name);
		p_north_p_south.add(p_north_p_south_bt_search);
		///////////////////////

		p_north.add(p_north_lb_title, BorderLayout.NORTH);
		p_north.add(p_north_p_south, BorderLayout.SOUTH);

		// 중단
		p_center = new Panel(new BorderLayout());
		// 중단 - 상단
		p_center_lb_title = new Label("정 보", Label.CENTER);
		// 중단 - 중단
		p_cetner_p_center = new Panel(new GridLayout(4, 1));
		p_cetner_p_center_p_first = new Panel();
		p_cetner_p_center_p_second = new Panel();
		p_cetner_p_center_p_third = new Panel();
		p_cetner_p_center_p_fourth = new Panel();

		p_cetner_p_center_p_first_lb_name = new Label("이름 :");
		p_cetner_p_center_p_first_tf_name = new TextField(25);
		p_cetner_p_center_p_first_tf_name.setEditable(false);
		p_cetner_p_center_p_second_lb_age = new Label("나이 :");
		p_cetner_p_center_p_second_tf_age = new TextField(25);
		p_cetner_p_center_p_third_lb_addr = new Label("주소 :");
		p_cetner_p_center_p_third_tf_addr = new TextField(25);
		p_cetner_p_center_p_fourth_lb_tel = new Label("전번 :");
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

		// 하단
		p_south = new Panel(new BorderLayout());
		p_south_lb_resultMessage = new Label("메세지 :", Label.LEFT);
		p_south_bt_update = new Button("수정");

		p_south_bt_update.addActionListener(this);

		p_south.add(p_south_lb_resultMessage, BorderLayout.WEST);
		p_south.add(p_south_bt_update, BorderLayout.EAST);
		//////////////////////////

		this.add(p_north, BorderLayout.NORTH);
		this.add(p_center, BorderLayout.CENTER);
		this.add(p_south, BorderLayout.SOUTH);

	}
	
	/** 이름 검색 처리 메서드 */
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
	
	/** 정보 수정 처리 메서드 */
	public void modifyTel(){
		String name; // 이름
		int age; // 나이
		String addr; // 주소
		String tel; // 전번
		
		try{
			if(p_cetner_p_center_p_second_tf_age.getText().equals("")){
				throw new InputNullException("나이");
			}
			name = p_cetner_p_center_p_first_tf_name.getText();
			age = Integer.parseInt(p_cetner_p_center_p_second_tf_age.getText());
			addr = p_cetner_p_center_p_third_tf_addr.getText();
			tel = p_cetner_p_center_p_fourth_tf_tel.getText();
		} catch (InputNullException e) { // 사용자가 입력하지 않은 필드가 있을 시
			p_south_lb_resultMessage.setText("메세지 : " + e.getExceptionString());
			return;
		} catch (NumberFormatException e) { // 나이에 문자열을 입력할 시
			p_cetner_p_center_p_second_tf_age.setText("");
			p_south_lb_resultMessage.setText("메세지 : 나이를 잘못 입력 하셨습니다.");
			return;
		} catch (Exception e){
			e.printStackTrace();
			return;
		}
		
		TelVo input_user_data = new TelVo(name, age, addr, tel);
		
		if (biz.modify(input_user_data)) { // 수정 처리후 true 이면 성공 false 면 실패
			p_south_lb_resultMessage.setText("메세지 : " + name + " 님이 수정 되었습니다.");
			initTextField();
		} else {
			p_south_lb_resultMessage.setText("메세지 : 수정에 실패 하였습니다.");
			initTextField();
		}
	}

	/** 텍스트 필드 초기화 메서드 */
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
		if (obj == p_north_p_south_bt_search) { // 검색 버튼 이면
			getTel(); // 이름 검색 처리 메서드
		} else if (obj == p_south_bt_update) { // 수정 버튼 이면
			modifyTel(); // 정보 수정 처리 메서드
		}
		this.validate();
	}
}
