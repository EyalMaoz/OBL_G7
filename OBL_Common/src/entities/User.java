package entities;

import java.io.Serializable;

public class User implements Serializable
{
	private String id = null;
	private String userName = null;
	private String password = null;
	private String firstName = null;
	private String lastName = null;
	private String loginStatus = null;
	private String  type= null;

	public User(String idNum, String name, String pass, 
			String first, String last, String status, String userType)
	{

		id = idNum;
		userName = name;
		password = pass;
		firstName = first;
		lastName = last;
		loginStatus = status;
		type = userType;
	}

	public User(String name, String pass)
	{
		userName = name;
		password = pass;
	}

	public String getPassWord()
	{
		return password;
	}

	public void setPassWord(String passWord)
	{
		this.password = passWord;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getLoginStatus()
	{
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus)
	{
		this.loginStatus = loginStatus;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

}