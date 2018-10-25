package com.auto_gest_001.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.auto_gest_001.dao.Dao;
import com.auto_gest_001.model.Utente;
import com.auto_gest_001.utility.UtenteUtility;





public class UtenteImpl implements UtenteUtility {

	private Connection con=null;
	private Statement st=null;
	private ResultSet rst=null;
	private Utente u= null;
	
	
	public boolean controlloRegistrazione(String username) {

		con=Dao.getConnection();		
		
		try {
			//oggetto statement per creare sql query strings
			st=con.createStatement();
			//rst avrà il risultato della sql query, quindi tutti i record interni
			rst=st.executeQuery("Select user from autosalone.utente where user = '"+username+"';");
			//il metodo first va a selezionare il primo record, quindi se non c'è nessun record, 
			//esegui istruzione
			if(!rst.first()) { 
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
            System.err.println(e.getMessage()); 
		}
				return false;	
		
	}

	
	public boolean registrazione(String user, String email, String password) {
		con=Dao.getConnection();
		int valoreIns=0;
		try {
			st=con.createStatement();
			valoreIns=st.executeUpdate("INSERT INTO `autosalone`.`utente` (`user`, `password`, `email`, `amministratore`) VALUES ('"+user+"', '"+password+"', '"+email+"' , '"+0+"');");
			if(valoreIns==0) {
				return true;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		  }
		return false;

	}

	
	public boolean controlloLogin(String user) {
		
		con=Dao.getConnection();
		try {
			st=con.createStatement();
			rst=st.executeQuery("Select user from autosalone.utente where user = '"+user+"';");
			if(!rst.first()) { 
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
            System.err.println(e.getMessage()); 
		}
				return true;	
	
	}

	
	public Utente login(String user,String password) {
		
		con=Dao.getConnection();
		try {
			st=con.createStatement();
			rst=st.executeQuery("Select user, email, password, amministratore from autosalone.utente where user = '"+user+"';");
			rst.first();
			String nome=rst.getString("user");
			String mail=rst.getString("email");
			String pass=rst.getString("password");
			String amm=rst.getString("amministratore");
			
			if(user.equals(nome) && pass.equals(password)){
				u= new Utente();
				u.setUser(user);
				u.setEmail(mail);
				u.setPassword(password);
				u.setAdmin(amm);
				return u;
			}
		
		}catch(SQLException e){
			e.printStackTrace();
            System.err.println(e.getMessage()); 
		}
		
		
		return u;
	}

	
	//ci deve restituire se è amministratore=1 o utente=0
	public boolean amministratore(String user) {
		
		con=Dao.getConnection();
		
		try {
			st=con.createStatement();
			rst=st.executeQuery("Select amministratore from autosalone.utente where user= '"+user+"'; ");
			rst.first();
			int adm=rst.getInt("amministratore");
			if(adm==0)
			{
				return false;
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return true;
		

	}



}
