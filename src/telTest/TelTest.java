package telTest;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TelTest extends Frame implements ActionListener{

	int displayX; // ���� ȭ��ũ�� x
	int displayY; // ���� ȭ��ũ�� y
	
	// �޴� ������Ʈ
	MenuBar mb;
	Menu m;
	MenuItem mi_regist; // ��� �޴�
	MenuItem mi_search; // �˻� �޴�
	MenuItem mi_allView; // ��ȸ �޴�
	MenuItem mi_exit; // ���� �޴�

	public TelTest(){
		initScreen(); // �⺻ ȭ�� ��ġ �� ������ ���� �޼���
		initMenu(); // �޴� �� ���� �� �ʱ�ȭ �޼���
		initDisplay(); // ȭ�� ���� ���� �� �ʱ�ȭ �޼���
	}
	
	/** �⺻ ȭ�� ��ġ �� ������ ���� �޼��� */
	public void initScreen() {
		Toolkit tlDisplay = Toolkit.getDefaultToolkit(); // ��Ŷ ��ü�� �����Ѵ�.
		Dimension dm = tlDisplay.getScreenSize(); // ��Ŷ ��ü�� ���� ���� ȭ���� ��ũ�� ����� ���� 
		 										  // Dimension ��ü�� �����Ѵ�.

		this.displayX = (int) dm.getWidth();
		this.displayY = (int) dm.getHeight();

		this.setSize(displayX, displayY);
		//this.setSize(450, 220);
		//this.setLocation(displayX / 2 - this.getWidth() / 2, displayY / 2 - this.getHeight() / 2);
		this.setVisible(true);
	}

	/** �޴� �� ���� �� �ʱ�ȭ �޼��� */
	public void initMenu() {
		mb = new MenuBar();
		m = new Menu("�޴�");
		mi_regist = new MenuItem("��ȭ��ȣ ���");
		mi_search = new MenuItem("��ȭ��ȣ �˻�");
		mi_allView = new MenuItem("��� ��ȭ��ȣ ����");
		mi_exit = new MenuItem("����");

		// �׼Ǹ����� ���
		mi_regist.addActionListener(this);
		mi_search.addActionListener(this);
		mi_allView.addActionListener(this);
		mi_exit.addActionListener(this);
		
		// �����ӿ� ����
		this.setMenuBar(mb);
		mb.add(m);
		m.add(mi_regist);
		m.add(mi_search);
		m.add(mi_allView);
		m.addSeparator();
		m.add(mi_exit);
	}

	/** ȭ�� ���� ���� �� �ʱ�ȭ �޼��� */
	public void initDisplay() {
		this.setLayout(new BorderLayout());
		this.add(new MainDisplay(), BorderLayout.CENTER); // ���� ȭ�� Panel ����
	}
	
	/** ȭ�� ��ȯ �޼��� */
	public void changeDisplay(Object obj) {
		this.removeAll(); // Frame ���� ��ü ������Ʈ�� ����.
		if (obj == mi_regist) { // ��� ȭ������ ��ȯ�̸�
			this.add(new RegistDisplay(), BorderLayout.CENTER); // ��� ȭ�� Panel ����
		} else if (obj == mi_search) { // �˻� ȭ������ ��ȯ�̸�
			this.add(new SearchDisplay(), BorderLayout.CENTER); // �˻� ȭ�� Panel ����
		} else if (obj == mi_allView) { // ��ü���� ȭ������ ��ȯ�̸�
			this.add(new AllViewDisplay(), BorderLayout.CENTER); // ��ȸ ȭ�� Panel ����
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

		if (obj == mi_regist || obj == mi_search || obj == mi_allView) { // ���, �˻�, ��ȸ �޴��϶�
			changeDisplay(obj); // ȭ�� ��ȯ �޼���
		} else if (obj == mi_exit) {
			System.exit(0);
		}
		
		this.validate(); // ȭ���� �����Ѵ�.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelTest telProgram = new TelTest();
	}

}
