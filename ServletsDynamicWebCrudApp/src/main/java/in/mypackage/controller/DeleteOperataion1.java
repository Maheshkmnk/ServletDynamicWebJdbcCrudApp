package in.mypackage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.mypackage.service.IEmployeeService;
import in.mypackage.servicefactory.EmployeeServiceFactory;

import javax.servlet.ServletException;


public class DeleteOperataion1 extends HttpServlet {

	private static final long serialVersionUID = 3L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		
		String eid = request.getParameter("eid");
		
		System.out.println(eid);
			
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		
		System.out.println("employeeService obj created");
		
		String msg = employeeService.deleteRecord(eid);
		
		if(msg.equalsIgnoreCase("success")) {
			out.println("<h1>record deleted successfully.....</h1>");
		}
	}
	
	
}
