package hb.mail.model;

import java.io.File;
import java.util.Date;

public class EMail {
	/**
	 * 主题
	 */
	private String subject;
	/**
	 * 内容
	 */
	private String context;
	/**
	 * 发送时间
	 */
	private Date sendTime;
	/**
	 * 接收时间
	 */
	private Date receiveTime;
	/**
	 * 附件
	 */
	private File[] attachs;
	/**
	 * 邮件发送者
	 */
	private EMailAccount from;
	/**
	 * 邮件接收者
	 */
	private EMailAccount[] tos;
	/**
	 * 暗送邮件者
	 */
	private EMailAccount[] cc_tos;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public File[] getAttachs() {
		return attachs;
	}
	public void setAttachs(File[] attachs) {
		this.attachs = attachs;
	}
	public EMailAccount getFrom() {
		return from;
	}
	public void setFrom(EMailAccount from) {
		this.from = from;
	}
	public EMailAccount[] getTos() {
		return tos;
	}
	public void setTos(EMailAccount[] tos) {
		this.tos = tos;
	}
	public EMailAccount[] getCc_tos() {
		return cc_tos;
	}
	public void setCc_tos(EMailAccount[] cc_tos) {
		this.cc_tos = cc_tos;
	}
	
}
