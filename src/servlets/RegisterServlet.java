package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.WorkerUtilsDAO;
import Utils.WorkerUtilsDAOImpl;
import beans.Project;
import beans.Workers;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String wname = request.getParameter("w_name");
		int adhar = Integer.parseInt(request.getParameter("w_adhar"));
		String addr = request.getParameter("w_address");
		int p_id = Integer.parseInt(request.getParameter("project"));
		Project p = new Project();
		p.setP_id(p_id);
		
		Workers wk = new Workers();
		wk.setW_name(wname);
		wk.setW_adhar(adhar);
		wk.setW_address(addr);
		wk.setProject(p);
		WorkerUtilsDAO dao = new WorkerUtilsDAOImpl();
		if(dao.registerWorker(wk)){
			System.out.println("Finally..!");
			response.sendRedirect("registerWorker.jsp?register=success");
		}else{
			response.sendRedirect("registerworker.jsp?register=failed");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
