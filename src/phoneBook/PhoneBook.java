package phoneBook;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PhoneBook extends Frame implements ActionListener{

	/** ���� ������Ʈ */
	MenuBar mb;
	Menu m_menu;
	MenuItem mi_add, mi_find, mi_list, mi_close;
	
	Panel p_main;
	
	/** �⺻ ȭ�� */
	Label lb_main_title;
	
	/** ��ϰ��� ������Ʈ */
	Label lb_add_title, lb_add_name, lb_add_age, lb_add_addr, lb_add_tel, lb_add_msg;
	TextField tf_add_name, tf_add_age, tf_add_addr, tf_add_tel;
	Button bt_add_result;
	
	/** �˻����� ������Ʈ */
	Label lb_find_title, lb_find_name;
	TextField tf_find_name;
	TextArea ta_find_content;
	Button bt_find_result;
	
	/** ��ϰ��� ������Ʈ */
	Label lb_list_title;
	TextArea ta_list_content;
	
	/** DB ���� ������Ʈ */
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public PhoneBook() {
		super("��ȭ��ȣ��");
		
		mb = new MenuBar();
		this.setMenuBar(mb);
		
		m_menu = new Menu("�޴�");
		mb.add(m_menu);
		
		mi_add = new MenuItem("��ȭ��ȣ���");
		mi_find = new MenuItem("��ȭ��ȣ�˻�");
		mi_list = new MenuItem("��ȭ��ȣ���");
		mi_close = new MenuItem("�ݱ�");
		
		m_menu.add(mi_add);
		m_menu.add(mi_find);
		m_menu.add(mi_list);
		m_menu.addSeparator();
		m_menu.add(mi_close);
		
		p_main = new Panel(new BorderLayout());
		this.add(p_main, BorderLayout.CENTER);
		lb_main_title = new Label("��ȭ��ȣ�� ���α׷� v1.0", Label.CENTER	);
		p_main.add(lb_main_title, BorderLayout.CENTER);
		
		mi_add.addActionListener(this);
		mi_find.addActionListener(this);
		mi_list.addActionListener(this);
		mi_close.addActionListener(this);
		
		dbConnect();
	}
	
	public void dbConnect(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "1234";
			
			conn = DriverManager.getConnection(url, user, pwd);		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	/** ���ȭ�� ���� �޼��� */
	public void makeAddview(){
		p_main = new Panel(new BorderLayout(5, 5));
		// ���
		lb_add_title = new Label("��ȭ��ȣ �", Label.CENTER);
		p_main.add(lb_add_title, BorderLayout.NORTH);
		// �ߴ�
		Panel p_temp1 = new Panel(new GridLayout(4, 2, 5, 5));
		lb_add_name = new Label("�̸�");
		lb_add_age = new Label("����");
		lb_add_addr = new Label("�ּ�");
		lb_add_tel = new Label("��ȭ��ȣ");
		
		tf_add_name = new TextField();
		tf_add_age = new TextField();
		tf_add_addr = new TextField();
		tf_add_tel = new TextField();
		
		p_temp1.add(lb_add_name);
		p_temp1.add(tf_add_name);
		
		p_temp1.add(lb_add_age);
		p_temp1.add(tf_add_age);
		
		p_temp1.add(lb_add_addr);
		p_temp1.add(tf_add_addr);
		
		p_temp1.add(lb_add_tel);
		p_temp1.add(tf_add_tel);
		
		p_main.add(p_temp1, BorderLayout.CENTER);
		// �ϴ�
		Panel p_temp2 = new Panel(new BorderLayout());
		lb_add_msg = new Label("�޼��� :", Label.LEFT);
		bt_add_result = new Button("���");
		
		bt_add_result.addActionListener(this);
		
		p_temp2.add(lb_add_msg, BorderLayout.WEST);
		p_temp2.add(bt_add_result, BorderLayout.EAST);
		
		p_main.add(p_temp2, BorderLayout.SOUTH);
	}
	
	/** �˻����� ȭ�� �޼��� */
	public void makeFindView(){
		p_main = new Panel(new BorderLayout(5,5));
		// ���
		Panel p_temp1 = new Panel(new BorderLayout());
		lb_find_title = new Label("��ȭ��ȣ �˻�", Label.CENTER);
		p_temp1.add(lb_find_title, BorderLayout.NORTH);
		lb_find_name = new Label("�̸�");
		p_temp1.add(lb_find_name, BorderLayout.WEST);
		tf_find_name = new TextField();
		p_temp1.add(tf_find_name, BorderLayout.CENTER);
		bt_find_result = new Button("�˻�");
		p_temp1.add(bt_find_result, BorderLayout.EAST);
		
		bt_find_result.addActionListener(this);
		
		p_main.add(p_temp1, BorderLayout.NORTH);
		// �ߴ�
		ta_find_content = new TextArea();
		p_main.add(ta_find_content, BorderLayout.CENTER);
		
	}
	
	/** ��ϰ��� ȭ�� �޼��� */
	public void makeListView(){
		p_main = new Panel(new BorderLayout(5, 5));
		
		// ���
		lb_list_title = new Label("��ȭ��ȣ�� ���", Label.CENTER);
		p_main.add(lb_list_title,BorderLayout.NORTH);
		// �ߴ�
		ta_list_content = new TextArea();
		p_main.add(ta_list_content, BorderLayout.CENTER);
		
		try{
			String sql = "SELECT * FROM student";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			String str = "";
			
			if(rs.next()){
				do{
					String dbName = rs.getString("name");
					int dbAge = rs.getInt("age");
					String dbAddr = rs.getString("addr");
					String dbTel = rs.getString("tel");;
					
					str += dbName + "\t" + dbAge + "\t" + dbAddr + "\t"+ dbTel + "\n";
					
				}while(rs.next());
				
				ta_list_content.setText(str);
			}else{
				ta_list_content.setText("��ϵ� �л��� �����ϴ�.");
			}
			
		}catch(Exception e){
			
		}finally {
			try{
				rs.close();
				pstmt.close();
			}catch(Exception e){
				
			}
		}
	}
	
	@Override
	public Insets getInsets() {
		// TODO Auto-generated method stub
		Insets i = new Insets(55, 10, 10, 10);
		return i;
	}
	
	public static void main(String[] args) {
		PhoneBook pb = new PhoneBook();
		pb.setSize(300, 300);
		pb.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj == mi_add) {
			this.remove(p_main);
			makeAddview();
			this.add(p_main);
			this.validate();
		} else if (obj == mi_find) {
			this.remove(p_main);
			makeFindView();
			this.add(p_main);
			this.validate();
		} else if (obj == mi_list) {
			this.remove(p_main);
			makeListView();
			this.add(p_main);
			this.validate();
		} else if (obj == mi_close) {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
		} else if (obj == bt_add_result) {
			infoAdd();
			this.validate();
		} else if(obj == bt_find_result){
			infoFind();
			this.validate();
		}
	}
	
	/** DB ��� �޼��� */
	public void infoAdd() {
		try{
			String name = tf_add_name.getText();
			int age = Integer.parseInt(tf_add_age.getText());
			String addr = tf_add_addr.getText();
			String tel = tf_add_tel.getText();

			String sql = "INSERT INTO student VALUES(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, addr);
			pstmt.setString(4, tel);

			int count = pstmt.executeUpdate();

			if (count > 0) {
				lb_add_msg.setText("�޼��� : ��� �Ϸ� �Ͽ����ϴ�.");
			} else {
				lb_add_msg.setText("�޼��� : ��Ͽ� ���� �Ͽ����ϴ�.");
			}
			
			//conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/** DB �˻� �޼��� */
	public void infoFind(){
		try{
			String name = tf_find_name.getText();
			String sql = "SELECT * FROM student WHERE name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				String str = "";
				do{
					String dbName = rs.getString("name");
					int dbAge = rs.getInt("age");
					String dbAddr = rs.getString("addr");
					String dbTel = rs.getString("tel");
					str += dbName + "\t" + dbAge + "\t" + dbAddr + "\t" + dbTel + "\n";
					
				}while(rs.next());
				
				ta_find_content.setText(str);
			}else{
				ta_find_content.setText("�˻��� �л��� �����ϴ�.");
			}
			
		}catch(Exception e){
			
		}finally{
			try{
				rs.close();
				pstmt.close();
			}catch(Exception e2){
				
			}
		}
	}

}
