package hb.mail.service;

import hb.mail.model.EMailAccount;

/**
 * 作为邮件服务的基础类，用于保存service基本信息
 * @author hbiao68
 *
 */
public interface MailService {

	/**
	 * 验证指定的账号是否存在
	 * @return
	 */
	public boolean hasAccount(EMailAccount EMailAccount);
	
	/**
	 * 得到账号的域名
	 * @return
	 */
	public String getDomain();
	
}
