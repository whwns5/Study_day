package day22;

import java.awt.*;

public class Day22_02_Q extends Frame{

	int displayX; // 화면 해상도 x
	int displayY; // 화면 해상도 y
	
	public Day22_02_Q(){
		Toolkit displayTool = Toolkit.getDefaultToolkit();
		Dimension displayDm = displayTool.getScreenSize();
		
		displayX = (int) displayDm.getWidth();
		displayY = (int) displayDm.getHeight();
		
		
		
	}
	
	/** 화면 출력 모듈 */
	public void showDisplay(){
		
		setDisplay();
		setComponent();
	}
	
	/** 컴포넌트 배치 모듈 */
	public void setComponent(){
		
		this.setLayout(new BorderLayout(20, 20));
		
		Panel framePanel = new Panel(new BorderLayout());
		framePanel.setBackground(Color.black);
		this.add(framePanel, BorderLayout.CENTER);
		
		// framePanel
		Panel f_pNorth = new Panel(new GridLayout(2, 2 , 0, 10));
		Panel f_pCenter = new Panel(new BorderLayout(10, 10));
		
		f_pNorth.setBackground(Color.RED);
		f_pCenter.setBackground(Color.PINK);
		
		framePanel.add(f_pNorth, BorderLayout.NORTH);
		framePanel.add(f_pCenter, BorderLayout.CENTER);
		
		// f_pNorth
		Label f_pNorth_Label_1 = new Label("  보내는 이 :");
		TextField f_pNorth_TextField_1 = new TextField();
		Label f_pNorth_Label_2 = new Label("  받는 이 :");
		TextField f_pNorth_TextField_2 = new TextField();
		
		f_pNorth.add(f_pNorth_Label_1);
		f_pNorth.add(f_pNorth_TextField_1);
		f_pNorth.add(f_pNorth_Label_2);
		f_pNorth.add(f_pNorth_TextField_2);
		
		// f_pCenter
		Label f_pCenter_Label_1 = new Label("내가 만들었어..ㅠㅠ 아래에 꼭써라~~알았쥐?", Label.CENTER);
		f_pCenter_Label_1.setBackground(Color.CYAN);
		Label f_pCenter_Label_2 = new Label("메세지:", Label.CENTER);
		TextArea f_pCenter_TextArea = new TextArea();
		Panel f_pCenter_pSouth = new Panel(new FlowLayout());
		f_pCenter_pSouth.setBackground(Color.yellow);
		
		f_pCenter.add(f_pCenter_Label_1, BorderLayout.NORTH);
		f_pCenter.add(f_pCenter_Label_2, BorderLayout.WEST);
		f_pCenter.add(f_pCenter_TextArea, BorderLayout.CENTER);
		f_pCenter.add(f_pCenter_pSouth, BorderLayout.SOUTH);
		
		// f_pCenter_pSouth
		Button f_pCenter_pSouth_Button_1 = new Button("보내기");
		Button f_pCenter_pSouth_Button_2 = new Button("취소");
		
		f_pCenter_pSouth.add(f_pCenter_pSouth_Button_1);
		f_pCenter_pSouth.add(f_pCenter_pSouth_Button_2);
	}
	
	/** 기본 화면 위치 및 사이즈 설정 모듈 */
	public void setDisplay(){
		this.setSize(380 , 330);
		this.setLocation(displayX / 2 - this.getWidth() / 2 , displayY / 2 - this.getHeight() / 2);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day22_02_Q frameTest = new Day22_02_Q();
		frameTest.showDisplay();
		
	}

}
