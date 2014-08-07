package hb.mail.model;

public class EMailAccount {
	
	
	String username;//huangbiao
	String domain;//163.com
	String password;
	
	public EMailAccount(){
	}
	
	public EMailAccount(String username,String domain,String password){
		this.username = username;
		this.domain = domain;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString(){
		return getUsername()+"@"+getDomain();
	}
	
	
}
