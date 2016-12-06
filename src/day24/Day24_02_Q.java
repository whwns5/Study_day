package day24;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Day24_02_Q extends Frame implements ActionListener {

	HashMap<Integer, String> hmStay; 
	
	int displayX; // 화면 크기 x
	int displayY; // 화면 크기 y

	// 메뉴 멤버 변수
	MenuBar mb_staySystem;
	Menu m_stayMenu;
	MenuItem mi_stayReservation; // 에약하기
	MenuItem mi_stayCancel; // 예약취소하기
	MenuItem mi_stayViewAll; // 예약현황보기
	MenuItem mi_stayClose; // 종료
	
	// 텍스트 필드 멤버 변수
	TextField p_stayCancel_pNorth_pSouth_tfCenter_inputNumber; // 예약 취소하기 - 사용자 번호 입력
	
	// 버튼 멤버 변수
	Button p_stayCancel_pNorth_pSouth_btEast_stayCancel; // 예약 취소하기 - 취소
	Button p_stayReservation_pSouth_bt_reservation; // 예약 하기 - 예약
	
	// 라벨 멤버 변수
	Label p_stayCancel_pSouth_lb_message; // 예약 취소하기 - 메세지
	Label p_stayReservation_pSouth_lb_message; // 예약 하기 - 메세지
	
	// 페널 멤버 변수
	Panel p_stayReservation_pCenter;

	CardLayout clStay; // 화면 전환 레이아웃

	public Day24_02_Q() {
		
		hmStay = new HashMap<Integer, String>();
		
		Toolkit tlDisplay = Toolkit.getDefaultToolkit();
		Dimension dmDisplay = tlDisplay.getScreenSize();

		displayX = (int) dmDisplay.getWidth();
		displayY = (int) dmDisplay.getHeight();

		initStayState();
		initScreen();
		initMenu();
		initDisplay();
	}
	
	/** 기본 화면 위치 및 사이즈 조절 모듈 */
	public void initScreen() {
		this.setSize(350, 220);
		this.setLocation(displayX / 2 - this.getWidth() / 2, displayY / 2 - this.getHeight() / 2);
		this.setVisible(true);
	}
	
	/** 숙박 정보 초기화 모듈 */
	public void initStayState(){
		
		hmStay.put(101, "빈방");
		hmStay.put(102, "빈방");
		hmStay.put(103, "빈방");

		hmStay.put(201, "예약됨");
		hmStay.put(202, "빈방");
		hmStay.put(203, "빈방");
		
		hmStay.put(301, "예약됨");
		hmStay.put(302, "빈방");
		hmStay.put(303, "빈방");
	}

	/** 메뉴 바 생성 및 초기화 모듈 */
	public void initMenu() {

		mb_staySystem = new MenuBar();
		m_stayMenu = new Menu("메뉴");
		mi_stayReservation = new MenuItem("에약하기");
		mi_stayCancel = new MenuItem("예약취소하기");
		mi_stayViewAll = new MenuItem("예약현황보기");
		mi_stayClose = new MenuItem("종료");

		mi_stayReservation.addActionListener(this);
		mi_stayCancel.addActionListener(this);
		mi_stayViewAll.addActionListener(this);
		mi_stayClose.addActionListener(this);

		this.setMenuBar(mb_staySystem);
		mb_staySystem.add(m_stayMenu);
		m_stayMenu.add(mi_stayReservation);
		m_stayMenu.add(mi_stayCancel);
		m_stayMenu.add(mi_stayViewAll);
		m_stayMenu.add(mi_stayClose);
	}
	
	/** 화면 구성 생성 및 초기화 모듈 */
	public void initDisplay() {
		this.setLayout(new BorderLayout());
		this.add(printMain());
	}

	/** 예약 화면 출력 모듈 */
	public Panel printStayReservation() {
		// 예약 화면
		Panel p_stayReservation = new Panel(new BorderLayout());

		// 예약 화면 - 상단
		Panel p_stayReservation_pNorth = new Panel(new BorderLayout());
		Label p_stayReservation_pNorth_lb_title = new Label("예 약 하 기", Label.CENTER);
		Font p_stayReservation_pNorth_lb_title_font = new Font("Courier New", Font.PLAIN, 20);
		
		p_stayReservation_pNorth_lb_title.setFont(p_stayReservation_pNorth_lb_title_font);
		p_stayReservation_pNorth.add(p_stayReservation_pNorth_lb_title, BorderLayout.CENTER);
		//////////////////////

		// 예약 화면 - 중단
		p_stayReservation_pCenter = new Panel(new GridLayout(3, 3));
		Font p_stayReservation_pCenter_cb_font = new Font("Courier New", Font.PLAIN, 15);
	
		Set<Integer> keySet = hmStay.keySet();
		Iterator<Integer> keyIt = keySet.iterator();
		
		while (keyIt.hasNext()) {
			int stayKey = keyIt.next();
			String stayState = hmStay.get(stayKey);
			Checkbox cbStay = new Checkbox(stayKey+" 호");
			cbStay.setFont(p_stayReservation_pCenter_cb_font);
			if (stayState.equals("예약됨")) {
				cbStay.setState(true);
				cbStay.setEnabled(false);
			} else if (stayState.equals("빈방")){
				cbStay.setState(false);
			}
			p_stayReservation_pCenter.add(cbStay);
		}
		//////////////////////
		
		// 예약 화면 - 하단
		Panel p_stayReservation_pSouth = new Panel(new BorderLayout());
		p_stayReservation_pSouth_lb_message = new Label("메세지 : ");
		p_stayReservation_pSouth_bt_reservation = new Button("예약");
		p_stayReservation_pSouth_bt_reservation.addActionListener(this);

		p_stayReservation_pSouth.add(p_stayReservation_pSouth_lb_message, BorderLayout.WEST);
		p_stayReservation_pSouth.add(p_stayReservation_pSouth_bt_reservation, BorderLayout.EAST);
		//////////////////////
		
		p_stayReservation.add(p_stayReservation_pNorth, BorderLayout.NORTH);
		p_stayReservation.add(p_stayReservation_pCenter, BorderLayout.CENTER);
		p_stayReservation.add(p_stayReservation_pSouth, BorderLayout.SOUTH);

		return p_stayReservation;
	}

	/** 예약 하기 처리 모듈 */
	public void processStayReservation() {
		for (int i = 0; i < p_stayReservation_pCenter.getComponentCount(); i++) { // 호실 수 만큼																
			Object obj = p_stayReservation_pCenter.getComponent(i);
			if (obj instanceof Checkbox) {
				Checkbox tempCheckbox = (Checkbox) obj;
				//System.out.println("getLabel = " + tempCheckbox.getLabel() + " getState = " + tempCheckbox.getState());
				if(tempCheckbox.getState() == true){ // 체크가 되어 있는 경우
					hmStay.put( Integer.parseInt( tempCheckbox.getLabel().trim().substring(0, 3) ), "예약됨");
				}
			}
		}
		
		this.removeAll();
		this.add(printStayReservation());
		p_stayReservation_pSouth_lb_message.setText("메세지 : 예약 완료됨.");
	}
	
	/** 예약 취소하기 화면 출력 모듈 */
	public Panel printStayCancel() {
		// 예약 취소 화면
		Panel p_stayCancel = new Panel(new BorderLayout());
		
		// 예약 취소 화면 - 상단
		Panel p_stayCancel_pNorth = new Panel(new BorderLayout());
		// 예약 취소 화면 - 상단 - 상단
		Panel p_stayCancel_pNorth_pNorth = new Panel(new BorderLayout());
		Label p_stayCancel_pNorth_pNorth_lb_title = new Label("예약 취소하기", Label.CENTER);
		p_stayCancel_pNorth_pNorth.add(p_stayCancel_pNorth_pNorth_lb_title, BorderLayout.CENTER);
		// 예약 취소 화면 - 상단 - 하단
		Panel p_stayCancel_pNorth_pSouth = new Panel(new BorderLayout());
		Label p_stayCancel_pNorth_pSouth_lbWest_roomNumber = new Label("방번호 :");
		p_stayCancel_pNorth_pSouth_tfCenter_inputNumber = new TextField();
		p_stayCancel_pNorth_pSouth_btEast_stayCancel = new Button("취소");
		p_stayCancel_pNorth_pSouth_btEast_stayCancel.addActionListener(this);
		
		p_stayCancel_pNorth_pSouth.add(p_stayCancel_pNorth_pSouth_lbWest_roomNumber, BorderLayout.WEST);
		p_stayCancel_pNorth_pSouth.add(p_stayCancel_pNorth_pSouth_tfCenter_inputNumber, BorderLayout.CENTER);
		p_stayCancel_pNorth_pSouth.add(p_stayCancel_pNorth_pSouth_btEast_stayCancel, BorderLayout.EAST);
		
		p_stayCancel_pNorth.add(p_stayCancel_pNorth_pNorth, BorderLayout.NORTH);
		p_stayCancel_pNorth.add(p_stayCancel_pNorth_pSouth, BorderLayout.SOUTH);
		//////////////////////
		
		// 예약 취소 화면 - 하단
		Panel p_stayCancel_pSouth = new Panel(new BorderLayout());
		p_stayCancel_pSouth_lb_message = new Label("메세지 :");

		p_stayCancel_pSouth.add(p_stayCancel_pSouth_lb_message, BorderLayout.CENTER);
		//////////////////////
		
		p_stayCancel.add(p_stayCancel_pNorth, BorderLayout.NORTH);
		p_stayCancel.add(p_stayCancel_pSouth, BorderLayout.SOUTH);
		
		return p_stayCancel;
	}
	
	/** 예약 취소하기 처리 모듈 */
	public void processStayCancel() {
		try {
			Integer inputUserNum = Integer.parseInt(p_stayCancel_pNorth_pSouth_tfCenter_inputNumber.getText());
			String stayState = hmStay.get(inputUserNum);
			if (stayState.equals("빈방")) { // 빈방일 경우
				p_stayCancel_pSouth_lb_message.setText("메세지 : 해당 호실은 빈방 입니다.");
				p_stayCancel_pNorth_pSouth_tfCenter_inputNumber.setText("");
				return;
			} else if (stayState.equals("예약됨")) { // 예약된 방일 경우
				hmStay.put(inputUserNum, "빈방");
				p_stayCancel_pSouth_lb_message.setText("메세지 : 취소 처리됨.");
				p_stayCancel_pNorth_pSouth_tfCenter_inputNumber.setText("");
				return;
			}
		} catch (NullPointerException e) {
			p_stayCancel_pSouth_lb_message.setText("메세지 : 없는 호실입니다.");
		} catch (NumberFormatException e){
			p_stayCancel_pSouth_lb_message.setText("메세지 : 숫자를 입력하세요.");
		} catch (Exception e) {
			p_stayCancel_pSouth_lb_message.setText("메세지 : 고객센터에 문의 바랍니다.");
		}

	}

	/** 예약 현황 화면 출력 모듈 */
	public Panel printStayViewAll(){
		// 예약 현황 화면
		Panel p_stayViewAll = new Panel(new BorderLayout());
		
		// 예약 현황 화면 - 상단
		Panel p_stayViewAll_pNorth = new Panel(new BorderLayout());
		Label p_stayViewAll_pNorth_lb_title = new Label("예약 현황", Label.CENTER);

		p_stayViewAll_pNorth.add(p_stayViewAll_pNorth_lb_title, BorderLayout.CENTER);
		//////////////////////

		// 예약 현황 화면 - 중단
		Panel p_stayViewAll_pCenter = new Panel(new BorderLayout());
		TextArea p_stayViewAll_pCenter_ta_viewAll = new TextArea();

		StringBuffer sbViewAll = new StringBuffer();
		
		Set<Integer> keySet = hmStay.keySet();
		Iterator<Integer> keyIt = keySet.iterator();
		
		while (keyIt.hasNext()) {
			int stayKey = keyIt.next();
			String stayState = hmStay.get(stayKey);
			sbViewAll.append(stayKey + " 호 : " + stayState + "\n");
		}
		p_stayViewAll_pCenter_ta_viewAll.setText(sbViewAll.toString());
		

		p_stayViewAll_pCenter.add(p_stayViewAll_pCenter_ta_viewAll, BorderLayout.CENTER);
		//////////////////////

		p_stayViewAll.add(p_stayViewAll_pNorth, BorderLayout.NORTH);
		p_stayViewAll.add(p_stayViewAll_pCenter, BorderLayout.CENTER);
		
		return p_stayViewAll;
	}

	/** 메인 화면 출력 모듈 */
	public Panel printMain() {
		// 메인 화면
		Panel p_main = new Panel(new BorderLayout());
		Label p_main_lb_title = new Label("숙박 예약관리 프로그램 v2.0", Label.CENTER);
		Font p_main_lb_title_font = new Font("Courier New", Font.PLAIN, 25);
		
		p_main_lb_title.setFont(p_main_lb_title_font);
		p_main.add(p_main_lb_title, BorderLayout.CENTER);

		return p_main;
	}

	// @Override
	// public Insets getInsets() {
	// // TODO Auto-generated method stub
	// Insets i = new Insets(0, 0, 0, 0);
	// return i;
	// }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj == mi_stayReservation) { // 에약하기
			this.removeAll();
			this.add(printStayReservation());
		} else if (obj == mi_stayCancel) { // 예약취소하기
			this.removeAll();
			this.add(printStayCancel());
		} else if (obj == mi_stayViewAll) { // 예약현황보기
			this.removeAll();
			this.add(printStayViewAll());
		} else if (obj == mi_stayClose) { // 종료
			System.exit(0);
		} else if ( obj == p_stayReservation_pSouth_bt_reservation){ // 예약  버튼
			processStayReservation();
		} else if  ( obj == p_stayCancel_pNorth_pSouth_btEast_stayCancel){ // 예약 취소 버튼
			processStayCancel();
		}
		this.validate();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day24_02_Q d24 = new Day24_02_Q();
	}
}
