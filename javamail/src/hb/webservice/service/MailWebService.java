package hb.webservice.service;

import hb.webservice.service.imp.SendEMailManagerImp;
import hb.webservice.util.Releaser;

public class MailWebService {

	public void release(){
		Releaser releaser = Releaser.getInstance();
		String address = "http://localhost:7777/sendmail";
		SendEMailManagerImp sendEMailManagerImp = new SendEMailManagerImp();
		releaser.release(address, sendEMailManagerImp);
	}
	
}
