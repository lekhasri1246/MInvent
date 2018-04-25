package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String address;
	private String AName;
	private int openBalance;
	private String phone;
	private Accountgroup accountgroup;

	public Account() {
	}


	@Id
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


	public String getAName() {
		return this.AName;
	}

	public void setAName(String AName) {
		this.AName = AName;
	}


	public int getOpenBalance() {
		return this.openBalance;
	}

	public void setOpenBalance(int openBalance) {
		this.openBalance = openBalance;
	}


	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	//bi-directional many-to-one association to Accountgroup
	@ManyToOne
	@JoinColumn(name="GId")
	public Accountgroup getAccountgroup() {
		return this.accountgroup;
	}

	public void setAccountgroup(Accountgroup accountgroup) {
		this.accountgroup = accountgroup;
	}

}