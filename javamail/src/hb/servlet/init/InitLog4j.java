package hb.servlet.init;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class InitLog4j {
	
	public static Logger log = Logger.getLogger(InitLog4j.class);

	public static void init() throws Exception {
		FileInputStream istream = null;
		try {
			Properties props = new Properties();
			// 指明了获取配置文件的路径
			istream = new FileInputStream("jetty/etc/log4j.properties");
			props.load(istream);// 从输入流中读取属性列表
			PropertyConfigurator.configure(props);
		} catch (Exception ex) {
			log.error("initLog4j.error:", ex);
			throw new Exception(ex);
		} finally {
			istream.close();
		}
	}

}
