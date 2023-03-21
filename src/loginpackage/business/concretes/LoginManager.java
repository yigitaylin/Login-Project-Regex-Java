package loginpackage.business.concretes;

import java.util.ArrayList;
import java.util.List;

import loginpackage.business.abstracts.LoginService;
import loginpackage.entities.concretes.User;

public class LoginManager implements LoginService{


	List<String> mailList=new ArrayList<String>();
	
	
	public LoginManager(List<String> mailList) {
		super();
		this.mailList = mailList;
	}


	@Override
	public void Login(User user) {
		String loginEmail="ayigit@gmail.com";
		String loginPassword="289111";
	    if(loginEmail==mailList.get(0) && loginPassword==user.getPassword()) {
	    	System.out.println("Login successfull");
	    }
	    else {
	    	System.out.println("Login error");
	    }
		
	}
	  

}
