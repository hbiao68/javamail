package hb.servlet.init;


import hb.util.cache.CachFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class IninProjectListener implements ServletContextListener {

	Logger log = Logger.getLogger(IninProjectListener.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent context) {

	}

	@Override
	public void contextInitialized(ServletContextEvent context) {
		//初始化log4j，读取配置文件
		try {
			InitLog4j.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.debug("project is starting");
		
		//创建缓存对象
		CachFactory cachFactory = CachFactory.getInstance();
//		Map<String,Object> userCache = cachFactory.createCach("userService");
		
		//发送消息service对象缓存
		Map<String,Object> sendMailService = cachFactory.createCache("sendMailServiceCache");
		
		
		log.debug("project is started");
		
		
		
		
	}

	/**
	 * 获取/WEB-INF/config/ajmessage/ajmessage.properties 配置文件
	 * @param webPath
	 */
	public void loadAjmessageProperty(String webPath) {


	}
	
	
	/**
	 * 获取/WEB-INF/config/project/project.properties 配置文件
	 * @param webPath
	 */
	public void loadProjectProperty(String webPath) {

	

	}

}
