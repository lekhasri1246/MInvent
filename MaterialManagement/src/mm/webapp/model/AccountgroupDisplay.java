package mm.webapp.model;
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the accountgroup database table.
 * 
 */
@Entity
@NamedQuery(name="Accountgroup.findAll", query="SELECT a FROM Accountgroup a")
public class AccountgroupDisplay {
	private int id;
	private String GName;
	private String GType;

	public AccountgroupDisplay() {
	}


	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getGName() {
		return this.GName;
	}

	public void setGName(String GName) {
		this.GName = GName;
	}


	public String getGType() {
		return this.GType;
	}

	public void setGType(String GType) {
		this.GType = GType;
	}


}
