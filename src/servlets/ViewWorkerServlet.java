package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.WorkerUtilsDAO;
import Utils.WorkerUtilsDAOImpl;
import beans.Workers;
@WebServlet("/viewWorkers")
public class ViewWorkerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WorkerUtilsDAO dao = new WorkerUtilsDAOImpl();
		List<Workers> workerList = dao.getAllWorker();
		request.setAttribute("workers", workerList);
		RequestDispatcher rd = request.getRequestDispatcher("viewWorkers.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
