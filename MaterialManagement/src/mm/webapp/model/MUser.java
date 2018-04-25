package mm.webapp.model;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * The persistent class for the musers database table.
 * 
 */
@Entity
@Table(name="musers")

public class MUser  {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "administrationPref" , length = 1)
	private Boolean administrationPref;
	
	@Column(name = "displayPref" , length = 1)
	private Boolean displayPref;
	
	@Column(name = "password" , length = 50)
	private String password;
	
	@Column(name = "tranasctionPref" , length = 1)
	private Boolean tranasctionPref;
	
	@Column(name = "username" , length = 50)
	private String username;
	
	@Column(name = "voucherPermissionDelete" , length = 1)
	private Boolean voucherPermissionDelete;
	
	@Column(name = "voucherPermissionModify" , length = 1)
	private Boolean voucherPermissionModify;

	public MUser() {
	}


	public String toString() 
	{
		return ToStringBuilder.reflectionToString(this);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}




	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Boolean getAdministrationPref() {
		return administrationPref;
	}


	public void setAdministrationPref(Boolean administrationPref) {
		this.administrationPref = administrationPref;
	}


	public Boolean getDisplayPref() {
		return displayPref;
	}


	public void setDisplayPref(Boolean displayPref) {
		this.displayPref = displayPref;
	}


	public Boolean getTranasctionPref() {
		return tranasctionPref;
	}


	public void setTranasctionPref(Boolean tranasctionPref) {
		this.tranasctionPref = tranasctionPref;
	}


	public Boolean getVoucherPermissionDelete() {
		return voucherPermissionDelete;
	}


	public void setVoucherPermissionDelete(Boolean voucherPermissionDelete) {
		this.voucherPermissionDelete = voucherPermissionDelete;
	}


	public Boolean getVoucherPermissionModify() {
		return voucherPermissionModify;
	}


	public void setVoucherPermissionModify(Boolean voucherPermissionModify) {
		this.voucherPermissionModify = voucherPermissionModify;
	}



}