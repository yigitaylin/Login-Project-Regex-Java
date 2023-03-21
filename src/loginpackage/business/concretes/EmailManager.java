package loginpackage.business.concretes;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import loginpackage.business.abstracts.EmailService;
import loginpackage.business.abstracts.EmailVerifyService;
import loginpackage.entities.concretes.User;

public class EmailManager implements EmailService{
	
	EmailVerifyService emailVerifyService;
	List<String> mailList=new ArrayList<String>();
	
	
	public EmailManager(List<String> mailList,EmailVerifyService emailVerifyService) {
		super();
		this.emailVerifyService = emailVerifyService;
		this.mailList=mailList;
	}


	@Override
	public String sendEmail(User user) {
		final String senderEmail="ayiit@gmail.com";
		final String password="76543";
		String subject="Member Confirmation Link";
		String text="Confirmation Code:67895";
		
		
		Properties props=new Properties();	
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port","587");  
		
		
	
		Session session=Session.getInstance(props, new javax.mail.Authenticator()
				{
			        protected PasswordAuthentication getPasswordAuthentication()
			        {
						return new PasswordAuthentication(senderEmail,password);
			        	
			        }
				});
		try {
			
			InternetAddress mailTo=new InternetAddress();
			for(int i=0;i<mailList.size();i++) {
				mailTo=(InternetAddress)new InternetAddress(mailList.get(i));
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipient(Message.RecipientType.TO,(Address) mailTo);
			message.setSubject(subject);
			message.setText(text);
			
			Transport.send(message);
			
			}
			emailVerifyService.controlVerify(user);
		}catch(MessagingException e) {
			throw new RuntimeException(e);
		}
		return "valid";
		
	}

}
