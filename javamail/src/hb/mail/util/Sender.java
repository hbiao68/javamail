package hb.mail.util;

import hb.mail.model.EMailAccount;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class Sender {

	Logger log = Logger.getLogger(Sender.class);
	
	// 邮件接收人
	EMailAccount[] toEMailAccounts;
	
	// 邮件暗送接收人
	EMailAccount[] toCCEMailAccounts;

	//用户登录的账号
	EMailAccount eMailAccount = null;
	
	Session session = null;
	//session是否是以debug运行
	boolean isDebug = true;
	
	public Sender(EMailAccount eMailAccount){
		this.eMailAccount = eMailAccount;
	}
	public Sender(String username,String domain,String password){
		EMailAccount eMailAccount = new EMailAccount(username, domain, password);
	}

	public EMailAccount[] getToEMailAccounts() {
		return toEMailAccounts;
	}
	public void setToEMailAccounts(EMailAccount[] toEMailAccounts) {
		this.toEMailAccounts = toEMailAccounts;
	}
	public EMailAccount[] getToCCEMailAccounts() {
		return toCCEMailAccounts;
	}
	public void setToCCEMailAccounts(EMailAccount[] toCCEMailAccounts) {
		this.toCCEMailAccounts = toCCEMailAccounts;
	}
	public EMailAccount getEMailAccount() {
		return eMailAccount;
	}
	public void setEMailAccount(EMailAccount eMailAccount) {
		this.eMailAccount = eMailAccount;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public boolean isDebug() {
		return isDebug;
	}
	public void setDebug(boolean isDebug) {
		this.isDebug = isDebug;
	}
	/**
	 * 发送消息
	 * 
	 * @param msg
	 * @param session
	 */
	public void sendMessage(Message msg, Session session) {
		// 获得Transport对象，并连接邮件服务器发送邮件
		Transport transport;
		try {
			transport = session.getTransport();
			EMailAccount account = this.getEMailAccount();
			transport.connect("smtp.yeah.net", account.toString(),account.getPassword());
			// 设置收件人的信息
			Address[] tos = null;
			if (toEMailAccounts != null && toEMailAccounts.length > 0) {
				// 为每个邮件接收者创建一个地址
				tos = new InternetAddress[toEMailAccounts.length];
				for (int i = 0; i < toEMailAccounts.length; i++) {
					tos[i] = new InternetAddress(toEMailAccounts[i].toString());
				}
			}
			
			// transport.sendMessage(msg,msg.getRecipients(Message.RecipientType.TO));
			transport.sendMessage(msg, tos);
			transport.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 创建session对象
	 * 
	 * @return
	 */
	public Session createSession() {
		if(session == null){
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.smtp.auth", "true");
			session = Session.getInstance(props);
			session.setDebug(isDebug);
		}
		return session;
	}

	/**
	 * 创建message对象,不包含任何发送消息的信息
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public Message createMessage(Session session) throws Exception {
		MimeMessage message = new MimeMessage(session);
		// 发件人的邮件
		String from = this.getEMailAccount().toString();
		log.debug("the email from : " + from);
		message.setFrom(new InternetAddress(from));
		return message;
	}
}
