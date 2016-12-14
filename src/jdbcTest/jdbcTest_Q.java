package jdbcTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 학생의 이름을 입력해주세요
 * 이름 : 홍길동
 * 
 * 있을경우 학생의 정보를 출력
 * 
 * 없을 경우
 * 등록된 학생이 아닙니다.
 */
public class jdbcTest_Q {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "1234";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			///////////////////////////////////////////////////////////
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("학생의 이름을 입력해주세요.");
			System.out.print("이름 :");
			String inputStr = br.readLine();
			
			String sql = "SELECT * FROM student WHERE name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, inputStr);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				do{
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String addr = rs.getString("addr");
					String tel = rs.getString("tel");
					
					System.out.println("이름 : " + name);
					System.out.println("나이 : " + age);
					System.out.println("주소 : " + addr);
					System.out.println("번호 : " + tel);
				}while(rs.next());
			}else{
				System.out.println("등록된 학생이 아닙니다~");
			}
			
//			int count = 0;
//			while(rs.next()){
//				String name = rs.getString("name");
//				int age = rs.getInt("age");
//				String addr = rs.getString("addr");
//				String tel = rs.getString("tel");
//				
//				System.out.println("이름 : " + name);
//				System.out.println("나이 : " + age);
//				System.out.println("주소 : " + addr);
//				System.out.println("번호 : " + tel);
//				count++;
//			}
//			if(count == 0){
//				System.out.println("등록된 학생이 아닙니다~");
//			}
			
			ps.close();
			br.close();
			///////////////////////////////////////////////////////////
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
