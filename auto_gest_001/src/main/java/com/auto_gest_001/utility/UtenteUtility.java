package com.auto_gest_001.utility;

import com.auto_gest_001.model.Utente;

//In questa interfaccia ci sono tutti i metodi che utilizzerò per gestire Utente


public interface UtenteUtility {

	public boolean controlloRegistrazione(String user);
	public boolean registrazione(String user, String email, String password);
	public boolean controlloLogin(String user);
	public Utente login(String user, String password);
	public boolean amministratore(String user);
	
	
}
