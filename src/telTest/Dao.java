package telTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao {
	public PreparedStatement pstmt;
	public ResultSet rset;
	
	public Dao(){
		
	}
	/** PreparedStatement �ݱ� �޼��� */
	public void close(PreparedStatement pstmt){
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/** ResultSet �ݱ� �޼��� */
	public void close(ResultSet rset){
		try {
			rset.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/** ��� �޼��� */
	public abstract void insert(Connection con, Object obj) throws Exception;
	/** ���� �޼��� */
	public abstract void update(Connection con, Object obj) throws Exception;
	/** ���� �޼��� */
	public abstract void delete(Connection con, Object obj) throws Exception;
	/** ���� �˻� �޼��� */
	public abstract ArrayList<Object> select(Connection con, Object obj) throws Exception;
	/** ��ü ��ȸ �޼��� */
	public abstract ArrayList<Object> selectAll(Connection con) throws Exception;
	
}
