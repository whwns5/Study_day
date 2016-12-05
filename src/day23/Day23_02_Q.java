package day23;

import java.awt.*;
import java.awt.event.*;

public class Day23_02_Q extends Frame implements ActionListener{

	MenuBar mb;
	Menu mb_m_file;
	Menu mb_m_color;
	MenuItem mb_m_mi_yellow;
	MenuItem mb_m_mi_gray;
	Menu mb_m_m_textColor;
	MenuItem mb_m_m_mi_red;
	MenuItem mb_m_m_mi_blue;
	
	Panel f_p_center;
	Panel f_p_south;
	Label f_p_south_l_textColor;
	
	public Day23_02_Q() {
		// TODO Auto-generated constructor stub
		mb = new MenuBar();
		this.setMenuBar(mb);
		
		// ����
		mb_m_file = new Menu("����");
		mb.add(mb_m_file);
		
		// ����
		mb_m_color = new Menu("����");
		mb.add(mb_m_color);
		
		mb_m_mi_yellow = new MenuItem("���");
		mb_m_mi_yellow.addActionListener(this);
		mb_m_mi_gray = new MenuItem("ȸ��");
		mb_m_mi_gray.addActionListener(this);
		mb_m_m_textColor = new Menu("���ϻ���");
		
			// ���ϻ���
			mb_m_m_mi_red = new MenuItem("����");
			mb_m_m_mi_red.addActionListener(this);
			mb_m_m_mi_blue = new MenuItem("�Ķ�");
			mb_m_m_mi_blue.addActionListener(this);
				
			mb_m_m_textColor.add(mb_m_m_mi_red);
			mb_m_m_textColor.add(mb_m_m_mi_blue);
			
		mb_m_color.add(mb_m_mi_yellow);
		mb_m_color.add(mb_m_mi_gray);
		mb_m_color.add(mb_m_m_textColor);
		
		this.setLayout(new BorderLayout());
	
		f_p_center = new Panel();
		f_p_south = new Panel(new BorderLayout());
		f_p_south_l_textColor = new Label("���ڻ�..", Label.LEFT);
		f_p_south.add(f_p_south_l_textColor, BorderLayout.CENTER);
		
		this.add(f_p_center, BorderLayout.CENTER);
		this.add(f_p_south, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day23_02_Q d = new Day23_02_Q();
		d.setSize(300, 300);
		d.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj == mb_m_mi_yellow) {
			f_p_center.setBackground(Color.yellow);
		} else if (obj == mb_m_mi_gray) {
			f_p_center.setBackground(Color.gray);
		} else if (obj == mb_m_m_mi_red) {
			f_p_south_l_textColor.setBackground(Color.red);
		} else if (obj == mb_m_m_mi_blue) {
			f_p_south_l_textColor.setBackground(Color.blue);
		}
	}

}
