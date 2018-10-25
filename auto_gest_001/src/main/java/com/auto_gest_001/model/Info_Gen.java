package com.auto_gest_001.model;

public class Info_Gen {

	private int id_info_gen = 0;
	private double km = 0.0;
	private double prezzo = 0.0;
	private String alimentazione = "";
	private int cilindrata = 0;
	private String cambio = "";
	private int n_porte = 0;
	private int n_posti = 0;
	private String stato = "";
	
	
	public int getId_info_gen() {
		return id_info_gen;
	}
	public void setId_info_gen(int id_info_gen) {
		this.id_info_gen = id_info_gen;
	}
	public double getKm() {
		return km;
	}
	public void setKm(double km) {
		this.km = km;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getAlimentazione() {
		return alimentazione;
	}
	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}
	public int getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}
	public String getCambio() {
		return cambio;
	}
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	public int getN_porte() {
		return n_porte;
	}
	public void setN_porte(int n_porte) {
		this.n_porte = n_porte;
	}
	public int getN_posti() {
		return n_posti;
	}
	public void setN_posti(int n_posti) {
		this.n_posti = n_posti;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
}
