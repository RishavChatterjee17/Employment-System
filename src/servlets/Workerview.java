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

@WebServlet("/Worker")
public class Workerview extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WorkerUtilsDAO dao = new WorkerUtilsDAOImpl();
		int P_ID = Integer.parseInt(request.getParameter("p_id"));
		List<Workers> wlist = dao.getWorkersDetails(P_ID);
		request.setAttribute("w", wlist);
		RequestDispatcher rd = request.getRequestDispatcher("workerview.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
