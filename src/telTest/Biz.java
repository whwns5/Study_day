package telTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Biz {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String user = "scott";
	private static final String passwd = "1234";

	public Biz() {
		// Oracle Driver Loading
		try {
			Class.forName(driver); // 오라클 드라이버를 로딩한다.
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Error");
			e.printStackTrace();
		}
	}

	/** Connection 연결 메소드 */
	protected Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, passwd);
			con.setAutoCommit(false); // 오토 커밋을 false로 설정한다.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection Error");
			e.printStackTrace();
		}
		return con;
	}
	
	/** Connection 닫기 메소드 */
	public void close(Connection con){		//Connection 객체 close
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** 등록 메서드 */
	public abstract boolean register(Object obj);
	/** 수정 메서드 */
	public abstract boolean modify(Object obj);
	/** 삭제 메서드 */
	public abstract void remove(Object obj); 
	/** 조건 검색 메서드 */
	public abstract ArrayList<Object> get(Object obj);
	/** 전체 조회 메서드 */
	public abstract ArrayList<Object> getAll();
}

