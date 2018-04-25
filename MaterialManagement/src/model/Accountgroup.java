package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the accountgroup database table.
 * 
 */
@Entity
@NamedQuery(name="Accountgroup.findAll", query="SELECT a FROM Accountgroup a")
public class Accountgroup implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String GName;
	private String GType;
	private List<Account> accounts;

	public Accountgroup() {
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


	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="accountgroup")
	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setAccountgroup(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setAccountgroup(null);

		return account;
	}

}