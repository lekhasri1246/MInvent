package mm.webapp.model;

import java.io.Serializable;
import javax.persistence.*;


public class ItemDisplay {
	private int id;
	private int IGid;
	private String IName;
	private String unitsType;
	private double OpeningStock;
	private String Itemdesc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIGid() {
		return IGid;
	}
	public void setIGid(int iGid) {
		IGid = iGid;
	}
	public String getIName() {
		return IName;
	}
	public void setIName(String iName) {
		IName = iName;
	}
	public String getUnitsType() {
		return unitsType;
	}
	public void setUnitsType(String unitsType) {
		this.unitsType = unitsType;
	}
	public double getOpeningStock() {
		return OpeningStock;
	}
	public void setOpeningStock(double openingStock) {
		OpeningStock = openingStock;
	}
	public String getItemdesc() {
		return Itemdesc;
	}
	public void setItemdesc(String itemdesc) {
		Itemdesc = itemdesc;
	}

}
