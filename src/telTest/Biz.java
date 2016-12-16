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
			Class.forName(driver); // ����Ŭ ����̹��� �ε��Ѵ�.
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Error");
			e.printStackTrace();
		}
	}

	/** Connection ���� �޼ҵ� */
	protected Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, passwd);
			con.setAutoCommit(false); // ���� Ŀ���� false�� �����Ѵ�.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection Error");
			e.printStackTrace();
		}
		return con;
	}
	
	/** Connection �ݱ� �޼ҵ� */
	public void close(Connection con){		//Connection ��ü close
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** ��� �޼��� */
	public abstract boolean register(Object obj);
	/** ���� �޼��� */
	public abstract boolean modify(Object obj);
	/** ���� �޼��� */
	public abstract void remove(Object obj); 
	/** ���� �˻� �޼��� */
	public abstract ArrayList<Object> get(Object obj);
	/** ��ü ��ȸ �޼��� */
	public abstract ArrayList<Object> getAll();
}

