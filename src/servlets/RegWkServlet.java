package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.WorkerUtilsDAO;
import Utils.WorkerUtilsDAOImpl;
import beans.Workers;
@WebServlet("/viewWK")
public class RegWkServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int wk_id = Integer.parseInt(request.getParameter("wk_id"));
		WorkerUtilsDAO dao = new WorkerUtilsDAOImpl();
		Workers worker = dao.getWorkersDetails(wk_id);
		request.setAttribute("wk", worker);
		RequestDispatcher rd = request.getRequestDispatcher("workerDetails.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
