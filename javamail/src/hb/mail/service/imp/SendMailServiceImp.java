package hb.mail.service.imp;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import hb.mail.model.EMailAccount;
import hb.mail.service.MailService;
import hb.mail.service.SendMailService;
import hb.mail.util.Sender;

public class SendMailServiceImp extends MailServiceImp implements
		SendMailService {

	Logger log = Logger.getLogger(SendMailServiceImp.class);
	private Session session;
	private Message msg = null;
	
	Sender sender;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

	public Sender getSender() {
		return sender;
	}

	public void setSender(Sender sender) {
		this.sender = sender;
	}

	public SendMailServiceImp() {
		super();
	}

	@Override
	public void sendMessage(String title, String content) {
		// 1、创建session
		//判断session是否已经成功创建
		if(session == null){
			session = sender.createSession();
		}
		// 2、创建Message对象
		try {
			msg = sender.createMessage(session);
			msg.setSubject(title);
			msg.setText(content);
			// 3、发送邮件
			this.sendMessageBySender(sender);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void sendMessage(String title, String content, String attachPath) {

	}

	@Override
	public void sendMessage(String title, String content, File[] files) {

	}

	@Override
	public void sendMessageBySender(Sender sender) throws Exception {
		//发送消息
		sender.sendMessage(msg, session);
	}

	

}
