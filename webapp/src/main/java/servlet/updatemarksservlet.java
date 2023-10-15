package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.marksdao;
import dbconnection.studentdb;
import model.marksmodel;

@SuppressWarnings("serial")
@WebServlet("/update")
public class updatemarksservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int Rollnumber = Integer.parseInt(req.getParameter("Rollnumber"));

		int Telugu = Integer.parseInt(req.getParameter("Telugu"));

		int Hindi = Integer.parseInt(req.getParameter("Hindi"));

		int English = Integer.parseInt(req.getParameter("English"));
		
		int Maths = Integer.parseInt(req.getParameter("Maths"));

		int Science = Integer.parseInt(req.getParameter("Science"));

		int Social = Integer.parseInt(req.getParameter("Social"));

		marksmodel marks = new marksmodel(Rollnumber, Telugu, Hindi, English, Maths, Science, Social);

		marksdao dao1 = new marksdao(studentdb.getConn());

		HttpSession session = req.getSession();

		boolean f = dao1.updateMarks(marks);

		if (f) {

			session.setAttribute("SuccMsg", " Updated student successfully .... ");

			System.out.println("Updated successfully");

			resp.sendRedirect("AllMarks.jsp");
		}

		else {

			session.setAttribute("ErrorMsg", " Invaild Operation .... ");

			System.out.println("Invaild Operation ....");

			resp.sendRedirect("AllMarks.jsp");

		}
	}
}
