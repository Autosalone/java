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
import com.auto_gest_001.model.Info_Gen;


/**
 * Servlet implementation class FilstroServlet
 */
public class FiltroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiltroServlet() {
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
		
		Info_Gen g = new Info_Gen();
		g.setKm(0);
		g.setPrezzo(25000);
		g.setAlimentazione("benzina");
		g.setCilindrata(1500);
		g.setCambio("manuale");
		g.setN_porte(4);
		g.setN_posti(5);
		g.setStato("nuovo");
		
		Auto a = new Auto();
		
		a.setCasaProduttrice("Volswagen");
		a.setModello("Golf");
		a.setPrenotata(false);
		AmministratoreImpl t = new AmministratoreImpl();
		t.addAuto(a, g);
		out.println("Auto aggiunta");
		
		/*FiltroImpl f = new FiltroImpl();
		
		Filtro filtro = new Filtro();
		
		filtro.setPrezzoMin(4000);
		filtro.setPrezzoMax(23000);
		filtro.setCambio("manuale");
		filtro.setAlimentazione("benzina");
		
		ArrayList<Auto> listaAuto = f.applicaFiltri(filtro);
		
		for(Auto x: listaAuto) {
			out.println(x.getModello() + " " + x.getCasaProduttrice()); 
		}*/
		
		
		/*PrintWriter out=response.getWriter();
		
		FiltroImpl f = new FiltroImpl();
		ArrayList<Auto> lista = f.allAuto();
		for(Auto x: lista) {
			out.println(x.getModello());
		}*/

		
		
		
		
	}

}
