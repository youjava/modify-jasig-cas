package org.stackbox.darkportal.mechanism;

import org.jasig.cas.authentication.principal.Credentials;

public class DarkPortalCredentials implements Credentials {

	private String username;
	
	private String password;
	
	private String product;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "DarkPortalCredentials [username=" + username + ", password="
				+ password + ", product=" + product + "]";
	}
	
}
