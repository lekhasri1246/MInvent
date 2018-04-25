package mm.webapp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the munits database table.
 * 
 */
@Entity
@Table(name="munits")
@NamedQuery(name="Munit.findAll", query="SELECT m FROM Munit m")
public class Munit  {
	
	private int id;
	private String comments;
	private String name;

	public Munit() {
	}


	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}