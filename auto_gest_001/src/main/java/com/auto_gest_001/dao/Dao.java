package com.auto_gest_001.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Dao {
	
	private static DataSource ds=null;	
	private static Connection con=null; //torna ad essere la connection di java.sql.Connection
	
	private static Dao dao=null; //è publica perchè deve essere vista da chi la usa ---- messa privata dopo una discussione.
	
	
	private Dao() { //costruttore privato del Dao secondo il pattern Singleton
		
		Context initCtx=null;	
		Context envCtx=null;	
		
		try {
			
			initCtx = new InitialContext(); //carica il context presente in tomcat
			envCtx = (Context) initCtx.lookup("java:comp/env"); //sta leggendo nel context i compontenti java a livello envrment (nell'ambiente più generale, ovvero qualche cosa che è stato registrato nel JNDI)
			ds = (DataSource)envCtx.lookup("jdbc/autosalone"); // sta leggendo nel web.xml fino ad arrivare al datasource
			
		} catch (NamingException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static Connection getConnection() {
		
		if(ds==null) {
			
			dao=new Dao();
		
		}
		
		try {
			
			con=ds.getConnection();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return con;
		
		
	}
	
	

}
