package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.ProjectUtilsDAO;
import Utils.ProjectUtilsDAOImpl;
import beans.Project;

@WebServlet("/createProject")
public class ProjectCreateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectUtilsDAO dao = new ProjectUtilsDAOImpl();
		String pn = request.getParameter("p_name");
		String lc = request.getParameter("p_location");
		Project p = new Project();
		p.setP_name(pn);
		p.setP_location(lc);
		if(dao.addProject(p)){
			response.sendRedirect("createProject.jsp?create=done");
		}else{
			response.sendRedirect("createProject.jsp?create=failed");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
