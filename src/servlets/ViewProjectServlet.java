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


@WebServlet("/viewProject1")
public class ViewProjectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectUtilsDAO dao = new ProjectUtilsDAOImpl();
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		Project p = dao.getProject(p_id);
		request.setAttribute("p", p);
		RequestDispatcher rd = request.getRequestDispatcher("project.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
