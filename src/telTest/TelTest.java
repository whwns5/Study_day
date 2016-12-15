package telTest;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TelTest extends Frame implements ActionListener{

	int displayX; // 현재 화면크기 x
	int displayY; // 현재 화면크기 y
	
	// 메뉴 컴포넌트
	MenuBar mb;
	Menu m;
	MenuItem mi_regist; // 등록 메뉴
	MenuItem mi_search; // 검색 메뉴
	MenuItem mi_allView; // 조회 메뉴
	MenuItem mi_exit; // 종료 메뉴

	public TelTest(){
		initScreen(); // 기본 화면 위치 및 사이즈 조절 메서드
		initMenu(); // 메뉴 바 생성 및 초기화 메서드
		initDisplay(); // 화면 구성 생성 및 초기화 메서드
	}
	
	/** 기본 화면 위치 및 사이즈 조절 메서드 */
	public void initScreen() {
		Toolkit tlDisplay = Toolkit.getDefaultToolkit(); // 툴킷 객체를 생성한다.
		Dimension dm = tlDisplay.getScreenSize(); // 툴킷 객체로 부터 현재 화면의 스크린 사이즈를 담은 
		 										  // Dimension 객체를 생성한다.

		this.displayX = (int) dm.getWidth();
		this.displayY = (int) dm.getHeight();

		this.setSize(displayX, displayY);
		//this.setSize(450, 220);
		//this.setLocation(displayX / 2 - this.getWidth() / 2, displayY / 2 - this.getHeight() / 2);
		this.setVisible(true);
	}

	/** 메뉴 바 생성 및 초기화 메서드 */
	public void initMenu() {
		mb = new MenuBar();
		m = new Menu("메뉴");
		mi_regist = new MenuItem("전화번호 등록");
		mi_search = new MenuItem("전화번호 검색");
		mi_allView = new MenuItem("모든 전화번호 보기");
		mi_exit = new MenuItem("종료");

		// 액션리스너 등록
		mi_regist.addActionListener(this);
		mi_search.addActionListener(this);
		mi_allView.addActionListener(this);
		mi_exit.addActionListener(this);
		
		// 프레임에 부착
		this.setMenuBar(mb);
		mb.add(m);
		m.add(mi_regist);
		m.add(mi_search);
		m.add(mi_allView);
		m.addSeparator();
		m.add(mi_exit);
	}

	/** 화면 구성 생성 및 초기화 메서드 */
	public void initDisplay() {
		this.setLayout(new BorderLayout());
		this.add(new MainDisplay(), BorderLayout.CENTER); // 메인 화면 Panel 부착
	}
	
	/** 화면 전환 메서드 */
	public void changeDisplay(Object obj) {
		this.removeAll(); // Frame 에서 전체 컴포넌트를 삭제.
		if (obj == mi_regist) { // 등록 화면으로 전환이면
			this.add(new RegistDisplay(), BorderLayout.CENTER); // 등록 화면 Panel 부착
		} else if (obj == mi_search) { // 검색 화면으로 전환이면
			this.add(new SearchDisplay(), BorderLayout.CENTER); // 검색 화면 Panel 부착
		} else if (obj == mi_allView) { // 전체보기 화면으로 전환이면
			this.add(new AllViewDisplay(), BorderLayout.CENTER); // 조회 화면 Panel 부착
		}
	}
	
	@Override
	public Insets getInsets() {
		// TODO Auto-generated method stub
		Insets i = new Insets(53, 10, 10, 10);
		return i;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == mi_regist || obj == mi_search || obj == mi_allView) { // 등록, 검색, 조회 메뉴일때
			changeDisplay(obj); // 화면 전환 메서드
		} else if (obj == mi_exit) {
			System.exit(0);
		}
		
		this.validate(); // 화면을 갱신한다.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelTest telProgram = new TelTest();
	}

}
