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
import com.model.Hospital;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AddServlet() {
        super();
    }
	
	@Override
	public void init() throws ServletException {
		
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String drName = request.getParameter("name");
		String dept = request.getParameter("dept");
		double salary = Double.parseDouble(request.getParameter("salary"));
		
		Hospital hospital = new Hospital();
		hospital.setDrName(drName);
		hospital.setDept(dept);
		hospital.setSalary(salary);
		
		HospitalDAO dao = new HospitalDAOImpl();
		int cnt = dao.addHospital(hospital);
		
		if(cnt > 0) {
			out.print("<h1>Add Successfully</h1>");
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowServlet");
			rd.include(request, response);
		} else {
			out.print("Failed To Add");
		}
	}

}
