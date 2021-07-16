package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.ProjectUtilsDAO;
import Utils.ProjectUtilsDAOImpl;
import beans.Project;

@WebServlet("/viewProject")
public class RegPJServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pj_id = Integer.parseInt(request.getParameter("pj_id"));
		ProjectUtilsDAO dao = new ProjectUtilsDAOImpl();
		Project project = dao.getProject(pj_id);
		request.setAttribute("pj", project);
		RequestDispatcher rd = request.getRequestDispatcher("workerDetails.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
