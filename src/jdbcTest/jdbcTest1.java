package jdbcTest;

import java.sql.*;
/*
 * 2016_12_14
 * 
 * JDBC (Java Database Connectivity)��? 
 *  - �ڹ����α׷��� �����ͺ��̽��� �����ϴ� ���α׷��� ���.
 *  - Java ���� �پ��� ������ ������ �����ͺ��̽��� ������ �� ���Ǵ� ǥ��
 *    SQL �������̽� API�� java.sql ��Ű���� �ǹ��Ѵ�.
 * 
 * JDBC ����
 *  - �ڹ� ���� �ۼ��� api�̹Ƿ� �ü���� ������
 *  - DB ������ ������� ���α׷����� ����
 *    [JDBC Driver�� �ִٸ� � DBMS�͵� ���� ����]
 *  - Ư�� DB�� �����Ǵ� JDBC ���α׷��� �ٸ� DB �����ÿ��� ���α׷� ���� ����
 *    �ڵ带 �״�� Ȱ���� �� �ִ� (����)
 *    [JDBC Driver�� url �� �ٸ���, ���α׷��� ������ �ڵ�� ������ �ʿ䰡 ����.]
 * 
 * JDBC ����
 *  1�ܰ� - [java.sql ��Ű�� import]
 *  		 -> import java.sql.*;
 *  2�ܰ� - [JDBC����̹� �ε�]
 *  		 -> Class.forName("oracle.jdbc.driver.OracleDriver")
 *  3�ܰ� - [DB�����ϱ�]
 *  		 -> Connection conn = DriverManager.getConnection(url,user,pwd);
 *  4�ܰ� - [DB�������]
 *  		 -> con.close();
 *  
 * �� DB�� JDBC Ŭ������ URL
 *  - MSSQL
 *     -> CLASS : "com.microsoft.jdbc.sqlserver.SQLServerDriver"
 *     -> URL : jdbc:microsoft:sqlserver://localhost:1433
 *  - ����Ŭ
 *     -> CLASS : "oracle.jdbc.driver.OracleDriver"
 *     -> URL : jdbc:oracle:thin:@localhost:1521:�����ͺ��̽���
 *  - MYSQL
 *     -> CLASS : "com.mysql.jdbc.Driver"
 *     -> URL : jdbc:mysql://localhost:3306/�����ͺ��̽���
 *     
 * Statement ��ü (����)    
 *  statement �������̽��� ������ ��ü�� ���� SQL ���� �����ϱ� ���ؼ� ����ϸ�
 *  �׻� �μ��� ���� Connection Ŭ������ createStatement() �޼ҵ带 ȣ�������ν�
 *  �������.
 *  [����] Statement stmt = con.createStatement();
 * 
 * SQL �� (Query) �� ���۸޼ҵ�
 *  SELECT �� -> ResultSet rs = stmt.executeQuery("select��");
 *  INSERT �� ->
 *  UPDATE �� -> int dateCount = stmt.executeUpdate("update ��");
 *  DELETE �� -> 
 *  ��� SQL �� -> boolean isRs = stmt.execute("��� sql ��");
 *               1)�� ������ SQL�� SELECT ���̶�� true�� ��ȯ.
 *               2)update/delete/insert���̶�� false�� ��ȯ.
 *               1)�� ��� ... ResultSet rs = stmt.getResultSet();
 *               2)�� ��� ... int count = stmt.getUpdateCount();
 *               
 *      * ResultSet
 *         rs.first() -> ù��° �ο�
 *         rs.next() -> ���� �ο�
 *         rs.previous() -> ���� �ο�
 *         rs.last() -> ������ �ο�
 * 
 * PreparedStatement ��ü (����)
 *  SQL�� �̹� ���� Statement�� DB�� �Ѱ��� �������� �Ǿ�����, SQL���� 
 *  ? (in �Ķ����)�� ���߿� �߰��� ����Ǵ� �غ�� Statement ��ü
 *  
 *  ���� ) �ݺ����� sql���� �����Ҷ� ������ �� ������.
 *  ���� ) sql������ PrepareStatement ��ü�� �����ؾ� �Ѵ�. [���� �Ұ���]
 *      
 *  [����] String sql = "INSERT INTO member VALUES(?, ?, ?, ?)"
 *         PreparedStatement pstmt = con.prepareStatement(sql);
 *         pstmt.set[xxx] (�Ķ���� ����, ����������)    
 *      
 *      
 *      
 *      
 *      
 *      
 *  .
 *  
 *  
 *  
 */

public class jdbcTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("test");
			System.out.println("DB Driver Connect Start!");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DB Driver Loading Success!");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "1234";
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("DB Connection Success!");
			//////////////////////////////////////////////
//			Statement st = conn.createStatement();
//			String sql = "INSERT INTO student"
//					+ " VALUES('��ġ', 40, '�λ�', '051-2323-4545')";
//			int count = st.executeUpdate(sql);
//			System.out.println(count+" ���� ����� !");
//			st.close();
			
			String sql = "INSERT INTO student VALUES(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "7�׷�");
			ps.setInt(2, 22);
			ps.setString(3, "������ ���ﵿ");
			ps.setString(4, "02-1234-5678");
			
			int count = ps.executeUpdate();
			System.out.println(count+" ���� ����� !");
			
			ps.close();
			//////////////////////////////////////////////
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
