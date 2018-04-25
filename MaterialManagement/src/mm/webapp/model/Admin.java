package mm.webapp.model;

import javax.persistence.*;
import org.apache.commons.lang3.builder.*;

/**
 * ORM mapped class that keeps records of Administrator usernames and passwords in the database.
*/


@Entity
@Table(name = "admins")
public class Admin
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "username" , length = 50)
	String userName;
	
	@Column(name = "password" , length = 50)
	String password;
	
	@Column(name="IP",length=50)
	String IP;
	
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}


}