package com.auto_gest_001.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.auto_gest_001.dao.Dao;
import com.auto_gest_001.model.Auto;
import com.auto_gest_001.model.Filtro;
import com.auto_gest_001.utility.FiltroUtility;



public class FiltroImpl implements FiltroUtility {
	
	private Connection con=null;//attributo connection
	private Statement st=null; //oggetto statement dove posiamo effettuare operazioni CRUD
	private ResultSet rst=null;//risultato delle operazioni CRUD effettuate su Statement

	public ArrayList<Auto> applicaFiltri(Filtro f) {
		ArrayList<Auto> filtroAuto = new ArrayList<Auto>();
		
		Auto a;
		
		StringBuilder s = new StringBuilder("select * from auto, info_gen where auto.id_info_gen = info_gen.id_info_gen");
		if(f.getMarca().length() > 0)
			s.append(" and casa_prod = " + "'" + f.getMarca() + "'");
		if(f.getModello().length() > 0)
			s.append(" and modello = " + "'" + f.getModello() + "'");
		if(f.getKm() > 0.0)
			s.append(" and km = "+ "'" + f.getKm() + "'");
		
		
		if(f.getPrezzoMin() > 0.0 && f.getPrezzoMax() > 0.0) 
			s.append(" and (prezzo between " + "'" + f.getPrezzoMin() + "'" + " and " + "'" + f.getPrezzoMax()+ "'" + ")");//da testare
		else {
			if(f.getPrezzoMin() > 0.0)
				s.append(" and prezzo >= " + "'" + f.getPrezzoMin() + "'");
			else if(f.getPrezzoMax() > 0.0)
				s.append(" and prezzo <= " + "'" + f.getPrezzoMax() + "'");
		}
		
		if(f.getAlimentazione().length() > 0)
			s.append(" and alimentazione = " + "'" + f.getAlimentazione() + "'");
		if(f.getCilindrata() > 0)
			s.append(" and cilindrata = " + "'" + f.getCilindrata() + "'");
		if(f.getCambio().length() > 0)
			s.append(" and cambio = " + "'" + f.getCambio() + "'");
		if(f.getN_porte() > 0)
			s.append(" and n_porte = " + "'" + f.getN_porte() + "'");
		if(f.getN_posti() > 0)
			s.append(" and n_posti = " + "'" + f.getN_posti() + "'");
		if(f.getStato().length() > 0)
			s.append(" and stato = '" + f.getStato() + "'");
		
		String sql = s.toString();
		
		con=Dao.getConnection(); //istanzia la conessione.
		
		try {
			st=con.createStatement();
			rst=st.executeQuery(sql);
			rst.first();
			a = new Auto();
			a.setCasaProduttrice(rst.getString("casa_prod"));
			a.setModello(rst.getString("modello"));
			a.setIdAuto(rst.getInt("id_auto"));
			if(rst.getInt("prenota") > 0)
				a.setPrenotata(true);
			else
				a.setPrenotata(false);
			filtroAuto.add(a);
			
			while(rst.next()) {
				a = new Auto();
				a.setCasaProduttrice(rst.getString("casa_prod"));
				a.setModello(rst.getString("modello"));
				a.setIdAuto(rst.getInt("id_auto"));
				if(rst.getInt("prenota") > 0)
					a.setPrenotata(true);
				else
					a.setPrenotata(false);
				filtroAuto.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //passa lo statement istanziato nella connesione
		
		return filtroAuto;
	}
	
	public ArrayList<Auto> allAuto(){
		ArrayList<Auto> allAuto = new ArrayList<Auto>();
		Auto a;
		con = Dao.getConnection();
		try {
			st=con.createStatement();
			rst=st.executeQuery("select * from auto");
			while(rst.next()) {
				a = new Auto();
				a.setCasaProduttrice(rst.getString("casa_prod"));
				a.setModello(rst.getString("modello"));
				a.setIdAuto(rst.getInt("id_auto"));
				if(rst.getInt("prenota") > 0)
					a.setPrenotata(true);
				else
					a.setPrenotata(false);
				allAuto.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allAuto;
	}

}
