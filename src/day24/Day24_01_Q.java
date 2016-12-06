//package day24;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Set;
//
//import javax.swing.border.Border;
//
//public class Day24_01_Q extends Frame implements ActionListener {
//
//	HashMap<Integer, String> hmStay;
//	
//	int displayX; // 화면 크기 x
//	int displayY; // 화면 크기 y
//
//	// 메뉴 멤버 변수
//	MenuBar mb_staySystem;
//	Menu m_stayMenu;
//	MenuItem mi_stayReservation; // 에약하기
//	MenuItem mi_stayCancel; // 예약취소하기
//	MenuItem mi_stayViewAll; // 예약현황보기
//	MenuItem mi_stayClose; // 종료
//
//	CardLayout clStay; // 화면 전환 레이아웃
//
//	public Day24_01_Q() {
//		
//		hmStay = new HashMap<Integer, String>();
//		
//		hmStay.put(101, "빈방");
//		hmStay.put(102, "빈방");
//		hmStay.put(103, "빈방");
//
//		hmStay.put(201, "예약됨");
//		hmStay.put(202, "빈방");
//		hmStay.put(203, "빈방");
//		
//		hmStay.put(301, "예약됨");
//		hmStay.put(302, "빈방");
//		hmStay.put(303, "빈방");
//		
//		Toolkit tlDisplay = Toolkit.getDefaultToolkit();
//		Dimension dmDisplay = tlDisplay.getScreenSize();
//
//		displayX = (int) dmDisplay.getWidth();
//		displayY = (int) dmDisplay.getHeight();
//
//		initScreen();
//		initMenu();
//		initDisplay();
//
//	}
//
//	/** 기본 화면 위치 및 사이즈 조절 모듈 */
//	public void initScreen() {
//		this.setSize(500, 500);
//		this.setLocation(displayX / 2 - this.getWidth() / 2, displayY / 2 - this.getHeight() / 2);
//		this.setVisible(true);
//	}
//
//	/** 메뉴 바 생성 및 초기화 모듈 */
//	public void initMenu() {
//
//		mb_staySystem = new MenuBar();
//		m_stayMenu = new Menu("메뉴");
//		mi_stayReservation = new MenuItem("에약하기");
//		mi_stayCancel = new MenuItem("예약취소하기");
//		mi_stayViewAll = new MenuItem("예약현황보기");
//		mi_stayClose = new MenuItem("종료");
//
//		mi_stayReservation.addActionListener(this);
//		mi_stayCancel.addActionListener(this);
//		mi_stayViewAll.addActionListener(this);
//		mi_stayClose.addActionListener(this);
//
//		this.setMenuBar(mb_staySystem);
//		mb_staySystem.add(m_stayMenu);
//		m_stayMenu.add(mi_stayReservation);
//		m_stayMenu.add(mi_stayCancel);
//		m_stayMenu.add(mi_stayViewAll);
//		m_stayMenu.add(mi_stayClose);
//
//	}
//
//	/** 화면 구성 생성 및 초기화 모듈 */
//	public void initDisplay() {
//		clStay = new CardLayout(0,0);
//		this.setLayout(clStay);
//
//		// 메인 화면
//		Panel p_main = new Panel(new BorderLayout());
//		Label p_main_lb_title = new Label("숙박 예약관리 프로그램 v2.0", Label.CENTER);
//
//		p_main.setBackground(Color.PINK);
//		p_main_lb_title.setBackground(Color.BLUE);
//
//		p_main.add(p_main_lb_title, BorderLayout.CENTER);
//
//		// 예약 화면
//		Panel p_stayReservation = new Panel(new BorderLayout());
//		//Panel p_stayReservation = new Panel(new GridLayout(3, 1));
//		
//		p_stayReservation.setBackground(Color.GRAY);
//		
//	    // 예약 화면 - 상단
//		Panel p_stayReservation_pNorth = new Panel(new BorderLayout());
//		Label p_stayReservation_pNorth_lb_title = new Label("예 약 하 기", Label.CENTER);
//		
//		p_stayReservation_pNorth.add(p_stayReservation_pNorth_lb_title, BorderLayout.CENTER);
//	
//		p_stayReservation_pNorth.setBackground(Color.GREEN);
//		p_stayReservation_pNorth_lb_title.setBackground(Color.CYAN);
//		
//		// 예약 화면 - 중단
//		Panel p_stayReservation_pCenter = new Panel(new GridLayout(3, 3));
//		
//		Set<Integer> keySet = hmStay.keySet();
//		Iterator<Integer> keyIt = keySet.iterator();
//		
//		
//
//		while(keyIt.hasNext()){
//			int stayKey = keyIt.next();
//			String stayState = hmStay.get(stayKey);
//			if(stayState.equals("예약됨")){
//				p_stayReservation_pCenter.add(new Checkbox(""+stayKey, null, true));
//			} else {
//				p_stayReservation_pCenter.add(new Checkbox(""+stayKey, null, false));
//			}
//		}
//		
//	
//		// 예약 화면 - 하단
//		Panel p_stayReservation_pSouth = new Panel(new BorderLayout());
//		Label p_stayReservation_pSouth_lb_message = new Label("메세지 : ");
//		Button p_stayReservation_pSouth_bt_reservation = new Button("예약");
//		
//		p_stayReservation_pSouth.add(p_stayReservation_pSouth_lb_message, BorderLayout.WEST);
//		p_stayReservation_pSouth.add(p_stayReservation_pSouth_bt_reservation, BorderLayout.EAST);
//		
//		
//		
//		p_stayReservation.add(p_stayReservation_pNorth, BorderLayout.NORTH);
//		p_stayReservation.add(p_stayReservation_pCenter, BorderLayout.CENTER);
//		p_stayReservation.add(p_stayReservation_pSouth, BorderLayout.SOUTH);
//		//p_stayReservation.add(p_stayReservation_pNorth);
//		//p_stayReservation.add(p_stayReservation_pCenter);
//		//p_stayReservation.add(p_stayReservation_pSouth);
//		
//		// 예약 취소 화면
//		Panel p_stayCancel = new Panel();
//
//		p_stayCancel.setBackground(Color.CYAN);
//
//		// 예약 현황 화면
//		Panel p_stayViewAll = new Panel();
//
//		p_stayViewAll.setBackground(Color.black);
//
//		this.add("p_main", p_main);
//		this.add("p_stayReservation", p_stayReservation);
//		this.add("p_stayCancel", p_stayCancel);
//		this.add("p_stayViewAll", p_stayViewAll);
//		
//		
//
//	}
//
////	@Override
////	public Insets getInsets() {
////		// TODO Auto-generated method stub
////		Insets i = new Insets(0, 0, 0, 0);
////		return i;
////	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		Object obj = e.getSource();
//
//		if (obj == mi_stayReservation) { // 에약하기
//			
//			clStay.show(this, "p_stayReservation");
//		} else if (obj == mi_stayCancel) { // 예약취소하기
//			clStay.show(this, "p_stayCancel");
//		} else if (obj == mi_stayViewAll) { // 예약현황보기
//			clStay.show(this, "p_stayViewAll");
//		} else if (obj == mi_stayClose) { // 종료
//			System.exit(0);
//		}
//		
//		this.validate();
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Day24_01_Q d24 = new Day24_01_Q();
//
//	}
//}
