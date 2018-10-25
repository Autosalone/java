package com.auto_gest_001.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auto_gest_001.implement.UtenteImpl;
import com.auto_gest_001.model.Utente;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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

		PrintWriter out =response.getWriter();
		String username=request.getParameter("user");
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		UtenteImpl uImp=new UtenteImpl();
		
		Utente utente=new Utente();
	
		if(uImp.controlloLogin(username)==false) {
			out.println("te devi registra!!!!!!!!!");
		}
		else {
			utente=uImp.login(username, password);
			if(utente !=null) {
				if(uImp.amministratore(username)) {
					out.println("amm");
				}else {
					out.print("user");
				}
				out.println("Login effettuato correttamente!");
			}else {
				out.println("non sono corr");
			}
		
			
		}

		
		
		
	}

}
