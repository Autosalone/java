package com.auto_gest_001.model;

import java.sql.Date;

//import java.util.Date;

public class Prenotazione {

	private int id_prenotazione;
	private Date data_prenotazione;
	private int id_utente;
	private int id_auto;
	
	
	
	public int getId_prenotazione() {
		return id_prenotazione;
	}
	public void setId_prenotazione(int id_prenotazione) {
		this.id_prenotazione = id_prenotazione;
	}
	public Date getData_prenotazione() {
		return data_prenotazione;
	}
	public void setData_prenotazione(Date data_prenotazione) {
		this.data_prenotazione = data_prenotazione;
	}
	public int getId_utente() {
		return id_utente;
	}
	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}
	public int getId_auto() {
		return id_auto;
	}
	public void setId_auto(int id_auto) {
		this.id_auto = id_auto;
	}	
	
}