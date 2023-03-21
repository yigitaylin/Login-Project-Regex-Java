package loginpackage.core.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import loginpackage.business.abstracts.EmailService;
import loginpackage.core.abstracts.AdapterService;
import loginpackage.dataAccess.abstracts.UserDao;
import loginpackage.entities.concretes.User;

public class AdapterManager implements AdapterService{
	

	UserDao userDao;
	EmailService emailService;
	List<String> list=new ArrayList<String>();
	
	public AdapterManager(List<String> list,UserDao userDao,EmailService emailService) {
		super();
		this.list=list;
		this.userDao = userDao;
		this.emailService=emailService;
	
	}

	@Override
	public void add(User user) {
		if(IsValidEmail(user) && IsOldEmail(list,user) && !user.getPassword().isEmpty() && emailService.sendEmail(user)=="valid") {
			userDao.add(user);	
		}
		else {
			System.out.println("User didn't add");
		}
		
		
	}
	
    
	@Override
	  public boolean IsValidEmail(User user) {
		 
		   String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		   Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
		   for(int i=0;i<list.size();i++) {
			   Matcher matcher = pattern.matcher(list.get(i));
			   System.out.println(list+" "+matcher.matches());
		  
           return matcher.matches();
		   }
		return false;

}


	@Override
	public boolean IsOldEmail(List<String> email,User user) {
		List<String> oldEmails=new ArrayList<String>();
		oldEmails.add("aylinnn@gmail.com");
		oldEmails.add("ayigittt@gmail.com");
  	if(oldEmails!=list) {
  		return true;
  	}
  	System.out.println("This email has been used.");
		return false;
  	
  }
  


}
