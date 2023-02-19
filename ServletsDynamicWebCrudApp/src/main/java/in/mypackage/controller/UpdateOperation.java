package in.mypackage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.mypackage.dto.EmployeeDto;
import in.mypackage.service.IEmployeeService;
import in.mypackage.servicefactory.EmployeeServiceFactory;

public class UpdateOperation extends HttpServlet{
	public static final long serialVersionUID = 4L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String eid = request.getParameter("eid");
		
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		EmployeeDto employeeDto = employeeService.searchRecord(eid);
		
		out.println("<body style='background-color: lightpink; '>");

		out.println("<h1>This are the current details of searched record ID to update </h1>");

		out.println("<form method='post' action='/'>");
		out.println(
				"<table style='background-color:lightblue; margin-left: auto; margin-right: auto; border: 1px solid black; '>");
		out.println(
				"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee ID: </td ><td style='border: 1px solid black';>"
						+ employeeDto.getEid() + "</td><input name ='eid' value="+ employeeDto.getEid()+"/></tr>");
		out.println(
				"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee Name:</td><td style='border: 1px solid black';>"
						+ employeeDto.getEname() + "</td><input name ='newName'/></tr>");
		out.println(
				"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee Age:</td><td style='border: 1px solid black';>"
						+ employeeDto.getEage() + "</td><input name ='newAge'/></tr>");
		out.println(
				"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee Email:</td><td style='border: 1px solid black';>"
						+ employeeDto.getEmail() + "</td><input name ='newEmail'/></tr>");
		out.println(
				"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee Mobile Number:</td><td style='border: 1px solid black';>"
						+ employeeDto.getEmobile() + "</td><input name ='newMobile'/></tr>");
		out.println("</table>");
		
		out.println("</form>");
		
		out.println(
				"<div style='border: 1px solid green; background-color: yellow; text-align : center; width:10%; margin-left: auto; margin-right: auto; margin-top: 10px;'>");
		out.println("<a href='./' style='font-color: green; '>Go to Registration Page</a>");
		out.println("</div>");

		out.println("</body>");
		
	}

}
