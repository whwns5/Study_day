package telTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class TelTestBiz extends Biz{

	Dao telTest_Dao;
	
	public TelTestBiz(){
		super();
		telTest_Dao = new TelTestDao();
	}
	
	/** 전화번호 등록 */
	@Override
	public boolean register(Object obj) {
		// TODO Auto-generated method stub
		
		Connection con = super.getConnection();
		try {
			telTest_Dao.insert(con, obj);
			con.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Tel Insert Error");
			System.out.println("RollBack");
			try {
				con.rollback();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		} finally {
			super.close(con);
		}
		
		return true;
	}

	@Override
	public void modify(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Object> get(Object obj) {
		// TODO Auto-generated method stub
		ArrayList<Object> result_tel_list = new ArrayList<Object>();
		Connection con = super.getConnection();

		try {
			result_tel_list = telTest_Dao.select(con, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Tel Select Error");
			e.printStackTrace();
		} finally {
			super.close(con);
		}

		return result_tel_list;
	}

	@Override
	public ArrayList<Object> getAll() {
		// TODO Auto-generated method stub
		ArrayList<Object> result_tel_list = new ArrayList<Object>();
		Connection con = super.getConnection();
		
		try {
			result_tel_list = telTest_Dao.selectAll(con);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Tel SelectAll Error");
			e.printStackTrace();
		} finally {
			super.close(con);
		}
		
		return result_tel_list;
	}

}
