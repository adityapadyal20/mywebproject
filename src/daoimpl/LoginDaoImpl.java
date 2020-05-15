package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.LoginDao;
import model.Login;
import utils.JDBCUtils;

public class LoginDaoImpl implements LoginDao{

	public boolean validateUser(Login login) {
		final String sql = "select username,password from users where username = ? and password = ?	";
		Connection con = JDBCUtils.getConnection();
		String dbusername = null;
		String dbpassword = null;
		if(login.getUsername()!=null && login.getPassword()!=null) {
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, login.getUsername());
			preparedStatement.setString(2, login.getPassword()); 
			
			ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			dbusername = resultSet.getString(1);
			dbpassword = resultSet.getString(2);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		if(dbusername!=null && dbpassword!=null) {
		return (dbusername.equals(login.getUsername()) && dbpassword.equals(login.getPassword()) ?true : false);
		}
		else {
			return false;
		}
	}

	public String getUserRole(String username) {
		final String sql = "select role from users where username = ?";
		Connection con = JDBCUtils.getConnection();
		String userRole = null;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				userRole = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userRole;
	}
	
}
