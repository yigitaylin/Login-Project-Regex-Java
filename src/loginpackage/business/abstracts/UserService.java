package loginpackage.business.abstracts;

import java.util.List;

import loginpackage.entities.concretes.User;

public interface UserService{
	void add(User user);
	boolean IsValidName(User user);
	boolean IsValidPassword(User user);
	boolean IsValidEmail(User user);
	boolean IsOldEmail(List<String> email,User user);
	boolean IsValidUser(User user);


	
}

