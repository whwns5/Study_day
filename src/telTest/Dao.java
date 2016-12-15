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
	/** PreparedStatement 닫기 메서드 */
	public void close(PreparedStatement pstmt){
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/** ResultSet 닫기 메서드 */
	public void close(ResultSet rset){
		try {
			rset.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/** 등록 메서드 */
	public abstract void insert(Connection con, Object obj) throws Exception;
	/** 수정 메서드 */
	public abstract void update(Connection con, Object obj) throws Exception;
	/** 삭제 메서드 */
	public abstract void delete(Connection con, Object obj) throws Exception;
	/** 조건 검색 메서드 */
	public abstract ArrayList<Object> select(Connection con, Object obj) throws Exception;
	/** 전체 조회 메서드 */
	public abstract ArrayList<Object> selectAll(Connection con) throws Exception;
	
}
