package hb.mail.model;

public class User {

	private String userid;
	private String username;
	private String password;
	/**
	 * 邮件账号
	 */
	private EMailAccount EMailAccount;
	/**
	 * 是否可用
	 * true 可用， false 不可用
	 */
	private boolean available;
	/**
	 * 部门
	 */
	private String department;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public EMailAccount getEMailAccount() {
		return EMailAccount;
	}
	public void setEMailAccount(EMailAccount eMailAccount) {
		EMailAccount = eMailAccount;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
