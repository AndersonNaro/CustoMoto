package net.sytes.scarranaro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sytes.scarranaro.da.DAUsuario;
import net.sytes.scarranaro.vo.Usuario;


@WebServlet("/login")
public class Login extends HttpServlet {


	
	private static final long serialVersionUID = 6176714715997429838L;



	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario user = new Usuario();
		DAUsuario da = new DAUsuario();
		String usuario = req.getParameter("usuario");
		String pass = req.getParameter("password");
		HttpSession session = req.getSession();
		
        

		
		// consultar no db
		try {
			user = da.consulta(usuario, pass); 
		} catch (Exception e) {
			
		}
		
		
		if (usuario.equals(user.getNome()) && pass.equals(user.getPass())) {
			session.setAttribute("i_id_usr", user.getId());
			session.setAttribute("usuario", usuario);
            session.setAttribute("status", "SUCCESS");
            resp.sendRedirect("app/MotoServlet");
        } 
        else {        	
        	session.setAttribute("status", "");
            resp.sendRedirect("login");
            // dar feedback pro usuario
            //limpar campos
        }
		

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
		
		
		
	}
	
	
	
}
