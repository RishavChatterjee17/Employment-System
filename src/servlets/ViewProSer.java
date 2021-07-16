package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.ProjectUtilsDAO;
import Utils.ProjectUtilsDAOImpl;
import beans.Project;

/**
 * Servlet implementation class ViewProSer
 */
@WebServlet("/viewPro")
public class ViewProSer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectUtilsDAO dao = new ProjectUtilsDAOImpl();
		List<Project> plist = dao.getAllProject();
		request.setAttribute("plist", plist);
		RequestDispatcher rd = request.getRequestDispatcher("viewProject.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
