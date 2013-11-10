package app04.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app04.Address;
import app04.model.Employee;

@WebServlet(urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet{
   private static final int serialVersionUID = -5392874;
   
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
   IOException{
	   
	   Address address = new Address();
	   address.setCity("Singapore");
	   address.setCountry("Singapore");
	   address.setState("");
	   address.setStreetName("Punngol Drive");
	   address.setStreetNumber("641");
	   address.setZipCode(18804);
	   
	   Employee employee = new Employee();
	   employee.setAddress(address);
	   employee.setId(101);
	   employee.setName("Hari Babu");
	   request.setAttribute("employee", employee);
	   Map<String, String> capitals = new HashMap<String, String>(); 
	   capitals.put("India", "Delhi");
	   capitals.put("China", "Bejing");
	   capitals.put("Singapore", "Singapore");
	   capitals.put("Australia","Sydney");
	   request.setAttribute("capitals", capitals);
	   RequestDispatcher rd = request.getRequestDispatcher("/employee.jsp");
	   rd.forward(request, response);
	   
   }
	
	
	
}
