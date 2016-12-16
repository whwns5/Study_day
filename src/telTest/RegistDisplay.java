package telTest;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;





public class RegistDisplay extends Panel implements ActionListener {

	// 패널 컴포넌트
	Panel p_center;
	Panel p_south;
	Panel p_center_p_first;
	Panel p_center_p_second;
	Panel p_center_p_third;
	Panel p_center_p_fourth;
	Panel p_south_p_center;
	
	// 라벨 컴포넌트
	Label lb_title;
	Label p_center_lb_name;
	Label p_center_lb_age;
	Label p_center_lb_addr;
	Label p_center_lb_tel;
	Label p_south_lb_resultMessage;
	
	// 텍스트필드 컴포넌트
	TextField p_center_tf_name;
	TextField p_center_tf_age;
	TextField p_center_tf_addr;
	TextField p_center_tf_tel;

	// 버튼 컴포넌트
	Button p_south_bt_reigst;
	
	Biz biz;
	
	public RegistDisplay(Biz biz){
		this.biz = biz;
		initDisplay();
	}
	
	public void initDisplay(){
		this.setLayout(new BorderLayout(0, 0));
		//this.setFont(new Font("Courier New", Font.PLAIN, 70));
		// 상단
		lb_title = new Label("전화번호 등록", Label.CENTER);
		
		// 중단
		p_center = new Panel(new GridLayout(4, 1));
		p_center_p_first = new Panel();
		p_center_p_second = new Panel();
		p_center_p_third = new Panel();
		p_center_p_fourth = new Panel();

		p_center_lb_name = new Label("이름 :");
		p_center_tf_name = new TextField(25);
		p_center_lb_age = new Label("나이 :");
		p_center_tf_age = new TextField(25);
		p_center_lb_addr = new Label("주소 :");
		p_center_tf_addr = new TextField(25);
		p_center_lb_tel = new Label("전번 :");
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
		
		// 하단
		p_south = new Panel(new BorderLayout());
		p_south_p_center = new Panel(new BorderLayout());
		p_south_lb_resultMessage = new Label("메세지 :", Label.LEFT);
		p_south_bt_reigst = new Button("등록");
		
		p_south_bt_reigst.addActionListener(this);

		p_south_p_center.add(p_south_lb_resultMessage, BorderLayout.WEST);
		p_south_p_center.add(p_south_bt_reigst, BorderLayout.EAST);
		
		p_south.add(p_south_p_center, BorderLayout.CENTER);
		//////////////////////////////////////////////

		this.add(lb_title, BorderLayout.NORTH);
		this.add(p_center, BorderLayout.CENTER);
		this.add(p_south, BorderLayout.SOUTH);
	}
	
	/** 전번 등록 처리 메서드 */
	public void registTel(){
		String name; // 이름
		int age; // 나이
		String addr; // 주소
		String tel; // 전번
		
		try{
			if((p_center_tf_name.getText().equals(""))){
				throw new InputNullException("이름");
			}
			name = p_center_tf_name.getText();
			age = Integer.parseInt(p_center_tf_age.getText());
			addr = p_center_tf_addr.getText();
			tel = p_center_tf_tel.getText();
		} catch (InputNullException e) { // 사용자가 입력하지 않은 필드가 있을 시
			p_south_lb_resultMessage.setText("메세지 : " + e.getExceptionString());
			return;
		} catch (NumberFormatException e) { // 나이에 문자열을 입력할 시
			p_center_tf_age.setText("");
			p_south_lb_resultMessage.setText("메세지 : 나이를 잘못 입력 하셨습니다.");
			return;
		} catch (Exception e){
			e.printStackTrace();
			return;
		}

		TelVo input_user_data = new TelVo(name, age, addr, tel);
	
		if(biz.register(input_user_data)){ // 등록 처리후 true 면 성공 false 면 실패
			p_south_lb_resultMessage.setText("메세지 : " + name + " 님이 등록이 되었습니다.");
			initTextField(); // 텍스트 필드 초기화 메서드
		}else{
			p_south_lb_resultMessage.setText("메세지 : 등록에 실패하였습니다.");
			initTextField(); // 텍스트 필드 초기화 메서드
		}
	}
	
	/** 텍스트 필드 초기화 메서드 */
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
		if(obj == p_south_bt_reigst){ // 등록 버튼 이면
			registTel(); // 전번 등록 처리 메서드
		} 
		this.validate(); // 화면을 갱신한다.
	}
}
