package jdbcTest;

import java.sql.*;
/*
 * 2016_12_14
 * 
 * JDBC (Java Database Connectivity)란? 
 *  - 자바프로그램과 데이터베이스를 연결하는 프로그래밍 방식.
 *  - Java 언어로 다양한 종류의 관계형 데이터베이스를 접근할 때 사용되는 표준
 *    SQL 인터페이스 API로 java.sql 패키지를 의미한다.
 * 
 * JDBC 장점
 *  - 자바 언어로 작성된 api이므로 운영체제에 독립적
 *  - DB 종류와 관계없이 프로그래밍이 가능
 *    [JDBC Driver만 있다면 어떤 DBMS와도 연동 가능]
 *  - 특정 DB에 연동되는 JDBC 프로그램은 다른 DB 연동시에도 프로그램 수정 없이
 *    코드를 그대로 활용할 수 있다 (장점)
 *    [JDBC Driver와 url 만 다를뿐, 프로그램의 나머지 코드는 수정할 필요가 없다.]
 * 
 * JDBC 절차
 *  1단계 - [java.sql 패키지 import]
 *  		 -> import java.sql.*;
 *  2단계 - [JDBC드라이버 로드]
 *  		 -> Class.forName("oracle.jdbc.driver.OracleDriver")
 *  3단계 - [DB연결하기]
 *  		 -> Connection conn = DriverManager.getConnection(url,user,pwd);
 *  4단계 - [DB연결끊기]
 *  		 -> con.close();
 *  
 * 각 DB별 JDBC 클래스와 URL
 *  - MSSQL
 *     -> CLASS : "com.microsoft.jdbc.sqlserver.SQLServerDriver"
 *     -> URL : jdbc:microsoft:sqlserver://localhost:1433
 *  - 오라클
 *     -> CLASS : "oracle.jdbc.driver.OracleDriver"
 *     -> URL : jdbc:oracle:thin:@localhost:1521:데이터베이스명
 *  - MYSQL
 *     -> CLASS : "com.mysql.jdbc.Driver"
 *     -> URL : jdbc:mysql://localhost:3306/데이터베이스명
 *     
 * Statement 객체 (정적)    
 *  statement 인터페이스를 구현한 객체로 실제 SQL 문을 수행하기 위해서 사용하며
 *  항상 인수가 없는 Connection 클래스의 createStatement() 메소드를 호출함으로써
 *  얻어진다.
 *  [형식] Statement stmt = con.createStatement();
 * 
 * SQL 문 (Query) 을 전송메소드
 *  SELECT 문 -> ResultSet rs = stmt.executeQuery("select문");
 *  INSERT 문 ->
 *  UPDATE 문 -> int dateCount = stmt.executeUpdate("update 문");
 *  DELETE 문 -> 
 *  모든 SQL 문 -> boolean isRs = stmt.execute("모든 sql 문");
 *               1)위 구문의 SQL이 SELECT 문이라면 true값 반환.
 *               2)update/delete/insert문이라면 false값 반환.
 *               1)의 경우 ... ResultSet rs = stmt.getResultSet();
 *               2)의 경우 ... int count = stmt.getUpdateCount();
 *               
 *      * ResultSet
 *         rs.first() -> 첫번째 로우
 *         rs.next() -> 다음 로우
 *         rs.previous() -> 이전 로우
 *         rs.last() -> 마지막 로우
 * 
 * PreparedStatement 객체 (동적)
 *  SQL문 이미 가진 Statement가 DB에 넘겨져 컴파일이 되어지고, SQL문의 
 *  ? (in 파라미터)만 나중에 추가해 실행되는 준비된 Statement 객체
 *  
 *  장점 ) 반복적인 sql문을 실행할때 실행이 더 빠르다.
 *  단점 ) sql문마다 PrepareStatement 객체를 생성해야 한다. [재사용 불가능]
 *      
 *  [형식] String sql = "INSERT INTO member VALUES(?, ?, ?, ?)"
 *         PreparedStatement pstmt = con.prepareStatement(sql);
 *         pstmt.set[xxx] (파라미터 순서, 실제데이터)    
 *      
 *      
 *      
 *      
 *      
 *      
 *  .
 *  
 *  
 *  
 */

public class jdbcTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("test");
			System.out.println("DB Driver Connect Start!");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DB Driver Loading Success!");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "1234";
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("DB Connection Success!");
			//////////////////////////////////////////////
//			Statement st = conn.createStatement();
//			String sql = "INSERT INTO student"
//					+ " VALUES('또치', 40, '부산', '051-2323-4545')";
//			int count = st.executeUpdate(sql);
//			System.out.println(count+" 행이 수행됨 !");
//			st.close();
			
			String sql = "INSERT INTO student VALUES(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "7그램");
			ps.setInt(2, 22);
			ps.setString(3, "강남구 역삼동");
			ps.setString(4, "02-1234-5678");
			
			int count = ps.executeUpdate();
			System.out.println(count+" 행이 수행됨 !");
			
			ps.close();
			//////////////////////////////////////////////
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
