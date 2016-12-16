package phoneBook2;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PhonBook extends Frame implements ActionListener{
	
	/**공통컴포넌트*/
	MenuBar mb;
	Menu m_menu;
	MenuItem mi_add,mi_find,mi_list,mi_close,mi_modify;
	Panel p_main;
	
	/**기본화면*/
	Label lb_main_title;
	
	/**등록관련 컴포넌트*/
	Label lb_add_title,lb_add_name,lb_add_age,lb_add_addr,lb_add_tel,lb_add_msg;
	TextField tf_add_name,tf_add_age,tf_add_addr,tf_add_tel;
	Button bt_add_result;
	
	Label lb_find_title, lb_find_name;
	TextField tf_find_name;
	Button bt_find_result;
	TextArea ta_find_content;
	
	/**목록관련 컴포넌트*/
	Label lb_list_title;
	TextArea ta_list_content;
	
	/**수정화면 컴포넌트*/
	Label la_modify_title,la_modify_sname,
	      la_modify_name,la_modify_age,la_modify_addr,
	      la_modify_tel,la_modify_msg,la_modify_sub_title;
	
	TextField tf_modify_sname,tf_modify_name,tf_modify_age,tf_modify_tel,tf_modify_addr;
	Button bt_modify_search,bt_modify_mo;
	/**DB관련 컴포넌트*/
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	/**메뉴바,기본화면*/
	public PhonBook() {
		super("전화번호부"); //부모클래스 생성자
		mb=new MenuBar();
		this.setMenuBar(mb);
		
		m_menu=new Menu("메뉴");
		mb.add(m_menu);
		
		mi_add=new MenuItem("전화번호 등록");
		mi_find=new MenuItem("전화번호 검색");
		mi_list=new MenuItem("전화번호 목록");
		mi_modify=new MenuItem("전화번호 수정");
		mi_close=new MenuItem("종료");
		
		m_menu.add(mi_add);
		m_menu.add(mi_find);
		m_menu.add(mi_list);
		m_menu.add(mi_modify);
		m_menu.addSeparator();
		m_menu.add(mi_close);
		
		p_main=new Panel(new BorderLayout());
		this.add(p_main,"Center");
		
		lb_main_title=new Label("전화번호부 프로그램 v1.0",Label.CENTER);
		p_main.add(lb_main_title, "Center");
		
        mi_add.addActionListener(this);
        mi_find.addActionListener(this);
        mi_list.addActionListener(this);
        mi_close.addActionListener(this);
        mi_modify.addActionListener(this);
        dbConnect();
	}
	/**DB 연결*/
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
	/**등록화면 구현 메서드*/
	public void makeAddView(){
		p_main=new Panel(new BorderLayout(5,5));
		//상단
		lb_add_title = new Label("전화번호 등록",Label.CENTER);
		p_main.add(lb_add_title, "North");
		//중단
		Panel p_temp1=new Panel(new GridLayout(4,2,5,5));
		lb_add_name=new Label("이름:");
		lb_add_age=new Label("나이:");
		lb_add_addr=new Label("주소:");
		lb_add_tel=new Label("전화번호:");
		
		tf_add_name=new TextField();
		tf_add_age=new TextField();
		tf_add_addr=new TextField();
		tf_add_tel=new TextField();
		
		p_temp1.add(lb_add_name); p_temp1.add(tf_add_name);
		p_temp1.add(lb_add_age); p_temp1.add(tf_add_age);
		p_temp1.add(lb_add_addr); p_temp1.add(tf_add_addr);
		p_temp1.add(lb_add_tel); p_temp1.add(tf_add_tel);
		
		p_main.add(p_temp1, "Center");
		//하단
		Panel p_temp2=new Panel(new BorderLayout());
		lb_add_msg=new Label("메세지:",Label.LEFT);
		bt_add_result=new Button("등록하기");
		p_temp2.add(lb_add_msg,"Center");
		p_temp2.add(bt_add_result,"East");
		p_main.add(p_temp2, "South");
		
		bt_add_result.addActionListener(this);
		
	}
	/**검색 화면관련 메서드*/
	public void makeFindView(){
		p_main=new Panel(new BorderLayout(5,5));
		//상단
		Panel p_temp1=new Panel(new BorderLayout());
		lb_find_title=new Label("전화번호 검색",Label.CENTER);
		p_temp1.add(lb_find_title,"North");
		lb_find_name=new Label("이름:");
		p_temp1.add(lb_find_name,"West");
		tf_find_name=new TextField();
		p_temp1.add(tf_find_name, "Center");
		bt_find_result=new Button("검색");
		p_temp1.add(bt_find_result,"East");
		p_main.add(p_temp1, "North");
		
		//중단
		ta_find_content=new TextArea();
		p_main.add(ta_find_content,"Center");
		bt_find_result.addActionListener(this);
	}
	/*목록 관련 메서드**/
	public void makeListView(){
		p_main=new Panel(new BorderLayout(5,5));
		//상단
		lb_list_title=new Label("전화번호부 목록",Label.CENTER);
		p_main.add(lb_list_title, "North");
		//중단
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
				ta_list_content.setText("등록된 전화번호가 없습니다.");
			}
		}catch(Exception e){
			
		}finally{
			try{
				ps.close();
				ps.close();
			}catch(Exception e2){}
		}
		
	}
	/**수정화면 구현 메서드*/
	public void modifyView(){
		p_main=new Panel(new BorderLayout());
		//상단
		Panel p_temp1=new Panel(new GridLayout(2,1));
		Panel p_temp1_1=new Panel(new BorderLayout());
		Panel p_temp1_2=new Panel();
	             	//제목
		la_modify_title=new Label("전화번호 수정",Label.CENTER);
		p_temp1_1.add(la_modify_title,"Center");
		            //검색 줄
		la_modify_sname=new Label("이름:");
		tf_modify_sname=new TextField(12);
		bt_modify_search=new Button("검색");
		
		p_temp1_2.add(la_modify_sname);
		p_temp1_2.add(tf_modify_sname);       //이름입력 텍스트
		p_temp1_2.add(bt_modify_search);      //버튼
		
		p_temp1.add(p_temp1_1);
		p_temp1.add(p_temp1_2);
		
		bt_modify_search.addActionListener(this);
		p_main.add(p_temp1, "North");
		//상단에서 해야할 기능    텍스트에 이름 적고 검색버튼 누르면 아래 중단에서 정보 표시
		
		//중단
		Panel p_temp2=new Panel(new BorderLayout());  
		Panel p_temp2_1=new Panel(new BorderLayout());
		Panel p_temp2_2=new Panel(new GridLayout(4,2));
		Panel p_temp2_3=new Panel(new BorderLayout()); 
		
		la_modify_sub_title=new Label("정보",Label.CENTER);   //정보 타이틀
		
		p_temp2_1.add(la_modify_sub_title,"South");
		p_temp2.add(p_temp2_1,"North");
		
		 la_modify_name=new Label("이름:");   tf_modify_name=new TextField();
		 la_modify_name=new Label("이름:");   tf_modify_name=new TextField();
		 la_modify_age=new Label("나이:");    tf_modify_age=new TextField();
		 la_modify_addr=new Label("주소:");   tf_modify_tel=new TextField();
	     la_modify_tel=new Label("전화번호:"); tf_modify_addr=new TextField();
	     tf_modify_name.setEditable(false);
	    p_temp2_2.add(la_modify_name); p_temp2_2.add(tf_modify_name);
	    p_temp2_2.add(la_modify_age);  p_temp2_2.add(tf_modify_age);
	    p_temp2_2.add(la_modify_addr); p_temp2_2.add(tf_modify_tel);
	    p_temp2_2.add(la_modify_tel);  p_temp2_2.add(tf_modify_addr);
	    p_temp2.add(p_temp2_2,"Center");
	  
		la_modify_msg=new Label("메세지:"); //메세지 라벨
		bt_modify_mo=new Button("수정");   //수정버튼
		bt_modify_mo.addActionListener(this);
		
		p_temp2_3.add(la_modify_msg,"Center");
		p_temp2_3.add(bt_modify_mo,"East");
		p_temp2.add(p_temp2_3,"South");

		
		
		
		p_main.add(p_temp2,"Center");
		
		
		
	}
	//프레임 여백
	@Override
    public Insets insets() {
    	Insets i=new Insets(50,10,10,10);
    	return i;
    }
    /**시작 메서드*/
	public static void main(String[] args) {
		
		PhonBook pb = new PhonBook();
		pb.setSize(300,300);
		pb.setVisible(true); 

	}
    //이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj =e.getSource();
		if(obj==mi_add){         //등록 화면
			this.remove(p_main);
			makeAddView();
			this.add(p_main);
			validate();
		}else if(obj==mi_find){  //검색 화면
			this.remove(p_main);
			makeFindView();
			this.add(p_main);
			validate();
		}else if(obj==mi_list){  //모두보기 화면
			this.remove(p_main);
			makeListView();
			this.add(p_main);
			validate();
			
		}else if(obj==mi_modify){  //검색 화면
			this.remove(p_main);
			modifyView();
			this.add(p_main);
			validate();
		}else if(obj==mi_close){ //종료
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
		}else if(obj==bt_add_result){  //등록 버튼
			infoAdd();
		}else if(obj==bt_find_result){ //검색 버튼
			infoFind();
		}else if(obj==bt_modify_search){ //수정하기 화면에서 검색버튼
			modifySearchButton();
		}else if(obj==bt_modify_mo){ //수정하기 하면에서 수정버튼
			modifyButton();
		}
		
		
	}
	/**DB등록 메서드*/
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
				lb_add_msg.setText("메세지:등록완료 하였습니다.");
			}else{
				lb_add_msg.setText("메세지:등록에 실패하였습니다.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close(); //try -> catch -> finally //fianlly는 예외가 발생하건 안하건 무조건 실행해야하는 부분
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**검색 관련 메서드*/
	public void infoFind(){
		try{
			String name=tf_find_name.getText();
			String sql="select * from student where name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,name);
			rs=ps.executeQuery();
			if(rs.next()){ //이미 조건에서 커서가 1에 위치하고있기때문에 while문은 실행이 안된다.
				String str="";
				do{
				    String dbname=rs.getString("name");  //인덱스 번호로는 1
				    int age=rs.getInt("age");            //인덱스 번호로는 2
				    String addr=rs.getString("addr");    //인덱스 번호로는 3
				    String tel=rs.getString("tel");      //인덱스 번호로는 4
				    
				    str+=dbname+"\t"+age+"\t"+addr+"\t"+tel+"\t";
				    ta_find_content.setText(str);
				}while(rs.next());
					
			}else{
				ta_find_content.setText("검색된 학생이 없습니다.");
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
    /**수정하기 화면에서 검색버튼*/
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
				ta_find_content.setText("검색된 학생이 없습니다.");
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
	/**수정하기 화면에서 수정버튼*/
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
				la_modify_msg.setText("메세지:수정완료 하였습니다.");
			}else{
				la_modify_msg.setText("메세지:수정을 실패하였습니다.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close(); //try -> catch -> finally //fianlly는 예외가 발생하건 안하건 무조건 실행해야하는 부분
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
























