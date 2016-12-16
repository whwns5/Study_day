package telTest;

public class Sql {
	public static String TEL_INSERT = "INSERT INTO student VALUES(?,?,?,?)";
	public static String TEL_ALLSELECT = "SELECT name, age, addr, tel FROM student";
	public static String TEL_SELECT = "SELECT name, age, addr, tel FROM student WHERE name = ?";
	/** UPDATE student SET age = ?, addr = ?, tel = ? WHERE name = ? */
	public static String TEL_UPDATE = "UPDATE student"
			+ " SET age = ?, addr = ?, tel = ?"
			+ " WHERE name = ? ";
}
