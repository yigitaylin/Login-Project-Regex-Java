package loginpackage.business.abstracts;

import loginpackage.entities.concretes.User;

public interface EmailVerifyService {
	boolean sendVerify(User user);
	boolean controlVerify(User user);

}
