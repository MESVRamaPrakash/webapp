package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconnection.studentdb;
import dao.marksdao;
import model.marksmodel;

@SuppressWarnings("serial")
@WebServlet("/addmarks")
public class marksservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int Rollnumber = Integer.parseInt(req.getParameter("Rollnumber"));

		int Telugu = Integer.parseInt(req.getParameter("Telugu"));

		int Hindi = Integer.parseInt(req.getParameter("Hindi"));

		int English = Integer.parseInt(req.getParameter("English"));

		int Maths = Integer.parseInt(req.getParameter("Maths"));

		int Science = Integer.parseInt(req.getParameter("Science"));

		int Social = Integer.parseInt(req.getParameter("Social"));

		marksmodel mark = new marksmodel(Rollnumber, Telugu, Hindi, English, Maths, Science, Social);

		HttpSession session = req.getSession();

		marksdao dao = new marksdao(studentdb.getConn());

		boolean f = dao.addMarks(mark);

		if (f) {

			session.setAttribute("SuccMsg", "Marks entered Successfully ....");

			System.out.println("Marks entered Successfully ....");

			resp.sendRedirect("Home.jsp");
		}

		else {
			session.setAttribute("SuccMsg", "check the connection ....");

			System.out.println("check the connection ....");

			resp.sendRedirect("Marks.jsp");
		}
	}
}
