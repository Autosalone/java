package com.auto_gest_001.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.auto_gest_001.dao.Dao;
import com.auto_gest_001.model.Auto;
import com.auto_gest_001.utility.PrenotazioneUtility;

public class PrenotazioneImpl implements PrenotazioneUtility {

	private Connection con = null;
	private Statement st = null;
	private ResultSet rst = null;
	private PreparedStatement pst=null;
	
	
	/* (non-Javadoc)
	 * @see com.javabean.PrenotaUtility#prenotaAuto(com.javabean.Auto)
	 */
	public void prenotaAuto(Auto a){
		con = Dao.getConnection();	//controlla se è aperta la connessione e return conn
		String q="update auto set prenota=? where id=?";
		if(!a.isPrenotata()) {
			try {
				pst=con.prepareStatement(q);
				pst.setInt(1, 1);
				pst.setInt(2, a.getIdAuto());
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
