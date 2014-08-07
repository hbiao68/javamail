package hb.test.webservice;


import javax.xml.ws.Endpoint;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;

public class MyServerInteceptor {
	
	public static void main(String[] args) {
		
		String address = "http://localhost:7777/hb";
		EndpointImpl ep = (EndpointImpl)Endpoint.publish(address, new HelloWorldCxfServiceImpl());
		
		//添加in拦截器
		ep.getInInterceptors().add(new LoggingInInterceptor());
		//添加out拦截器
		ep.getOutInterceptors().add(new LoggingInInterceptor());;
		
		System.out.println("发布消息成功");
	}
	
}
