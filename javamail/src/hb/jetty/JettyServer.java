package hb.jetty;

import hb.webservice.service.MailWebService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.DefaultHandler;
import org.mortbay.xml.XmlConfiguration;
import org.xml.sax.SAXException;

public class JettyServer {

	public static void main(String[] args) {
		
		/********************启动jetty*****************************/
		Server server = new Server(9999);
		server.setHandler(new DefaultHandler());
		XmlConfiguration configuration = null;
		try {
			configuration = new XmlConfiguration(new FileInputStream("D:/jettytest/javamail/jetty/etc/jetty.xml"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (SAXException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			configuration.configure(server);
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/********************启动webservice*****************************/
		MailWebService WebService = new MailWebService();
		WebService.release();
		
	}
}