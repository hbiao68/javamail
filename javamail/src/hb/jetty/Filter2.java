package hb.jetty;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter2 implements Filter{
	
	public void destroy() {
		System.out.println("Filter2 destory");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Filter2 doFilter");
		request.getRequestDispatcher("/MyServlet.do").forward(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Filter2 init");
	}
}
