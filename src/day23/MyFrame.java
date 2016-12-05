package day23;

import java.awt.*;

public class MyFrame extends Frame {

	public MyFrame() {
	
		this.setLayout(new BorderLayout(5, 5));
		
		// 상단
		Panel p_north = new Panel(new GridLayout(2, 2, 5, 5));
		Label lb_from = new Label("보내는 이 :");
		Label lb_to = new Label("받는 이 :");
		TextField tf_from = new TextField();
		TextField tf_to = new TextField();
		p_north.add(lb_from);
		p_north.add(tf_from);
		p_north.add(lb_to);
		p_north.add(tf_to);
		this.add(p_north,"North");
		
		// 중단
		Panel p_center = new Panel(new BorderLayout());
		Label lb_msg = new Label("아래에 메세지를 작성하세요.", Label.CENTER);
		Label lb_title = new Label("메세지:");
		TextArea ta = new TextArea();
		p_center.add(lb_msg, "North");
		p_center.add(lb_title, "West");
		p_center.add(ta	, "Center");
		this.add(p_center, "Center");
		
		// 하단
		Panel p_south = new Panel();
		Button bt_send = new Button("보내기");
		Button bt_reset = new Button("취소");
		p_south.add(bt_send);
		p_south.add(bt_reset);
		this.add(p_south,"South");
		
	}
	
	@Override
	public Insets getInsets() {
		// TODO Auto-generated method stub
		Insets i = new Insets(45, 20, 20, 20);
		return i;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame mf = new MyFrame();
		mf.setSize(300, 300);
		mf.setVisible(true);
	}

}
