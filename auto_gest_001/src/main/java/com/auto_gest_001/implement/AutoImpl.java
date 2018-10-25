package com.auto_gest_001.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.auto_gest_001.dao.Dao;
import com.auto_gest_001.model.Auto;
import com.auto_gest_001.utility.AutoUtility;

public class AutoImpl implements AutoUtility {
	
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rst = null;
	
	ArrayList<Auto> arrayAuto = new ArrayList<Auto>();
	Auto auto;
	
	/* (non-Javadoc)
	 * @see com.auto_gest_001.implement.AutoUtility#select()
	 */
	public ArrayList<Auto> select() {
		
		conn = Dao.getConnection();
		String x = null;
		String y = null;
		try {
			st = conn.createStatement();
			rst = st.executeQuery("SELECT casa_prod,modello from auto group by casa_prod order by casa_prod");
			rst.first();
			while(rst.next()) {
				Auto auto = new Auto();
				
				y = rst.getString(1);
				auto.setCasaProduttrice(y);
				
				x = rst.getString(2);
				auto.setModello(x);
				
				arrayAuto.add(auto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayAuto;
	}
	
	
	
	// metodo ritorna auto, setCasa setModello ;
	
	/* (non-Javadoc)
	 * @see com.auto_gest_001.implement.AutoUtility#getAuto()
	 */
	public Auto getAuto() {
		auto = new Auto();
		String x = null;
		String y = null;
		
		conn = Dao.getConnection();
		try {
			st = conn.createStatement();
			rst = st.executeQuery("SELECT casa_prod,modello from auto order by casa_prod");
			rst.first();
			x = rst.getString(1);
			y = rst.getString(2);
			auto.setCasaProduttrice(x);
			auto.setModello(y);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return auto;
		
	}
	
}
