package entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersQueries
{
	public static String searchUserByUserName(User userToCheck)
	{
		if (userToCheck == null)
			return null;
		String queryMsg = "SELECT * FROM obl_db.users WHERE userName ='" + userToCheck.getUserName()+"'";
		return queryMsg;
	}

	public static String searchUserByUserNameAndPass(User userToCheck)
	{
		if (userToCheck == null)
			return null;
		String queryMsg = "SELECT * FROM obl_db.users WHERE userName ='" + userToCheck.getUserName()
				+ "' AND password ='" + userToCheck.getPassWord() + "'";
		return queryMsg;
	}
	public static String createSubscriberUser(User userToAdd)
	{
		if (userToAdd == null)
			return null;
		String queryMsg ="INSERT INTO obl_db.users (`id`, `userName`, `password`, `firstName`, `lastName`,  `loginStatus`,`type`) "
				+ "VALUES ('"+userToAdd.getId()+"', '"+userToAdd.getUserName()+"', '"+userToAdd.getPassWord()
				+"', '"+userToAdd.getFirstName()+"', "+ "'"+userToAdd.getLastName()+"', 'off'"
						+ ",'"+userToAdd.getType()+"');";

		return queryMsg;
	}
	public static String updateUserloginStatus(User userToUpdate)
	{
		if (userToUpdate == null)
			return null;
		String queryMsg = "UPDATE obl_db.users SET loginStatus = '"+userToUpdate.getLoginStatus()+"' WHERE id = '"+userToUpdate.getId()+"'";
		return queryMsg;
	}

	public static User CreateUserFromRS(ResultSet rs)
	{
		User userToCreate = null;
		try
		{
			userToCreate = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7));

		} catch (Exception e)
		{
			e.printStackTrace();
		} 
		return userToCreate;
	}

	public static String searchUserByID(User userToCheck)
	{
		if (userToCheck == null)
			return null;
		String queryMsg = "SELECT * FROM obl_db.users WHERE id ='" + userToCheck.getId()+"'";
		return queryMsg;
	}
	
	public static String updateUserInformation(Subscriber subscriberToUpdate)
	{
		
		 String queryMsg ="UPDATE obl_db.users" +
				 "\nSET firstName='"+subscriberToUpdate.getFirstName()+"'," +  "lastName='"+subscriberToUpdate.getLastName()+"'"
				 +"\nWHERE id='"+subscriberToUpdate.getId() +"';";
		return queryMsg;
		
		
	}

	public static String getMessagesForUser(User user)
	{
		String queryMsg ="SELECT * FROM obl_db.messages WHERE (recipientUserType ='"+user.getType()+"' AND recipientUserId IS NULL ) "
				+ "OR recipientUserId ='"+user.getId()+"'";
		return queryMsg;
	}

	public static List<String> createMessagesLisrFromRS(ResultSet rs)
	{
		List<String> messages = new ArrayList<String>();
		try
		{
		while(rs.next())
		{
			String msg = rs.getString(2);
			msg +="!@#";//unique symbol for seperation string in client
			msg +=rs.getString(3);
			messages.add(msg);
		}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			messages = new ArrayList<String>();
		}
		return messages;
	}

}
