package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

import junit.framework.Assert;

public class UserTestCase {

	
	@Autowired
	private static AnnotationConfigApplicationContext  context;
	
	@Autowired
    private static User user;
	
	@Autowired
	private static UserDAO userDAO;
	
	
	
	//Previously we written constructor
	//But in JUnit we need to write a method
	//this method should call automatically when JUnit Test case run
	//we can write @BeforeClasses only for the static methods
	
	@BeforeClass    
	public static void initialize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		 user = (User) context.getBean("user");
		
		 userDAO = (UserDAO) context.getBean("userDAO");
		 
	}
	
	
	
	
	@Test
	public void TestCreateUser()
	{
		user.setId("niit");
		user.setName("niit");
		user.setPassword("niit123");
		user.setEmail("niit@gmail.com");
		user.setPhone("999999999");
		user.setRole("Role_Admin");
		
		boolean flag= userDAO.save(user);
		
		Assert.assertEquals("create UserTestCase",true, flag);
	}
	
	@Test
	public void validateCredentialsTestCase()
	{
		boolean flag = userDAO.validate("niit", "niit123");
		
		Assert.assertEquals( "validateCredentialsTestCase",true, flag);
	}
}
