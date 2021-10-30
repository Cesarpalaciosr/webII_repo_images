package cp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cp.helpers.*;
import cp.controllers.ControlUser;

/**
 * Servlet implementation class Register
 */
@MultipartConfig()
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter();
		out.print(" esto es la respuesta para el cliente");
		//response.sendRedirect("http://localhost:8080/Proyecto_Web_II_Cesar/index.html");//response.sendRedirect("./public/views/login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.addHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println(request.getParameter("cedula"));
		int ci = Integer.parseInt(request.getParameter("cedula"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		System.out.println("nombre: "+name);
		System.out.println(ci);
		String h = Hashing.hashPass(pass);
		System.out.println(h);
		
		ControlUser control = new ControlUser();
		String registered = control.registerUser(name, age, ci, username, email, h);
		if(registered.equals("registrado")) {
		//	response.sendRedirect("./public/views/login.html");
			//out.println("{\"message\":\"Usuario creado satisfactoriamente\", \"status\": 200}");
			out.println("{\"success\":\"true\",\"msg\":\"Hola Mundo\",\"status\":\"200\"}");
		} else {
			//Cambiar Redireccionamiento
			response.sendRedirect("#");
			out.println("error estoy en el else");
		}
	}
}
