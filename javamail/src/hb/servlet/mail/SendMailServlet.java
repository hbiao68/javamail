package hb.servlet.mail;

import hb.mail.model.EMailAccount;
import hb.mail.service.MailService;
import hb.mail.service.SendMailService;
import hb.mail.service.imp.MailServiceImp;
import hb.mail.service.imp.SendMailServiceImp;
import hb.mail.util.HtmlMessageSender;
import hb.util.cache.CachFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class SendMailServlet extends HttpServlet {
	
	Logger log = Logger.getLogger(SendMailServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mailcontent = request.getParameter("mailcontent");
		log.debug("mailcontent : " + mailcontent);
		String mailtitle = request.getParameter("mailtitle");
		log.debug("mailtitle : " + mailtitle); 
		
		//2、设置to，接收邮件的用户
		CachFactory cachFactory = CachFactory.getInstance();
		Map<String,Object> sendMailServiceCache = cachFactory.getMapByKey("sendMailServiceCache");
		EMailAccount account = null;
		SendMailServiceImp sendMailService = (SendMailServiceImp)sendMailServiceCache.get("huangbiao");
		if(sendMailService == null){
			sendMailService = new SendMailServiceImp();
			//1、设置from，是谁发送邮件
			account = new EMailAccount();
			account.setDomain("yeah.net");
			account.setUsername("hbiao68");
			account.setPassword("huangbiao");
			
			HtmlMessageSender sender = new HtmlMessageSender(account);
			//设置发送邮件server的基本信息
			sendMailService.setSender(sender);
		}else{
			account = sendMailService.getSender().getEMailAccount();
		}
		
		EMailAccount account1 = new EMailAccount();
		account1.setDomain("qq.com");
		account1.setUsername("939706250");
		sendMailService.getSender().setToEMailAccounts(new EMailAccount[]{account,account1});
		
		//3、发送邮件内容
		sendMailService.sendMessage(mailtitle, mailcontent);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
