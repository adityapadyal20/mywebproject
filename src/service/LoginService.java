package service;

import model.Login;

public interface LoginService {
	
	public boolean validateUser(Login login);
	
	public String getUserRole(String Username);
	}

