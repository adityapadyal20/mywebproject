package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String database = "userinfo?characterEncoding=utf8";
	private static final String username = "root";
	private static final String password = "aditya8308307728";
	
	public static Connection getConnection() {	
		
		Connection con = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url+database,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return con;
	}
}
