package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the materialcentre database table.
 * 
 */
@Entity
@NamedQuery(name="Materialcentre.findAll", query="SELECT m FROM Materialcentre m")
public class Materialcentre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String address;

	private String name;

	private String stock_Account;

	private String transfered;

	public Materialcentre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStock_Account() {
		return this.stock_Account;
	}

	public void setStock_Account(String stock_Account) {
		this.stock_Account = stock_Account;
	}

	public String getTransfered() {
		return this.transfered;
	}

	public void setTransfered(String transfered) {
		this.transfered = transfered;
	}

}