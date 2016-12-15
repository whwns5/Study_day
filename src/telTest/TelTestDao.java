package telTest;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.plaf.SliderUI;

public class TelTestDao extends Dao{

	public TelTestDao() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	/** 전화번호 등록 */
	@Override 
	public void insert(Connection con, Object obj) throws Exception {
		// TODO Auto-generated method stub
		TelVo input_tel_data = (TelVo) obj;
		
		try{
			pstmt = null;
			pstmt = con.prepareStatement(Sql.TEL_INSERT);
			pstmt.setString(1, input_tel_data.getName());
			pstmt.setInt(2, input_tel_data.getAge());
			pstmt.setString(3, input_tel_data.getAddr());
			pstmt.setString(4, input_tel_data.getTel());
			pstmt.executeUpdate();
		}catch(Exception e){
			throw e;
		}finally {
			super.close(pstmt);
		}
		
	}

	@Override
	public void delete(Connection con, Object obj) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Connection con, Object obj) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Object> select(Connection con, Object obj) throws Exception {
		// TODO Auto-generated method stub
		TelVo input_tel_data = (TelVo) obj;
		ArrayList<Object> result_tel_list = new ArrayList<Object>();

		try {
			pstmt = null;
			rset = null;
			pstmt = con.prepareStatement(Sql.TEL_SELECT);
			pstmt.setString(1, input_tel_data.getName());

			rset = pstmt.executeQuery();

			while (rset.next()) {
				String name = rset.getString("name");
				int age = rset.getInt("age");
				String addr = rset.getString("addr");
				String tel = rset.getString("tel");

				TelVo result_tel_data = new TelVo(name, age, addr, tel);

				result_tel_list.add(result_tel_data);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			super.close(rset);
			super.close(pstmt);
		}

		return result_tel_list;

	}

	@Override
	public ArrayList<Object> selectAll(Connection con) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Object> result_tel_list = new ArrayList<Object>();

		try {
			pstmt = null;
			rset = null;
			pstmt = con.prepareStatement(Sql.TEL_ALLSELECT);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				String name = rset.getString("name");
				int age = rset.getInt("age");
				String addr = rset.getString("addr");
				String tel = rset.getString("tel");

				TelVo result_tel_data = new TelVo(name, age, addr, tel);

				result_tel_list.add(result_tel_data);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			super.close(rset);
			super.close(pstmt);
		}

		return result_tel_list;
	}

}
