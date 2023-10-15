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

@SuppressWarnings("serial")
@WebServlet("/delete")
public class deletestudentservlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int Rollnumber = Integer.parseInt(req.getParameter("Rollnumber"));

		studentdao dao = new studentdao(studentdb.getConn());

		HttpSession session = req.getSession();

		boolean f = dao.deleteStudent(Rollnumber);

		if (f) {
			session.setAttribute("SuccMsg", "deleted successfully ...");

			System.out.println("deleted successfully ...");

			resp.sendRedirect("AllStudents.jsp");
		}

		else {
			session.setAttribute("ErrorMsg", "Check the connection ....");

			System.out.println("Check the connection ....");

			resp.sendRedirect("AllStudents.jsp");
		}
	}
}
