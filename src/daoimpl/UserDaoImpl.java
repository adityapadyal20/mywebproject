package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import model.User;
import utils.JDBCUtils;

public class UserDaoImpl implements UserDao{

	public boolean createUser(User user) {
		final String sql = "insert into users(first_name,last_name,username,password,role)values(?,?,?,?,?)";
		Connection con = JDBCUtils.getConnection();
		int i = -1;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole());
			
			i = preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return (i==1 ? true:false);
	}

	public boolean deleteUser(User user) {
		final String sql = "delete from users where username=?";
		Connection con = JDBCUtils.getConnection();
		int i = -1;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			
			i = preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return (i==1 ? true:false);
		
	}	

	public boolean updateUser(User user) {
		final String sql = "update users set first_name=?,last_name=?,username=?,password=? where id = ?";	
		Connection con = JDBCUtils.getConnection();
		int i = -1;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setInt(5, user.getId());
			i = preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return (i==1 ? true:false);
	}

	public List<User> getAllUsers() {
		final String sql = "select * from users";
		List<User> usersList = new ArrayList<User>();
		Connection con = JDBCUtils.getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String firstname  = rs.getString(2);
				String lastname  = rs.getString(3);
				String  username = rs.getString(4);
				String password = rs.getString(5);
				User user = new User(id,firstname,lastname,username,password);
				usersList.add(user);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public List<User> selectUser(int id) {
		final String sql = "select * from users where id=?";	
		Connection con = JDBCUtils.getConnection();
		List<User> usersList = new ArrayList<User>();
		String userId = String.valueOf(id);
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String firstname  = rs.getString(2);
				String lastname  = rs.getString(3);
				String  username = rs.getString(4);
				String password = rs.getString(5);
				User user = new User(id,firstname,lastname,username,password);
				usersList.add(user);
			}
 		}catch(Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public List<User> getAllUsernames() {
		final String sql = "select username from users";	
		Connection con = JDBCUtils.getConnection();
		List<User> usersList = new ArrayList<User>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String  username = rs.getString(1);
				User user = new User(username);
				usersList.add(user);
			}
 		}catch(Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

}
