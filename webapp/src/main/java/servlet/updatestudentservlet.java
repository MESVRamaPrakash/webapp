package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconnection.studentdb;
import dao.studentdao;
import model.studentmodel;

@SuppressWarnings("serial")
@WebServlet("/updateuser")
public class updatestudentservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int Rollnumber = Integer.parseInt(req.getParameter("Rollnumber"));
		String Studentname = req.getParameter("Studentname");
		String Section = req.getParameter("Section");
		String Clas = req.getParameter("Clas");
		String Email = req.getParameter("Email");
		String Password = req.getParameter("Password");
		String Fathername = req.getParameter("Fathername");
		String Mothername = req.getParameter("Mothername");
		

		studentmodel student = new studentmodel(Rollnumber, Studentname, Section, Clas, Email, Password, Fathername,
				Mothername);

		studentdao dao = new studentdao(studentdb.getConn());

		HttpSession session = req.getSession();

		boolean f = dao.updateStudent(student);

		if (f) {

			session.setAttribute("SuccMsg", " Updated student successfully .... ");

			System.out.println("Updated successfully");

			resp.sendRedirect("AllStudents.jsp");
		}

		else {

			session.setAttribute("ErrorMsg", " Invaild Operation .... ");

			System.out.println("Invaild Operation ....");

			resp.sendRedirect("Home.jsp");

		}
	}
}
