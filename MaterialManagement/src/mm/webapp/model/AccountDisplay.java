package mm.webapp.model;
import java.math.BigDecimal;
import org.apache.commons.lang3.builder.*;

public class AccountDisplay {
	private static final long serialVersionUID = 1L;
	private int id;
	private String address;
	private String AName;
	private int GId;
	private int openBalance;
	private String phone;
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAName() {
		return AName;
	}

	public void setAName(String aName) {
		AName = aName;
	}

	public int getGId() {
		return GId;
	}

	public void setGId(int gId) {
		GId = gId;
	}

	public int getOpenBalance() {
		return openBalance;
	}

	public void setOpenBalance(int openBalance) {
		this.openBalance = openBalance;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
