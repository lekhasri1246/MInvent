package mm.webapp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the itemgroup database table.
 * 
 */
@Entity
@NamedQuery(name="Itemgroup.findAll", query="SELECT i FROM Itemgroup i")
public class ItemgroupDisplay implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String IGName;

	public ItemgroupDisplay() {
	}


	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getIGName() {
		return this.IGName;
	}

	public void setIGName(String IGName) {
		this.IGName = IGName;
	}

}