package loginpackage.core.concretes;

import loginpackage.core.abstracts.AdapterService;
import loginpackage.entities.concretes.User;

public class MicrosoftAccount {
	AdapterService adapterService;
	

	public MicrosoftAccount(AdapterService adapterService) {
		super();
		this.adapterService = adapterService;
	}
	
	public void memberSave(User user) {
		adapterService.add(user);
		System.out.println("User added with Microsoft account ");
	
	}
	

}
