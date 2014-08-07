package hb.webservice.service;

import javax.jws.WebService;
import javax.mail.Message;

import hb.mail.model.EMail;

@WebService
public interface SendEMailManager {

	public boolean sendEmailByString(String subject,String content);
	
	public boolean sendEmailByEMail(EMail email);
	
	public boolean sendEmailByMessage(Message msg);
}
