package telTest;

import java.awt.*;

public class MainDisplay extends Panel{
	
	// �� ������Ʈ
	Label lb_title;
	
	public MainDisplay(){
		initDisplay();
	}

	public void initDisplay(){
		this.setLayout(new BorderLayout());
		lb_title = new Label("��ȭ��ȣ �� v1.0",Label.CENTER);
		//lb_title.setFont(new Font("Courier New", Font.PLAIN, 150));
		this.add(lb_title, BorderLayout.CENTER);
	}
}
