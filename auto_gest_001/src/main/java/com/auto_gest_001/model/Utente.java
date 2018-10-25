package com.auto_gest_001.model;

public class Utente {
	private int idUtente;
	private String user;
	private String password;
	private String email;
	private String admin;
	
	public Utente() {}
	
	public Utente(int idUtente, String user, String password, String email, String admin) {
		this.idUtente = idUtente;
		this.user = user;
		this.password = password;
		this.email = email;
		this.admin = admin;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String isAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

}
