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
//	int displayX; // ȭ�� ũ�� x
//	int displayY; // ȭ�� ũ�� y
//
//	// �޴� ��� ����
//	MenuBar mb_staySystem;
//	Menu m_stayMenu;
//	MenuItem mi_stayReservation; // �����ϱ�
//	MenuItem mi_stayCancel; // ��������ϱ�
//	MenuItem mi_stayViewAll; // ������Ȳ����
//	MenuItem mi_stayClose; // ����
//
//	CardLayout clStay; // ȭ�� ��ȯ ���̾ƿ�
//
//	public Day24_01_Q() {
//		
//		hmStay = new HashMap<Integer, String>();
//		
//		hmStay.put(101, "���");
//		hmStay.put(102, "���");
//		hmStay.put(103, "���");
//
//		hmStay.put(201, "�����");
//		hmStay.put(202, "���");
//		hmStay.put(203, "���");
//		
//		hmStay.put(301, "�����");
//		hmStay.put(302, "���");
//		hmStay.put(303, "���");
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
//	/** �⺻ ȭ�� ��ġ �� ������ ���� ��� */
//	public void initScreen() {
//		this.setSize(500, 500);
//		this.setLocation(displayX / 2 - this.getWidth() / 2, displayY / 2 - this.getHeight() / 2);
//		this.setVisible(true);
//	}
//
//	/** �޴� �� ���� �� �ʱ�ȭ ��� */
//	public void initMenu() {
//
//		mb_staySystem = new MenuBar();
//		m_stayMenu = new Menu("�޴�");
//		mi_stayReservation = new MenuItem("�����ϱ�");
//		mi_stayCancel = new MenuItem("��������ϱ�");
//		mi_stayViewAll = new MenuItem("������Ȳ����");
//		mi_stayClose = new MenuItem("����");
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
//	/** ȭ�� ���� ���� �� �ʱ�ȭ ��� */
//	public void initDisplay() {
//		clStay = new CardLayout(0,0);
//		this.setLayout(clStay);
//
//		// ���� ȭ��
//		Panel p_main = new Panel(new BorderLayout());
//		Label p_main_lb_title = new Label("���� ������� ���α׷� v2.0", Label.CENTER);
//
//		p_main.setBackground(Color.PINK);
//		p_main_lb_title.setBackground(Color.BLUE);
//
//		p_main.add(p_main_lb_title, BorderLayout.CENTER);
//
//		// ���� ȭ��
//		Panel p_stayReservation = new Panel(new BorderLayout());
//		//Panel p_stayReservation = new Panel(new GridLayout(3, 1));
//		
//		p_stayReservation.setBackground(Color.GRAY);
//		
//	    // ���� ȭ�� - ���
//		Panel p_stayReservation_pNorth = new Panel(new BorderLayout());
//		Label p_stayReservation_pNorth_lb_title = new Label("�� �� �� ��", Label.CENTER);
//		
//		p_stayReservation_pNorth.add(p_stayReservation_pNorth_lb_title, BorderLayout.CENTER);
//	
//		p_stayReservation_pNorth.setBackground(Color.GREEN);
//		p_stayReservation_pNorth_lb_title.setBackground(Color.CYAN);
//		
//		// ���� ȭ�� - �ߴ�
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
//			if(stayState.equals("�����")){
//				p_stayReservation_pCenter.add(new Checkbox(""+stayKey, null, true));
//			} else {
//				p_stayReservation_pCenter.add(new Checkbox(""+stayKey, null, false));
//			}
//		}
//		
//	
//		// ���� ȭ�� - �ϴ�
//		Panel p_stayReservation_pSouth = new Panel(new BorderLayout());
//		Label p_stayReservation_pSouth_lb_message = new Label("�޼��� : ");
//		Button p_stayReservation_pSouth_bt_reservation = new Button("����");
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
//		// ���� ��� ȭ��
//		Panel p_stayCancel = new Panel();
//
//		p_stayCancel.setBackground(Color.CYAN);
//
//		// ���� ��Ȳ ȭ��
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
//		if (obj == mi_stayReservation) { // �����ϱ�
//			
//			clStay.show(this, "p_stayReservation");
//		} else if (obj == mi_stayCancel) { // ��������ϱ�
//			clStay.show(this, "p_stayCancel");
//		} else if (obj == mi_stayViewAll) { // ������Ȳ����
//			clStay.show(this, "p_stayViewAll");
//		} else if (obj == mi_stayClose) { // ����
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
