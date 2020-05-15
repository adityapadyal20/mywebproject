package dao;

import model.Login;

public interface LoginDao {
	public boolean validateUser(Login login);

	public String getUserRole(String username);
	
}
