package hb.mail.util;

import hb.mail.model.EMailAccount;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class HtmlMessageSender extends Sender {

	public HtmlMessageSender(EMailAccount eMailAccount) {
		super(eMailAccount);
		
	}

	public HtmlMessageSender(String username,String domain,String password){
		super(username, domain, password);
	}
	
	public MimeMultipart createRelatedMimeMultipart(File file,String url) throws MessagingException{
		//创建一个字类型为“related”的MimeMultipart对象
		MimeMultipart multipart=new MimeMultipart("related");
		//创建一个表示HTML正文的MimeBodyPart对象，并将它加入到前面创建的MimeMultipart对象中
		MimeBodyPart htmlBodyPart=new MimeBodyPart();
		//String url="<a href=http://www.163.com>Welcome!!!<a><br><img src=\"cid:157222.jpg\">";
		htmlBodyPart.setContent(url,"text/html;charset=gb2312");
		multipart.addBodyPart(htmlBodyPart);
		//创建一个表示图片内容的MimeBodyPart对象，便国家他加入到前面创建的MimeMultipart对象中。
		MimeBodyPart gifBodyPart=new MimeBodyPart();
		//file://C:\\157222.jpg
		FileDataSource fds=new FileDataSource(file);
		gifBodyPart.setDataHandler(new DataHandler(fds));
		gifBodyPart.setContentID("157222.jpg");
		//gifBodyPart.setHeader("Content-Type", "image/jpg");
		multipart.addBodyPart(gifBodyPart);
		return multipart;
	}
	
	public MimeMultipart createRelatedMimeMultipart(String url) throws MessagingException{
		//创建一个字类型为“related”的MimeMultipart对象
		MimeMultipart multipart=new MimeMultipart("related");
		//创建一个表示HTML正文的MimeBodyPart对象，并将它加入到前面创建的MimeMultipart对象中
		MimeBodyPart htmlBodyPart=new MimeBodyPart();
		//String url="<a href=http://www.163.com>Welcome!!!<a><br><img src=\"cid:157222.jpg\">";
		htmlBodyPart.setContent(url,"text/html;charset=gb2312");
		multipart.addBodyPart(htmlBodyPart);
		return multipart;
	}
	
}
