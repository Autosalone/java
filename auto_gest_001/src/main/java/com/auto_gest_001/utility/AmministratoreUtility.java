package com.auto_gest_001.utility;

import com.auto_gest_001.model.Auto;
import com.auto_gest_001.model.Info_Gen;

public interface AmministratoreUtility {
	
	public void addAuto(Auto a, Info_Gen g);
	
	public void removeAuto(Auto a);
	
	public void setPrezzo(Auto a, double prezzo);

}
