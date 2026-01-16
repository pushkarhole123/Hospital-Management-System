package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HospitalDAO;
import com.dao.HospitalDAOImpl;
import com.model.Hospital;

@WebServlet("/UpdateFormServlet")
public class UpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateFormServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String drName = request.getParameter("drName");

		System.out.println(drName);
		HospitalDAO dao = new HospitalDAOImpl();
		Hospital hospital = dao.findDrByName(drName);

		System.out.println(hospital);
		out.print("<form action='UpdateServlet' method='get'>");

		out.print("<input type='text' name='drName' value='" + hospital.getDrName() + "' readonly>");
		out.print("<br>");

		out.print("<input type='text' name='dept' value='" + hospital.getDept() + "'>");
		out.print("<br>");

		out.print("<input type='text' name='salary' value='" + hospital.getSalary() + "'>");
		out.print("<br>");

		out.print("<input type='submit' value='Update Doctor'>");

		
		
	}
}
