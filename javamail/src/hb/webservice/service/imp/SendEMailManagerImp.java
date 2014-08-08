package hb.webservice.service.imp;

import javax.jws.WebService;
import javax.mail.Message;

import org.apache.log4j.Logger;

import hb.mail.model.EMail;
import hb.webservice.service.SendEMailManager;

@WebService(endpointInterface="hb.webservice.service.SendEMailManager")
public class SendEMailManagerImp implements SendEMailManager {

	Logger log = Logger.getLogger(SendEMailManagerImp.class);
	
	@Override
	public boolean sendEmailByString(String subject, String content) {
		log.debug("subject : " + subject);
		log.debug("content : " + content);
		return false;
	}

	@Override
	public boolean sendEmailByEMail(EMail email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sendEmailByMessage(Message msg) {
		// TODO Auto-generated method stub
		return false;
	}

}
