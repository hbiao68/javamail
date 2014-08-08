package hb.webservice.service;


import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class Test {
	
	public static void main(String[]args){
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		String address = "http://localhost:7777/sendmail";
		factory.setServiceClass(SendEMailManager.class);
		factory.setAddress(address);
		SendEMailManager service = (SendEMailManager)factory.create();
		Object result = service.sendEmailByString("mysubject", "huangbiao");
		System.out.println("client : " + result);
	}
}
