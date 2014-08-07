package hb.test.webservice;

import javax.jws.WebService;

@WebService(endpointInterface="hb.test.webservice.HelloWorldCxfService")
public class HelloWorldCxfServiceImpl implements HelloWorldCxfService {

    public String sayHello(String username) {
    	System.out.println("Hello,"+username);
        return "Hello,"+username;
    }
}
