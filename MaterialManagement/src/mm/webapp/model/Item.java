package mm.webapp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int IGid;
	private String IName;
	private String unitsType;
	private double OpeningStock;
	private String Itemdesc;
	public Item() {
	}


	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getIGid() {
		return this.IGid;
	}

	public void setIGid(int IGid) {
		this.IGid = IGid;
	}


	public String getIName() {
		return this.IName;
	}

	public void setIName(String IName) {
		this.IName = IName;
	}


	public String getUnitsType() {
		return this.unitsType;
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