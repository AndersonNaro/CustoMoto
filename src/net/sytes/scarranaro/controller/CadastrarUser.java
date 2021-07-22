package net.sytes.scarranaro.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sytes.scarranaro.da.DAUsuario;
import net.sytes.scarranaro.vo.Usuario;

@WebServlet("/CadastrarUser")
public class CadastrarUser extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DAUsuario da = new DAUsuario();
		HttpSession session = req.getSession();
		String usuario = req.getParameter("usuario");
		String pass = req.getParameter("password");
		
		
		Usuario user = new Usuario(usuario, pass);
		try {
			da.adiciona(user);
			session.setAttribute("status", "SUCCESS");
			session.setAttribute("usuario", usuario);
			resp.sendRedirect("app/oi");			
			
		} catch (SQLException e) {
			
			session.setAttribute("status", "ERROR");
			resp.sendRedirect("./CadastrarUser");
		}
		
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("CadastrarUser.jsp");
		dispatcher.forward(req, resp);
	}
	
	

	
}
