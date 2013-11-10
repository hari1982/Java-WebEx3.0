package app01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet(name = "MyServlet", urlPatterns = { "/my" })
public class MyServlet implements Servlet {

	private transient ServletConfig servletConfig;
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public ServletConfig getServletConfig() {
			return servletConfig;
	}

	public String getServletInfo() {
		return "My Servlet Info";
	}

	public void init(ServletConfig servletConfig) throws ServletException {
		this.servletConfig = servletConfig;
	}

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
	String servletName = servletConfig.getServletName();
	PrintWriter writer = response.getWriter();
	response.setContentType("text/html");
	writer.write("<html><head></head><body>Hello from My "+ servletName + "</body></html>");
	}

}
