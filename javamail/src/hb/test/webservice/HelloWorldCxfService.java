package hb.test.webservice;

import javax.jws.WebService;

@WebService 
public interface HelloWorldCxfService {

	String sayHello(String username);
}

