package loginpackage.business.abstracts;

import loginpackage.entities.concretes.User;

public interface EmailService {
	String sendEmail(User user);

}
