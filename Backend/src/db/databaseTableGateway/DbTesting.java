package db.databaseTableGateway;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import org.junit.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import Config.MySQL;
import db.dataMapper.DataMapperTest;
import db.dataMapper.User;

public class DbTesting {

	public static Logger logger = LogManager.getLogger(DataMapperTest.class);
	
	

	
	@Test
	public void SQLUpdatePassword(){
		
		UserTableGateway users= new UserTableGateway();
		String Result= users.UpdatePassword("456","test1", "1993-10-10");
		assertEquals(Result,"qinyue.yin@colorado.edu");
		assertEquals(users.GetPasswordTest("test1"),"456");
	}
	
	
	@Test
	public void SQLShowPassword(){
		
		UserTableGateway users= new UserTableGateway();
		String Result= users.GetPasswordTest("test1");
		//System.out.println(Result);
		assertEquals("123",Result);
	}
	
	
	@Test
	public void selectUsername()
	{
		UserTableGateway u1=new UserTableGateway();
		logger.info(u1.SelectUsername(1));
	}
	
	@Test
	public void updateEmail() throws SQLException
	{
		UserTableGateway u1=new UserTableGateway();
		assertEquals(true,u1.UpdateEmail(3, "test2@gmail.com"));
	}
//	@Test
	public void insertUser() throws SQLException
	{
		User u1=new User(1, "test8", "123", "student", "1928-09-12",
				"12345@gmail.com") ;
		UserTableGateway ug1=new UserTableGateway();
		int user_id=ug1.insertUserTable(u1);
		logger.info(user_id);

	}
	
	@Test
	public void findUserTest(){
		int user_id=1;
		User u2=new User(1, "test1", "456", "student", "1993-10-10",
				"test@gmail.com") ;
		UserTableGateway ug1=new UserTableGateway();
		User u1=ug1.findUser(user_id);
		assertEquals(u2.getBirthday(),u1.getBirthday());
		assertEquals(u2.getUsername(),u1.getUsername());
		assertEquals(u2.getUser_id(),u1.getUser_id());
		assertEquals(u2.getOccupation(),u1.getOccupation());
		assertEquals(u2.getPassword(),u1.getPassword());
		assertEquals(u2.getEmail(),u1.getEmail());
	}
}
