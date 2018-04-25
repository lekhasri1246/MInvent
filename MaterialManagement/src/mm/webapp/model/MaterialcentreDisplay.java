package mm.webapp.model;
import java.math.BigDecimal;
import org.apache.commons.lang3.builder.*;

public class MaterialcentreDisplay {
	private int id;

	private String address;

	private String name;

	private String stock_Account;

	private String transfered;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStock_Account() {
		return stock_Account;
	}

	public void setStock_Account(String stock_Account) {
		this.stock_Account = stock_Account;
	}

	public String getTransfered() {
		return transfered;
	}

	public void setTransfered(String transfered) {
		this.transfered = transfered;
	}

}
