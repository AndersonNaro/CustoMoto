package net.sytes.scarranaro.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Logado extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static boolean isTrue(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		if(session.getAttribute("usuario")==null) {
			return true;
		}
		return false;
		
		
	}
	
}
