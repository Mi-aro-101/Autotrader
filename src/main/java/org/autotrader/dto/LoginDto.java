/**
 * 
 */
package org.autotrader.dto;

/**
 * @author miaro
 *
 */
public class LoginDto {

	String email;
	String password;
	
	public LoginDto() {
		
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setEmail(String email)throws Exception {
		this.email = email;
	}
	
	public void setPassword(String password) throws Exception{
		this.password = password;
	}

}
