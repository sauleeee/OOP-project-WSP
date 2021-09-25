package wsp;

import java.io.Serializable;
import java.util.Objects;


public abstract class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2373638228737755717L;
	protected String login;
	protected String password;
	protected String firstName;
	protected String lastName;
	Type type;
	
	User(){}
	public User(String login, String password, String firstName, String lastName) {
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String toString() {
		return  this.login + "  first name: " + this.firstName + "  last name:" + this.lastName;
	}

	public int hashCode() {
		return super.hashCode() + Objects.hash(firstName,lastName,login);
	}
	public boolean equals(Object o) {
		if(o == this) return true;
		if(o == null) return false;
		if(this.getClass()!= o.getClass()) return false;
		User u  = (User)o;
		return this.firstName == u.firstName && this.lastName == u.lastName && this.login.equals(u.login);	
	}
}


