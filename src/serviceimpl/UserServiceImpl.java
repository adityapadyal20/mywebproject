package serviceimpl;

import java.util.List;

import dao.UserDao;
import daoimpl.UserDaoImpl;
import model.User;
import service.UserService;	

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		return userDao.createUser(user);
	}

	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(user);
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

	public List<User> selectUser(int id) {
		// TODO Auto-generated method stub
		return userDao.selectUser(id);
	}

	public List<User> getAllUsernames() {
		// TODO Auto-generated method stub
		return userDao.getAllUsernames();
	}

}