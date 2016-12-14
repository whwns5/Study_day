package jdbcTest;

import java.sql.*;
import java.util.Scanner;

/*
 * 2016_12_14
 * 
 * 사용자로 부터 insert / delete / update 문을 입력받아 실행하는 프로그램을 작성.
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
			System.out.print("SQL을 입력하세요.[단, insert/update/delete");
			System.out.print("입력 > ");
			String inputSql = sc.nextLine();
			
			String sql = "INSERT INTO student VALUES('빠빠', 40, '미국', '010-4140-6421') ";
			
			String sql2 = "UPDATE student SET name = '뽀뽀' WHERE name = '삐삐' ";
			
			String sql3 = "DELETE FROM student WHERE name = '뽀뽀' ";
			
			
			String sql4 = "INSERT INTO student VALUES('빠빠', 40, '미국', '010-4140-6421')"
					+ "  INSERT INTO student VALUES('빠빠2', 40, '미국', '010-4140-6421')";
			
			//int count = st.executeUpdate(sql + sql2);
			//int count = st.executeUpdate(sql4);
			
			int count = st.executeUpdate(inputSql);
			
			System.out.println(count + " 행이 수행됨.");
			
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
