package serviceimpl;

import dao.LoginDao;
import daoimpl.LoginDaoImpl;
import model.Login;
import service.LoginService;

public class LoginServiceImpl implements LoginService {
	LoginDao loginDao = new LoginDaoImpl();
	public boolean validateUser(Login login) {
		return loginDao.validateUser(login);
	}
	
	public String getUserRole(String Username) {
		return loginDao.getUserRole(Username);
	}
}

