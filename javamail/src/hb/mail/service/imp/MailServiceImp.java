package hb.mail.service.imp;

import hb.mail.model.EMailAccount;
import hb.mail.service.MailService;

public class MailServiceImp implements MailService {

	//注册用户的域
	String defaultDomain = "yeah.net";

	@Override
	public boolean hasAccount(EMailAccount EMailAccount) {
		return false;
	}

	@Override
	public String getDomain() {
		return null;
	}

}
