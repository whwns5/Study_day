package jdbcTest;

import java.sql.*;
import java.util.Scanner;

/*
 * 2016_12_14
 * 
 * ����ڷ� ���� insert / delete / update ���� �Է¹޾� �����ϴ� ���α׷��� �ۼ�.
 */
public class jdbcTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Driver Start");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "1234";
			
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement st = conn.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("SQL�� �Է��ϼ���.[��, insert/update/delete");
			System.out.print("�Է� > ");
			String inputSql = sc.nextLine();
			
			String sql = "INSERT INTO student VALUES('����', 40, '�̱�', '010-4140-6421') ";
			
			String sql2 = "UPDATE student SET name = '�ǻ�' WHERE name = '�߻�' ";
			
			String sql3 = "DELETE FROM student WHERE name = '�ǻ�' ";
			
			
			String sql4 = "INSERT INTO student VALUES('����', 40, '�̱�', '010-4140-6421')"
					+ "  INSERT INTO student VALUES('����2', 40, '�̱�', '010-4140-6421')";
			
			//int count = st.executeUpdate(sql + sql2);
			//int count = st.executeUpdate(sql4);
			
			int count = st.executeUpdate(inputSql);
			
			System.out.println(count + " ���� �����.");
			
			st.close();
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
