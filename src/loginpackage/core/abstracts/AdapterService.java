package loginpackage.core.abstracts;

import java.util.List;

import loginpackage.entities.concretes.User;

public interface AdapterService {
	void add(User user);
	boolean IsValidEmail(User user);
	boolean IsOldEmail(List<String> email,User user);
	
	

}
