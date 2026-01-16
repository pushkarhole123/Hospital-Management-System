package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HospitalDAO;
import com.dao.HospitalDAOImpl;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String drname = request.getParameter("drName");

		HospitalDAO dao = new HospitalDAOImpl();
		int cnt = dao.deleteHospital(drname);

		if (cnt > 0) {
			out.print("<h1>Delete Successfully</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("ShowServlet");
			rd.include(request, response);
		} else {
			out.print("Failed");
		}
	}

}
