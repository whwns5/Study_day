package day23;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuTest extends Frame	implements ActionListener{
	
	MenuBar mb; // 빨랫줄
	Menu m_file; // 빨래집개
	MenuItem mi_save, mi_load, mi_close; // 빨래
	Menu m_close_menu;
	MenuItem mi_save1, mi_load1;

	
	public MenuTest() {
		// TODO Auto-generated constructor stub
		mb = new MenuBar();
		this.setMenuBar(mb);
		
		m_file = new Menu("파일");
		mb.add(m_file);
		
		mi_save = new MenuItem("저장하기");
		mi_load = new MenuItem("불러오기");
		mi_close = new MenuItem("종료");
		
		m_close_menu = new Menu("이하");
		mi_save1 = new MenuItem("저장하기1");
		mi_load1 = new MenuItem("불러오기1");
		
		mi_save.addActionListener(this);
		mi_load.addActionListener(this);
		mi_close.addActionListener(this);
			
		m_file.add(mi_save);
		m_file.add(mi_load);
		m_file.addSeparator();	
		m_file.add(mi_close);
		
		m_file.add(m_close_menu);
		m_close_menu.add(mi_save1);
		m_close_menu.add(mi_load1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuTest mt = new MenuTest();
		mt.setSize(300, 300);
		mt.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if(obj == mi_save){
			
		} else if (obj == mi_load){
			
		} else if(obj == mi_close){
			System.exit(0);
		}
		
	}

}
