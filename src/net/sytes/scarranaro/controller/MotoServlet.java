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

import net.sytes.scarranaro.vo.Moto;
import net.sytes.scarranaro.da.DAMoto;

/**
 * Servlet implementation class MotoServlet
 */
@WebServlet("/app/MotoServlet")
public class MotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MotoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/app/setaMoto.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		DAMoto da = new DAMoto();
		HttpSession session = request.getSession();
		Moto moto = new Moto();
		int idMoto =  Integer.parseInt(request.getParameter("select-moto"));
		try {
			moto = da.modelo(idMoto);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		session.setAttribute( "moto", moto);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/app/manutencoes.jsp");
		dispatcher.forward(request, response);
	}

}
