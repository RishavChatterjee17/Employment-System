package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utils.UserUtilsDAO;
import Utils.UserUtilsDAOImpl;
import beans.User;
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String em = request.getParameter("email");
		String pass = request.getParameter("password");
		String role = request.getParameter("role");
		
		UserUtilsDAO dao = new UserUtilsDAOImpl();
		User user = dao.validate(em, pass, role);
		if(user != null){
			System.out.println(user.getU_role());
			if(user.getU_role().equals("gp")){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("CsHome.jsp");
			}else if(user.getU_role().equals("bdo")){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("BDOHome.jsp");
			}
		}else{
			System.out.println("hmmmmmmmm");
			response.sendRedirect("login.jsp?login=failed");
		}
	}

	protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
