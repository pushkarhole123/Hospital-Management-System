package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.HospitalDAO;
import com.dao.HospitalDAOImpl;
import com.model.Hospital;

@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HospitalDAO dao = new HospitalDAOImpl();

		out.print("<html>");
		out.print("<head><title>Doctor List</title></head>");
		out.print("<body style='font-family: Arial, sans-serif; background-color: #f4f6f9;'>");
		out.print("<h2 style='text-align:center; color:#333;'>Hospital Doctor List</h2>");

		out.print("<table border='2' style='border-collapse:collapse; " + "box-shadow: 0 2px 10px rgba(0,0,0,0.1); "
				+ "background:white; width:80%; margin:30px auto;'>");

		// Table header row
		out.print("<tr style='background-color:#4CAF50; color:white; text-align:center;'>");
		out.print("<th style='padding:12px 15px;'>Doctor Name</th>");
		out.print("<th style='padding:12px 15px;'>Department</th>");
		out.print("<th style='padding:12px 15px;'>Salary</th>");
		out.print("<th style='padding:12px 15px;'>Update</th>");
		out.print("<th style='padding:12px 15px;'>Delete</th>");
		out.print("</tr>");

		// Data rows
		List<Hospital> list = dao.showAllDrList();
		for (Hospital data : list) {
			out.print("<tr style='text-align:center;'>");
			out.print("<td style='padding:12px 15px;'>" + data.getDrName() + "</td>");
			out.print("<td style='padding:12px 15px;'>" + data.getDept() + "</td>");
			out.print("<td style='padding:12px 15px;'>" + data.getSalary() + "</td>");
			out.print(
					"<td style='padding:12px 15px;'><a style='color:white; background:#2196F3; padding:6px 10px; border-radius:4px; text-decoration:none;' "
							+ "href='UpdateFormServlet?drName=" + data.getDrName() + "'>Update</a></td>");
			out.print(
					"<td style='padding:12px 15px;'><a style='color:white; background:#f44336; padding:6px 10px; border-radius:4px; text-decoration:none;'"
							+ " href='DeleteServlet?drName=" + data.getDrName() + "'>Delete</a></td>");
			out.print("</tr>");
		}

		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}
}
