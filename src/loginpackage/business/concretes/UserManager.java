package loginpackage.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import loginpackage.business.abstracts.EmailService;
import loginpackage.business.abstracts.UserService;
import loginpackage.core.abstracts.AdapterService;
import loginpackage.dataAccess.abstracts.UserDao;
import loginpackage.entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private EmailService emailService;

	
	 List<String> list=new ArrayList<String>();
	

	public UserManager(List<String> list,UserDao userDao ,EmailService emailService) {
		super();
		this.list=list;
		this.userDao = userDao;
		this.emailService=emailService;
	}
	

    @Override
	public void add(User user) {
		if(IsValidUser(user) && emailService.sendEmail(user)=="valid") {
			System.out.println("All information correct and email approved.");
		userDao.add(user);	
		}
		else {
			System.out.println("User didn't add");
		}
		
	}
	
	@Override
	public boolean IsValidName(User user) {
		if(!user.getFirstName().isEmpty() && !user.getLastName().isEmpty() && user.getFirstName().length()>=2 && user.getLastName().length()>=2) {
			return true;
		}
		System.out.println("Firstname-Surname can't empty and will be the least two characters ");
		return false;
	}
	
	@Override
	public boolean IsValidPassword(User user) {
		if(!user.getPassword().isEmpty() && user.getPassword().length()>=6) {
			return true;
		}
		System.out.println("Password can't empty and will be the least six characters");
		return false;
		
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
		oldEmails.add("aylin@gmail.com");
		oldEmails.add("ayigit@gmail.com");
    	if(oldEmails!=list) {
    		return true;
    	}
    	System.out.println("This email has been used");
		return false;
    	
    }
    

    @Override
    public boolean IsValidUser(User user) {
    	if( IsValidName(user) && IsValidPassword(user) && IsValidEmail(user) && IsOldEmail(list,user)){
    		return true;
    }
		return false;
	
  }



}