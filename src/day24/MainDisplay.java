package day24;

import java.awt.*;

//메인 화면
public class MainDisplay extends Panel{
	
	Label mainDisplay_title;
	Font mainDisplay_title_font;
	
	public MainDisplay(String title) {
		this.setLayout(new BorderLayout());
		mainDisplay_title = new Label(title, Label.CENTER);
		mainDisplay_title_font = new Font("Courier New", Font.PLAIN, 25);
	
		mainDisplay_title.setFont(mainDisplay_title_font);
		this.add(mainDisplay_title, BorderLayout.CENTER);
	
	}
}
