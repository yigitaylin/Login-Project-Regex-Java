package loginpackage.core.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import loginpackage.business.abstracts.EmailService;
import loginpackage.core.abstracts.AdapterService;
import loginpackage.dataAccess.abstracts.UserDao;
import loginpackage.entities.concretes.User;

public class GoogleAccount {
	AdapterService adapterService;

	public GoogleAccount(AdapterService adapterService) {
		super();
		this.adapterService = adapterService;
	}
	
	public void memberSave(User user) {
		adapterService.add(user);
		System.out.println("User added with google account ");
	
	}
	

	




	

}
