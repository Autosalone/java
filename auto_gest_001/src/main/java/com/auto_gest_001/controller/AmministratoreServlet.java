package com.auto_gest_001.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auto_gest_001.implement.AmministratoreImpl;
import com.auto_gest_001.implement.FiltroImpl;
import com.auto_gest_001.model.Auto;
import com.auto_gest_001.model.Filtro;

/**
 * Servlet implementation class AmministratoreServlet
 */
public class AmministratoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmministratoreServlet() {
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

		PrintWriter out=response.getWriter();
		
		AmministratoreImpl a = new AmministratoreImpl();
		
		Auto auto = new Auto();
		
		
		Filtro filtro = new Filtro();
		
		filtro.setPrezzoMin(4000);
		filtro.setPrezzoMax(23000);
		filtro.setCambio("manuale");
		filtro.setAlimentazione("benzina");
		
		
		
		
		
		
		
		
		
	}

}
