
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import loginpackage.business.abstracts.UserService;
import loginpackage.business.concretes.EmailManager;
import loginpackage.business.concretes.EmailVerifyManager;
import loginpackage.business.concretes.LoginManager;
import loginpackage.business.concretes.UserManager;
import loginpackage.core.concretes.AdapterManager;
import loginpackage.core.concretes.GoogleAccount;
import loginpackage.core.concretes.MicrosoftAccount;
import loginpackage.dataAccess.concretes.HibernateUserDao;
import loginpackage.entities.concretes.User;

public class Main {
	
	public static void main(String[] args) {
		
		
		
		
		
		
		
		
		List<String> list=new ArrayList<String>();
		
		list.add("ayigit@gmail.com");
		list.add("ayln@microsoft.com");
		
		User user=new User(1,"Aylin","Yiğit",list,"289111");
		
		
		//UserManager userManager=new UserManager(list,new HibernateUserDao(),new EmailManager(list,new EmailVerifyManager(list)));
		//userManager.add(user);   
		
		GoogleAccount googleManager=new  GoogleAccount(new AdapterManager(list,new HibernateUserDao(),new EmailManager(list,new EmailVerifyManager(list))));
		googleManager.memberSave(user);
		
		MicrosoftAccount microsoftManager=new MicrosoftAccount(new AdapterManager(list,new HibernateUserDao(),new EmailManager(list,new EmailVerifyManager(list))));
		microsoftManager.memberSave(user);
		
		LoginManager loginManager=new LoginManager(list);
		loginManager.Login(user);

		
		
	}


	

}
