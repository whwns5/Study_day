package phoneBook2;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PhonBook extends Frame implements ActionListener{
	
	/**����������Ʈ*/
	MenuBar mb;
	Menu m_menu;
	MenuItem mi_add,mi_find,mi_list,mi_close,mi_modify;
	Panel p_main;
	
	/**�⺻ȭ��*/
	Label lb_main_title;
	
	/**��ϰ��� ������Ʈ*/
	Label lb_add_title,lb_add_name,lb_add_age,lb_add_addr,lb_add_tel,lb_add_msg;
	TextField tf_add_name,tf_add_age,tf_add_addr,tf_add_tel;
	Button bt_add_result;
	
	Label lb_find_title, lb_find_name;
	TextField tf_find_name;
	Button bt_find_result;
	TextArea ta_find_content;
	
	/**��ϰ��� ������Ʈ*/
	Label lb_list_title;
	TextArea ta_list_content;
	
	/**����ȭ�� ������Ʈ*/
	Label la_modify_title,la_modify_sname,
	      la_modify_name,la_modify_age,la_modify_addr,
	      la_modify_tel,la_modify_msg,la_modify_sub_title;
	
	TextField tf_modify_sname,tf_modify_name,tf_modify_age,tf_modify_tel,tf_modify_addr;
	Button bt_modify_search,bt_modify_mo;
	/**DB���� ������Ʈ*/
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	/**�޴���,�⺻ȭ��*/
	public PhonBook() {
		super("��ȭ��ȣ��"); //�θ�Ŭ���� ������
		mb=new MenuBar();
		this.setMenuBar(mb);
		
		m_menu=new Menu("�޴�");
		mb.add(m_menu);
		
		mi_add=new MenuItem("��ȭ��ȣ ���");
		mi_find=new MenuItem("��ȭ��ȣ �˻�");
		mi_list=new MenuItem("��ȭ��ȣ ���");
		mi_modify=new MenuItem("��ȭ��ȣ ����");
		mi_close=new MenuItem("����");
		
		m_menu.add(mi_add);
		m_menu.add(mi_find);
		m_menu.add(mi_list);
		m_menu.add(mi_modify);
		m_menu.addSeparator();
		m_menu.add(mi_close);
		
		p_main=new Panel(new BorderLayout());
		this.add(p_main,"Center");
		
		lb_main_title=new Label("��ȭ��ȣ�� ���α׷� v1.0",Label.CENTER);
		p_main.add(lb_main_title, "Center");
		
        mi_add.addActionListener(this);
        mi_find.addActionListener(this);
        mi_list.addActionListener(this);
        mi_close.addActionListener(this);
        mi_modify.addActionListener(this);
        dbConnect();
	}
	/**DB ����*/
    public void dbConnect(){
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="scott";
		String pwd="1234";
		    conn=DriverManager.getConnection(url,user,pwd);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	/**���ȭ�� ���� �޼���*/
	public void makeAddView(){
		p_main=new Panel(new BorderLayout(5,5));
		//���
		lb_add_title = new Label("��ȭ��ȣ ���",Label.CENTER);
		p_main.add(lb_add_title, "North");
		//�ߴ�
		Panel p_temp1=new Panel(new GridLayout(4,2,5,5));
		lb_add_name=new Label("�̸�:");
		lb_add_age=new Label("����:");
		lb_add_addr=new Label("�ּ�:");
		lb_add_tel=new Label("��ȭ��ȣ:");
		
		tf_add_name=new TextField();
		tf_add_age=new TextField();
		tf_add_addr=new TextField();
		tf_add_tel=new TextField();
		
		p_temp1.add(lb_add_name); p_temp1.add(tf_add_name);
		p_temp1.add(lb_add_age); p_temp1.add(tf_add_age);
		p_temp1.add(lb_add_addr); p_temp1.add(tf_add_addr);
		p_temp1.add(lb_add_tel); p_temp1.add(tf_add_tel);
		
		p_main.add(p_temp1, "Center");
		//�ϴ�
		Panel p_temp2=new Panel(new BorderLayout());
		lb_add_msg=new Label("�޼���:",Label.LEFT);
		bt_add_result=new Button("����ϱ�");
		p_temp2.add(lb_add_msg,"Center");
		p_temp2.add(bt_add_result,"East");
		p_main.add(p_temp2, "South");
		
		bt_add_result.addActionListener(this);
		
	}
	/**�˻� ȭ����� �޼���*/
	public void makeFindView(){
		p_main=new Panel(new BorderLayout(5,5));
		//���
		Panel p_temp1=new Panel(new BorderLayout());
		lb_find_title=new Label("��ȭ��ȣ �˻�",Label.CENTER);
		p_temp1.add(lb_find_title,"North");
		lb_find_name=new Label("�̸�:");
		p_temp1.add(lb_find_name,"West");
		tf_find_name=new TextField();
		p_temp1.add(tf_find_name, "Center");
		bt_find_result=new Button("�˻�");
		p_temp1.add(bt_find_result,"East");
		p_main.add(p_temp1, "North");
		
		//�ߴ�
		ta_find_content=new TextArea();
		p_main.add(ta_find_content,"Center");
		bt_find_result.addActionListener(this);
	}
	/*��� ���� �޼���**/
	public void makeListView(){
		p_main=new Panel(new BorderLayout(5,5));
		//���
		lb_list_title=new Label("��ȭ��ȣ�� ���",Label.CENTER);
		p_main.add(lb_list_title, "North");
		//�ߴ�
		ta_list_content=new TextArea();
		p_main.add(ta_list_content, "Center");
		
		try{
			String sql="select * from student";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			String str="";
			if(rs.next()){
				do{
					String name=rs.getString("name");
					int age=rs.getInt("age");
					String addr=rs.getString("addr");
					String tel=rs.getString("tel");
					str+=name+"\t"+age+"\t"+addr+"\t"+tel+"\n";
				
				}while(rs.next());
				ta_list_content.setText(str);
			}else{
				ta_list_content.setText("��ϵ� ��ȭ��ȣ�� �����ϴ�.");
			}
		}catch(Exception e){
			
		}finally{
			try{
				ps.close();
				ps.close();
			}catch(Exception e2){}
		}
		
	}
	/**����ȭ�� ���� �޼���*/
	public void modifyView(){
		p_main=new Panel(new BorderLayout());
		//���
		Panel p_temp1=new Panel(new GridLayout(2,1));
		Panel p_temp1_1=new Panel(new BorderLayout());
		Panel p_temp1_2=new Panel();
	             	//����
		la_modify_title=new Label("��ȭ��ȣ ����",Label.CENTER);
		p_temp1_1.add(la_modify_title,"Center");
		            //�˻� ��
		la_modify_sname=new Label("�̸�:");
		tf_modify_sname=new TextField(12);
		bt_modify_search=new Button("�˻�");
		
		p_temp1_2.add(la_modify_sname);
		p_temp1_2.add(tf_modify_sname);       //�̸��Է� �ؽ�Ʈ
		p_temp1_2.add(bt_modify_search);      //��ư
		
		p_temp1.add(p_temp1_1);
		p_temp1.add(p_temp1_2);
		
		bt_modify_search.addActionListener(this);
		p_main.add(p_temp1, "North");
		//��ܿ��� �ؾ��� ���    �ؽ�Ʈ�� �̸� ���� �˻���ư ������ �Ʒ� �ߴܿ��� ���� ǥ��
		
		//�ߴ�
		Panel p_temp2=new Panel(new BorderLayout());  
		Panel p_temp2_1=new Panel(new BorderLayout());
		Panel p_temp2_2=new Panel(new GridLayout(4,2));
		Panel p_temp2_3=new Panel(new BorderLayout()); 
		
		la_modify_sub_title=new Label("����",Label.CENTER);   //���� Ÿ��Ʋ
		
		p_temp2_1.add(la_modify_sub_title,"South");
		p_temp2.add(p_temp2_1,"North");
		
		 la_modify_name=new Label("�̸�:");   tf_modify_name=new TextField();
		 la_modify_name=new Label("�̸�:");   tf_modify_name=new TextField();
		 la_modify_age=new Label("����:");    tf_modify_age=new TextField();
		 la_modify_addr=new Label("�ּ�:");   tf_modify_tel=new TextField();
	     la_modify_tel=new Label("��ȭ��ȣ:"); tf_modify_addr=new TextField();
	     tf_modify_name.setEditable(false);
	    p_temp2_2.add(la_modify_name); p_temp2_2.add(tf_modify_name);
	    p_temp2_2.add(la_modify_age);  p_temp2_2.add(tf_modify_age);
	    p_temp2_2.add(la_modify_addr); p_temp2_2.add(tf_modify_tel);
	    p_temp2_2.add(la_modify_tel);  p_temp2_2.add(tf_modify_addr);
	    p_temp2.add(p_temp2_2,"Center");
	  
		la_modify_msg=new Label("�޼���:"); //�޼��� ��
		bt_modify_mo=new Button("����");   //������ư
		bt_modify_mo.addActionListener(this);
		
		p_temp2_3.add(la_modify_msg,"Center");
		p_temp2_3.add(bt_modify_mo,"East");
		p_temp2.add(p_temp2_3,"South");

		
		
		
		p_main.add(p_temp2,"Center");
		
		
		
	}
	//������ ����
	@Override
    public Insets insets() {
    	Insets i=new Insets(50,10,10,10);
    	return i;
    }
    /**���� �޼���*/
	public static void main(String[] args) {
		
		PhonBook pb = new PhonBook();
		pb.setSize(300,300);
		pb.setVisible(true); 

	}
    //�̺�Ʈ ó��
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj =e.getSource();
		if(obj==mi_add){         //��� ȭ��
			this.remove(p_main);
			makeAddView();
			this.add(p_main);
			validate();
		}else if(obj==mi_find){  //�˻� ȭ��
			this.remove(p_main);
			makeFindView();
			this.add(p_main);
			validate();
		}else if(obj==mi_list){  //��κ��� ȭ��
			this.remove(p_main);
			makeListView();
			this.add(p_main);
			validate();
			
		}else if(obj==mi_modify){  //�˻� ȭ��
			this.remove(p_main);
			modifyView();
			this.add(p_main);
			validate();
		}else if(obj==mi_close){ //����
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
		}else if(obj==bt_add_result){  //��� ��ư
			infoAdd();
		}else if(obj==bt_find_result){ //�˻� ��ư
			infoFind();
		}else if(obj==bt_modify_search){ //�����ϱ� ȭ�鿡�� �˻���ư
			modifySearchButton();
		}else if(obj==bt_modify_mo){ //�����ϱ� �ϸ鿡�� ������ư
			modifyButton();
		}
		
		
	}
	/**DB��� �޼���*/
	public void infoAdd(){
		try {
			String name=tf_add_name.getText();
			int age=Integer.parseInt(tf_add_age.getText());
			String addr=tf_add_addr.getText();
			String tel=tf_add_tel.getText();
			
			String sql="insert into student values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, addr);
			ps.setString(4, tel);
			
			int count=ps.executeUpdate();
			ps.close();
			
			if(count>0){
				lb_add_msg.setText("�޼���:��ϿϷ� �Ͽ����ϴ�.");
			}else{
				lb_add_msg.setText("�޼���:��Ͽ� �����Ͽ����ϴ�.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close(); //try -> catch -> finally //fianlly�� ���ܰ� �߻��ϰ� ���ϰ� ������ �����ؾ��ϴ� �κ�
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**�˻� ���� �޼���*/
	public void infoFind(){
		try{
			String name=tf_find_name.getText();
			String sql="select * from student where name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,name);
			rs=ps.executeQuery();
			if(rs.next()){ //�̹� ���ǿ��� Ŀ���� 1�� ��ġ�ϰ��ֱ⶧���� while���� ������ �ȵȴ�.
				String str="";
				do{
				    String dbname=rs.getString("name");  //�ε��� ��ȣ�δ� 1
				    int age=rs.getInt("age");            //�ε��� ��ȣ�δ� 2
				    String addr=rs.getString("addr");    //�ε��� ��ȣ�δ� 3
				    String tel=rs.getString("tel");      //�ε��� ��ȣ�δ� 4
				    
				    str+=dbname+"\t"+age+"\t"+addr+"\t"+tel+"\t";
				    ta_find_content.setText(str);
				}while(rs.next());
					
			}else{
				ta_find_content.setText("�˻��� �л��� �����ϴ�.");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				ps.close();
			}catch(Exception e2){
				
			}
		}
	}
    /**�����ϱ� ȭ�鿡�� �˻���ư*/
	public void modifySearchButton(){
		try{
			String name=tf_modify_sname.getText();
			String sql="select * from student where name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,name);
			rs=ps.executeQuery();
			if(rs.next()){ 
				
				do{
				    String dname=rs.getString("name");
				    int age=rs.getInt("age");
				    String addr=rs.getString("addr");
				    String tel=rs.getString("tel");
				    
				    String a=Integer.toString(age);
				    tf_modify_name.setText(dname);
				    tf_modify_age.setText(a);
				    tf_modify_tel.setText(addr);
				    tf_modify_addr.setText(tel);
				}while(rs.next());
					
			}else{
				//la_modify_msg
				ta_find_content.setText("�˻��� �л��� �����ϴ�.");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				ps.close();
			}catch(Exception e2){
				
			}
		}
	}
	/**�����ϱ� ȭ�鿡�� ������ư*/
	public void modifyButton(){
		try {
			String name=tf_modify_name.getText();
			int age=Integer.parseInt(tf_modify_age.getText());
			String addr=tf_modify_tel.getText();
			String tel=tf_modify_addr.getText();
			
			String sql="update student set age=?,addr=?,tel=? where name=?";
			ps = conn.prepareStatement(sql);
			ps.setString(4, name);
			ps.setInt(1, age);
			ps.setString(2, addr);
			ps.setString(3, tel);
			
			
			int count=ps.executeUpdate();
			ps.close();
			
			if(count>0){
				la_modify_msg.setText("�޼���:�����Ϸ� �Ͽ����ϴ�.");
			}else{
				la_modify_msg.setText("�޼���:������ �����Ͽ����ϴ�.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close(); //try -> catch -> finally //fianlly�� ���ܰ� �߻��ϰ� ���ϰ� ������ �����ؾ��ϴ� �κ�
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
























