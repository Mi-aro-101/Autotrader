/**
 * 
 */
package org.autotrader.dto;

/**
 * @author miaro
 *
 */
public class SignupDto {

	String email;
	String password;
	
	public SignupDto() {}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
