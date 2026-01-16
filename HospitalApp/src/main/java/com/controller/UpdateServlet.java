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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String drName = request.getParameter("name");
        
        String dept = request.getParameter("dept");
        double salary = Double.parseDouble(request.getParameter("salary"));      

        Hospital hospital = new Hospital(drName, dept, salary);
        

        HospitalDAO dao = new HospitalDAOImpl();
        int cnt = dao.updateHospital(hospital);

        if (cnt > 0) {
            out.print("<h3 style='color:green;'>Doctor updated successfully!</h3>");
            RequestDispatcher rd = request.getRequestDispatcher("ShowServlet");
            rd.include(request, response);
        } else {
            out.print("<h3 style='color:red;'>Update failed!</h3>");
        }
    }

   
}
