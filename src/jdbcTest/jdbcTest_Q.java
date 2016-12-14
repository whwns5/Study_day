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
 * �л��� �̸��� �Է����ּ���
 * �̸� : ȫ�浿
 * 
 * ������� �л��� ������ ���
 * 
 * ���� ���
 * ��ϵ� �л��� �ƴմϴ�.
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
			System.out.println("�л��� �̸��� �Է����ּ���.");
			System.out.print("�̸� :");
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
					
					System.out.println("�̸� : " + name);
					System.out.println("���� : " + age);
					System.out.println("�ּ� : " + addr);
					System.out.println("��ȣ : " + tel);
				}while(rs.next());
			}else{
				System.out.println("��ϵ� �л��� �ƴմϴ�~");
			}
			
//			int count = 0;
//			while(rs.next()){
//				String name = rs.getString("name");
//				int age = rs.getInt("age");
//				String addr = rs.getString("addr");
//				String tel = rs.getString("tel");
//				
//				System.out.println("�̸� : " + name);
//				System.out.println("���� : " + age);
//				System.out.println("�ּ� : " + addr);
//				System.out.println("��ȣ : " + tel);
//				count++;
//			}
//			if(count == 0){
//				System.out.println("��ϵ� �л��� �ƴմϴ�~");
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
