package loginpackage.business.concretes;

import java.util.ArrayList;
import java.util.List;

import loginpackage.business.abstracts.EmailVerifyService;
import loginpackage.entities.concretes.User;

public class EmailVerifyManager implements EmailVerifyService {
	
	List<String> mailList=new ArrayList<String>();
	
	

	public EmailVerifyManager(List<String> mailList) {
		super();
		this.mailList = mailList;
	}

	@Override
	public boolean sendVerify(User user) {
	    String mailTo=new String();
		for(int i=0;i<mailList.size();i++) {
			mailTo=mailList.get(i);
		System.out.println("Verification email has been sent."+mailTo);
		}
		return true;
	}

	@Override
	public boolean controlVerify(User user) {
	if(sendVerify(user)) {
		System.out.println("User confirmed.");
		return true;
	}
	else {
		System.out.println("Not verified");
			return false;
	}

	
}
	
}


