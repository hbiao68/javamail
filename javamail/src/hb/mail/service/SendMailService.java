package hb.mail.service;

import hb.mail.model.EMailAccount;
import hb.mail.util.Sender;

import java.io.File;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author liumei
 *
 */
public interface SendMailService {
	
	/**
	 * @param title 主题
	 * @param content 内容
	 */
	public void sendMessage(String title,String content);
	
	/**
	 * @param title 主题
	 * @param content 内容
	 * @param attachPath 附件
	 */
	public void sendMessage(String title,String content,String attachPath);
	
	/**
	 * @param title 主题
	 * @param content 内容
	 * @param files 附件
	 */
	public void sendMessage(String title,String content,File[] files);
	
	public void sendMessageBySender(Sender sender) throws Exception;
	
}
