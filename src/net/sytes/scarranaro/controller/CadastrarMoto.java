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

import net.sytes.scarranaro.da.DAManutencao;
import net.sytes.scarranaro.da.DAMoto;
import net.sytes.scarranaro.vo.Moto;

/**
 * Servlet implementation class CadastrarMoto 
 */
@WebServlet("/app/CadastrarMoto")
public class CadastrarMoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet() 
     */
    public CadastrarMoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/app/cadastrarMoto.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAMoto daMoto = new DAMoto();
		DAManutencao daManut = new DAManutencao();
		Moto moto = new Moto();
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		int km = Integer.parseInt(request.getParameter("km"));
		HttpSession session = request.getSession();
		int id_usr = (Integer) session.getAttribute("i_id_usr");
		
		moto.setMarca(marca);
		moto.setModelo(modelo);
		
		try {
			int idMoto = daMoto.existe(marca, modelo);
			
			if (idMoto == 0) {				
				daMoto.adicionaMoto(moto);				
				idMoto = daMoto.existe(marca, modelo);
				moto.setId(idMoto);
			}else {
				moto.setId(idMoto);				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		
		try {
			daManut.adicionaManutencao(id_usr, moto.getId(), km);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		doGet(request, response);
	}

}
