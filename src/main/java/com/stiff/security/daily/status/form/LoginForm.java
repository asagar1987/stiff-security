package com.stiff.security.daily.status.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class LoginForm
{
	
	@NotEmpty(message="Please enter username")
	private String username;
	
	@NotEmpty(message="Please enter password")
	private String password;
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	
	
}
