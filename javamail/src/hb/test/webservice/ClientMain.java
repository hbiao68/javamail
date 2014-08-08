package hb.test.webservice;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class ClientMain {

	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		String address = "http://localhost:7777/hb";
		factory.setServiceClass(HelloWorldCxfService.class);
		factory.setAddress(address);
		HelloWorldCxfService service = (HelloWorldCxfService)factory.create();
		String result = service.sayHello("huangbiao");
		System.out.println("client : " + result);
	}

}
