package hb.webservice.util;

import hb.test.webservice.HelloWorldCxfServiceImpl;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxws.EndpointImpl;

public class Releaser {
	
	private static Releaser releaser= new Releaser();
	
	private Releaser(){
	}
	
	public static Releaser getInstance(){
		return releaser;
	}
	
	public Object release(String address,Object obj){
		EndpointImpl ep = (EndpointImpl)Endpoint.publish(address, obj);
		return ep;
	}
	
	
}
