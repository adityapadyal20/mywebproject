package dao;

import java.util.List;

import model.User;

public interface UserDao {
	
	public boolean createUser(User user);
	
	public boolean deleteUser(User user);
	
	public boolean updateUser(User user);
	
	public List<User> selectUser(int id);
	
	public List<User> getAllUsers();

	public List<User> getAllUsernames();
	
}
