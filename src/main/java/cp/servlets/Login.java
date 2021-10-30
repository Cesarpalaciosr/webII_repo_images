package cp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cp.controllers.ControlUser;
import cp.helpers.Hashing;


/**
 * Servlet implementation class Login
 */
@MultipartConfig()
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		String user = request.getParameter("username");
		String pass = request.getParameter("pass");
		
		String h = Hashing.hashPass(pass);	
		System.out.println("Soy el hasheo del log servlet"+h);
		ControlUser u = new ControlUser();
		
		String accessed = u.loginUser(user, h);
		
		HttpSession session = request.getSession(true);
		
		if(accessed.equals("accessed")) {
			System.out.println("Access granted");
			out.println("{\"success\":\"true\",\"msg\":\"Hola Mundo\",\"status\":\"200\"}");
			session.setAttribute("user", user);
			System.out.println("Se le otrogo session al usuario");
		}else {
			response.sendRedirect("#");
			response.setStatus(404);
		}
	}

}
