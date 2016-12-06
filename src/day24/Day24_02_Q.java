package day24;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Day24_02_Q extends Frame implements ActionListener {

	HashMap<Integer, String> hmStay; 
	
	int displayX; // ȭ�� ũ�� x
	int displayY; // ȭ�� ũ�� y

	// �޴� ��� ����
	MenuBar mb_staySystem;
	Menu m_stayMenu;
	MenuItem mi_stayReservation; // �����ϱ�
	MenuItem mi_stayCancel; // ��������ϱ�
	MenuItem mi_stayViewAll; // ������Ȳ����
	MenuItem mi_stayClose; // ����
	
	// �ؽ�Ʈ �ʵ� ��� ����
	TextField p_stayCancel_pNorth_pSouth_tfCenter_inputNumber; // ���� ����ϱ� - ����� ��ȣ �Է�
	
	// ��ư ��� ����
	Button p_stayCancel_pNorth_pSouth_btEast_stayCancel; // ���� ����ϱ� - ���
	Button p_stayReservation_pSouth_bt_reservation; // ���� �ϱ� - ����
	
	// �� ��� ����
	Label p_stayCancel_pSouth_lb_message; // ���� ����ϱ� - �޼���
	Label p_stayReservation_pSouth_lb_message; // ���� �ϱ� - �޼���
	
	// ��� ��� ����
	Panel p_stayReservation_pCenter;

	CardLayout clStay; // ȭ�� ��ȯ ���̾ƿ�

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
	
	/** �⺻ ȭ�� ��ġ �� ������ ���� ��� */
	public void initScreen() {
		this.setSize(350, 220);
		this.setLocation(displayX / 2 - this.getWidth() / 2, displayY / 2 - this.getHeight() / 2);
		this.setVisible(true);
	}
	
	/** ���� ���� �ʱ�ȭ ��� */
	public void initStayState(){
		
		hmStay.put(101, "���");
		hmStay.put(102, "���");
		hmStay.put(103, "���");

		hmStay.put(201, "�����");
		hmStay.put(202, "���");
		hmStay.put(203, "���");
		
		hmStay.put(301, "�����");
		hmStay.put(302, "���");
		hmStay.put(303, "���");
	}

	/** �޴� �� ���� �� �ʱ�ȭ ��� */
	public void initMenu() {

		mb_staySystem = new MenuBar();
		m_stayMenu = new Menu("�޴�");
		mi_stayReservation = new MenuItem("�����ϱ�");
		mi_stayCancel = new MenuItem("��������ϱ�");
		mi_stayViewAll = new MenuItem("������Ȳ����");
		mi_stayClose = new MenuItem("����");

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
	
	/** ȭ�� ���� ���� �� �ʱ�ȭ ��� */
	public void initDisplay() {
		this.setLayout(new BorderLayout());
		this.add(printMain());
	}

	/** ���� ȭ�� ��� ��� */
	public Panel printStayReservation() {
		// ���� ȭ��
		Panel p_stayReservation = new Panel(new BorderLayout());

		// ���� ȭ�� - ���
		Panel p_stayReservation_pNorth = new Panel(new BorderLayout());
		Label p_stayReservation_pNorth_lb_title = new Label("�� �� �� ��", Label.CENTER);
		Font p_stayReservation_pNorth_lb_title_font = new Font("Courier New", Font.PLAIN, 20);
		
		p_stayReservation_pNorth_lb_title.setFont(p_stayReservation_pNorth_lb_title_font);
		p_stayReservation_pNorth.add(p_stayReservation_pNorth_lb_title, BorderLayout.CENTER);
		//////////////////////

		// ���� ȭ�� - �ߴ�
		p_stayReservation_pCenter = new Panel(new GridLayout(3, 3));
		Font p_stayReservation_pCenter_cb_font = new Font("Courier New", Font.PLAIN, 15);
	
		Set<Integer> keySet = hmStay.keySet();
		Iterator<Integer> keyIt = keySet.iterator();
		
		while (keyIt.hasNext()) {
			int stayKey = keyIt.next();
			String stayState = hmStay.get(stayKey);
			Checkbox cbStay = new Checkbox(stayKey+" ȣ");
			cbStay.setFont(p_stayReservation_pCenter_cb_font);
			if (stayState.equals("�����")) {
				cbStay.setState(true);
				cbStay.setEnabled(false);
			} else if (stayState.equals("���")){
				cbStay.setState(false);
			}
			p_stayReservation_pCenter.add(cbStay);
		}
		//////////////////////
		
		// ���� ȭ�� - �ϴ�
		Panel p_stayReservation_pSouth = new Panel(new BorderLayout());
		p_stayReservation_pSouth_lb_message = new Label("�޼��� : ");
		p_stayReservation_pSouth_bt_reservation = new Button("����");
		p_stayReservation_pSouth_bt_reservation.addActionListener(this);

		p_stayReservation_pSouth.add(p_stayReservation_pSouth_lb_message, BorderLayout.WEST);
		p_stayReservation_pSouth.add(p_stayReservation_pSouth_bt_reservation, BorderLayout.EAST);
		//////////////////////
		
		p_stayReservation.add(p_stayReservation_pNorth, BorderLayout.NORTH);
		p_stayReservation.add(p_stayReservation_pCenter, BorderLayout.CENTER);
		p_stayReservation.add(p_stayReservation_pSouth, BorderLayout.SOUTH);

		return p_stayReservation;
	}

	/** ���� �ϱ� ó�� ��� */
	public void processStayReservation() {
		for (int i = 0; i < p_stayReservation_pCenter.getComponentCount(); i++) { // ȣ�� �� ��ŭ																
			Object obj = p_stayReservation_pCenter.getComponent(i);
			if (obj instanceof Checkbox) {
				Checkbox tempCheckbox = (Checkbox) obj;
				//System.out.println("getLabel = " + tempCheckbox.getLabel() + " getState = " + tempCheckbox.getState());
				if(tempCheckbox.getState() == true){ // üũ�� �Ǿ� �ִ� ���
					hmStay.put( Integer.parseInt( tempCheckbox.getLabel().trim().substring(0, 3) ), "�����");
				}
			}
		}
		
		this.removeAll();
		this.add(printStayReservation());
		p_stayReservation_pSouth_lb_message.setText("�޼��� : ���� �Ϸ��.");
	}
	
	/** ���� ����ϱ� ȭ�� ��� ��� */
	public Panel printStayCancel() {
		// ���� ��� ȭ��
		Panel p_stayCancel = new Panel(new BorderLayout());
		
		// ���� ��� ȭ�� - ���
		Panel p_stayCancel_pNorth = new Panel(new BorderLayout());
		// ���� ��� ȭ�� - ��� - ���
		Panel p_stayCancel_pNorth_pNorth = new Panel(new BorderLayout());
		Label p_stayCancel_pNorth_pNorth_lb_title = new Label("���� ����ϱ�", Label.CENTER);
		p_stayCancel_pNorth_pNorth.add(p_stayCancel_pNorth_pNorth_lb_title, BorderLayout.CENTER);
		// ���� ��� ȭ�� - ��� - �ϴ�
		Panel p_stayCancel_pNorth_pSouth = new Panel(new BorderLayout());
		Label p_stayCancel_pNorth_pSouth_lbWest_roomNumber = new Label("���ȣ :");
		p_stayCancel_pNorth_pSouth_tfCenter_inputNumber = new TextField();
		p_stayCancel_pNorth_pSouth_btEast_stayCancel = new Button("���");
		p_stayCancel_pNorth_pSouth_btEast_stayCancel.addActionListener(this);
		
		p_stayCancel_pNorth_pSouth.add(p_stayCancel_pNorth_pSouth_lbWest_roomNumber, BorderLayout.WEST);
		p_stayCancel_pNorth_pSouth.add(p_stayCancel_pNorth_pSouth_tfCenter_inputNumber, BorderLayout.CENTER);
		p_stayCancel_pNorth_pSouth.add(p_stayCancel_pNorth_pSouth_btEast_stayCancel, BorderLayout.EAST);
		
		p_stayCancel_pNorth.add(p_stayCancel_pNorth_pNorth, BorderLayout.NORTH);
		p_stayCancel_pNorth.add(p_stayCancel_pNorth_pSouth, BorderLayout.SOUTH);
		//////////////////////
		
		// ���� ��� ȭ�� - �ϴ�
		Panel p_stayCancel_pSouth = new Panel(new BorderLayout());
		p_stayCancel_pSouth_lb_message = new Label("�޼��� :");

		p_stayCancel_pSouth.add(p_stayCancel_pSouth_lb_message, BorderLayout.CENTER);
		//////////////////////
		
		p_stayCancel.add(p_stayCancel_pNorth, BorderLayout.NORTH);
		p_stayCancel.add(p_stayCancel_pSouth, BorderLayout.SOUTH);
		
		return p_stayCancel;
	}
	
	/** ���� ����ϱ� ó�� ��� */
	public void processStayCancel() {
		try {
			Integer inputUserNum = Integer.parseInt(p_stayCancel_pNorth_pSouth_tfCenter_inputNumber.getText());
			String stayState = hmStay.get(inputUserNum);
			if (stayState.equals("���")) { // ����� ���
				p_stayCancel_pSouth_lb_message.setText("�޼��� : �ش� ȣ���� ��� �Դϴ�.");
				p_stayCancel_pNorth_pSouth_tfCenter_inputNumber.setText("");
				return;
			} else if (stayState.equals("�����")) { // ����� ���� ���
				hmStay.put(inputUserNum, "���");
				p_stayCancel_pSouth_lb_message.setText("�޼��� : ��� ó����.");
				p_stayCancel_pNorth_pSouth_tfCenter_inputNumber.setText("");
				return;
			}
		} catch (NullPointerException e) {
			p_stayCancel_pSouth_lb_message.setText("�޼��� : ���� ȣ���Դϴ�.");
		} catch (NumberFormatException e){
			p_stayCancel_pSouth_lb_message.setText("�޼��� : ���ڸ� �Է��ϼ���.");
		} catch (Exception e) {
			p_stayCancel_pSouth_lb_message.setText("�޼��� : �����Ϳ� ���� �ٶ��ϴ�.");
		}

	}

	/** ���� ��Ȳ ȭ�� ��� ��� */
	public Panel printStayViewAll(){
		// ���� ��Ȳ ȭ��
		Panel p_stayViewAll = new Panel(new BorderLayout());
		
		// ���� ��Ȳ ȭ�� - ���
		Panel p_stayViewAll_pNorth = new Panel(new BorderLayout());
		Label p_stayViewAll_pNorth_lb_title = new Label("���� ��Ȳ", Label.CENTER);

		p_stayViewAll_pNorth.add(p_stayViewAll_pNorth_lb_title, BorderLayout.CENTER);
		//////////////////////

		// ���� ��Ȳ ȭ�� - �ߴ�
		Panel p_stayViewAll_pCenter = new Panel(new BorderLayout());
		TextArea p_stayViewAll_pCenter_ta_viewAll = new TextArea();

		StringBuffer sbViewAll = new StringBuffer();
		
		Set<Integer> keySet = hmStay.keySet();
		Iterator<Integer> keyIt = keySet.iterator();
		
		while (keyIt.hasNext()) {
			int stayKey = keyIt.next();
			String stayState = hmStay.get(stayKey);
			sbViewAll.append(stayKey + " ȣ : " + stayState + "\n");
		}
		p_stayViewAll_pCenter_ta_viewAll.setText(sbViewAll.toString());
		

		p_stayViewAll_pCenter.add(p_stayViewAll_pCenter_ta_viewAll, BorderLayout.CENTER);
		//////////////////////

		p_stayViewAll.add(p_stayViewAll_pNorth, BorderLayout.NORTH);
		p_stayViewAll.add(p_stayViewAll_pCenter, BorderLayout.CENTER);
		
		return p_stayViewAll;
	}

	/** ���� ȭ�� ��� ��� */
	public Panel printMain() {
		// ���� ȭ��
		Panel p_main = new Panel(new BorderLayout());
		Label p_main_lb_title = new Label("���� ������� ���α׷� v2.0", Label.CENTER);
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

		if (obj == mi_stayReservation) { // �����ϱ�
			this.removeAll();
			this.add(printStayReservation());
		} else if (obj == mi_stayCancel) { // ��������ϱ�
			this.removeAll();
			this.add(printStayCancel());
		} else if (obj == mi_stayViewAll) { // ������Ȳ����
			this.removeAll();
			this.add(printStayViewAll());
		} else if (obj == mi_stayClose) { // ����
			System.exit(0);
		} else if ( obj == p_stayReservation_pSouth_bt_reservation){ // ����  ��ư
			processStayReservation();
		} else if  ( obj == p_stayCancel_pNorth_pSouth_btEast_stayCancel){ // ���� ��� ��ư
			processStayCancel();
		}
		this.validate();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day24_02_Q d24 = new Day24_02_Q();
	}
}
