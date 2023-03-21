package loginpackage.dataAccess.concretes;

import loginpackage.dataAccess.abstracts.UserDao;
import loginpackage.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	@Override
	public void add(User user) {
		System.out.println("User added:"+user.getFirstName());
	}
	

}
