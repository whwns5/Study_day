package day22;

import java.awt.*;
import java.util.*;

public class Day22_01_Q extends Frame{

	int displayX; // 현재 화면 해상도 x
	int displayY; // 현재 화면 해상도 y
	
	
	public Day22_01_Q() {
		
		// 기본 프레임 크기 및 위치 설정
		this.setSize(300, 300);
		this.setVisible(true);
		
		Toolkit displayTool = Toolkit.getDefaultToolkit();
		Dimension dm = displayTool.getScreenSize();
		this.displayX = (int) dm.getWidth();
		this.displayY = (int) dm.getHeight();
		
		this.setLocation(this.displayX/2 - this.getWidth()/2, this.displayY/2 - this.getHeight()/2);
		
		// 기본 프레임을 1행 2열인 그리드 레이아웃으로 설정한다.
		//GridLayout frameGridLayout = new GridLayout(2, 1, 10, 10);
		//this.setLayout(frameGridLayout);
		BorderLayout framBorderLayout = new BorderLayout(10, 30);
		this.setLayout(framBorderLayout);
		
		Panel frameFirstPanel = new Panel(new GridLayout(2, 2, 10, 10));
		Panel frameSecondPanel = new Panel(new BorderLayout());
	
		//frameSecondPanel.setSize(300, 200);
		
		
		frameFirstPanel.setBackground(Color.PINK);
		frameSecondPanel.setBackground(Color.BLUE);
		
		//this.add(frameFirstPanel);
		//this.add(frameSecondPanel);
		this.add(frameFirstPanel, BorderLayout.CENTER);
		this.add(frameSecondPanel, BorderLayout.SOUTH);
	
		// frameFirstPanel
		Button FirstPanel_FirstButton = new Button("bt4");
		Button FirstPanel_SecondButton = new Button("bt5");
		Button FirstPanel_ThirdButton = new Button("bt6");
		Button FirstPanel_FourthButton = new Button("bt7");
		
		frameFirstPanel.add(FirstPanel_FirstButton);
		frameFirstPanel.add(FirstPanel_SecondButton);
		frameFirstPanel.add(FirstPanel_ThirdButton);
		frameFirstPanel.add(FirstPanel_FourthButton);
		
		// frameSecondPanel
		Button SecondPanel_FirstButton = new Button("bt1");
		//SecondPanel_FirstButton.setSize(frameSecondPanel.getWidth(), 30);
		//SecondPanel_FirstButton.setPreferredSize(new Dimension(frameSecondPanel.getWidth(), 50));
		Panel SecondPanel_SecondPanel = new Panel();
		//SecondPanel_SecondPanel.setSize(frameSecondPanel.getWidth(), 100);
		SecondPanel_SecondPanel.setPreferredSize(new Dimension(frameSecondPanel.getWidth(), 20));
		
		Button SecondPanel_ThirdButton = new Button("bt3");
		
		
		frameSecondPanel.add(SecondPanel_FirstButton, BorderLayout.NORTH);
		frameSecondPanel.add(SecondPanel_SecondPanel, BorderLayout.CENTER);
		frameSecondPanel.add(SecondPanel_ThirdButton, BorderLayout.SOUTH);
		
	}
	
	@Override
	public Insets getInsets() {
		// TODO Auto-generated method stub
		Insets i = new Insets(30, 20, 20, 20);
		return i;
		
		//return super.getInsets();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day22_01_Q qFrame = new Day22_01_Q();
		
	}

}
