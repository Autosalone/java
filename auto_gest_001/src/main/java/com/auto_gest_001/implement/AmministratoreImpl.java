package com.auto_gest_001.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.auto_gest_001.dao.Dao;
import com.auto_gest_001.model.Auto;
import com.auto_gest_001.model.Info_Gen;
import com.auto_gest_001.utility.AmministratoreUtility;

public class AmministratoreImpl implements AmministratoreUtility {
	
	private Connection con=null;//attributo connection
	private Statement st=null; //oggetto statement dove posiamo effettuare operazioni CRUD
	private ResultSet rst=null;//risultato delle operazioni CRUD effettuate su Statement
	private PreparedStatement pst=null;


	
public void addAuto(Auto a, Info_Gen g) {
		
		con=Dao.getConnection(); //istanzia la conessione.
		
		String sql1 = "insert into info_gen (km, prezzo, alimentazione, cilindrata, cambio, n_porte, n_posti, stato)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pst = con.prepareStatement(sql1);
			pst.setDouble(1, g.getKm());
			pst.setDouble(2, g.getPrezzo());
			pst.setString(3, g.getAlimentazione());
			pst.setInt(4, g.getCilindrata());
			pst.setString(5, g.getCambio());
			pst.setInt(6, g.getN_porte());
			pst.setInt(7, g.getN_posti());
			pst.setString(8, g.getStato());
			pst.execute();
			pst=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int id = 0;
		String sql2 = "select id_info_gen from info_gen where km=? and prezzo=? and alimentazione=? and cilindrata=? and cambio=? and n_porte=? and n_posti=? and stato=?";
		try {
			pst=con.prepareStatement(sql2);
			pst.setString(1, Double.toString(g.getKm()));
			pst.setString(2, Double.toString(g.getPrezzo()));
			pst.setString(3, g.getAlimentazione());
			pst.setString(4, Integer.toString(g.getCilindrata()));
			pst.setString(5, g.getCambio());
			pst.setString(6, Integer.toString(g.getN_porte()));
			pst.setString(7, Integer.toString(g.getN_posti()));
			pst.setString(8, g.getStato());
			
			rst = pst.executeQuery();
			rst.last();
			id = rst.getInt("id_info_gen");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql3 = "insert into auto (modello, casa_prod, id_info_gen, prenota) values (?, ?, ?, ?)";
		
		try {
			pst=con.prepareStatement(sql3);
			pst.setString(1, a.getModello());
			pst.setString(2, a.getCasaProduttrice());
			pst.setInt(3, id);
			pst.setInt(4, 0);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	public void removeAuto(Auto a) {
		
		con=Dao.getConnection(); //istanzia la conessione.
		
		int idAuto=a.getIdAuto();
		
		try {
			st=con.createStatement();
			
			rst = st.executeQuery("select id_info_gen from auto where id_auto ="+"'"+idAuto+"'");
			
			st.executeQuery("remove * from auto where id_auto = "+"'"+idAuto+"'");
			
			st.executeQuery("remove * from info_gen where id_info_gen ="+"'"+rst+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	public void setPrezzo(Auto a, double prezzo) {
		
		con=Dao.getConnection(); //istanzia la conessione;
		
		int idAuto=a.getIdAuto();
		
		
		try {
			st=con.createStatement();
			
			rst = st.executeQuery("select id_info_gen from auto where id_auto ="+"'"+idAuto+"'");
			
			st.executeQuery("update info_gen set prezzo = "+"'"+prezzo+"'"+"where id_info_gen= "+"'"+rst+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
