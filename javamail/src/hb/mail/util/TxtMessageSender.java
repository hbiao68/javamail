package hb.mail.util;

import hb.mail.model.EMailAccount;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

public class TxtMessageSender extends Sender {

	public TxtMessageSender(EMailAccount eMailAccount) {
		super(eMailAccount);
		
	}

	public TxtMessageSender(String username,String domain,String password){
		super(username, domain, password);
	}
	

}
