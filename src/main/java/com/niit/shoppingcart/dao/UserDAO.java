package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.User;

public interface UserDAO {
	
	
public List<User>list();
	
	//To fetch the user on the basis of ID
	public User getUser(String id);
	
	// save method is used to create the User and Save.
	public boolean save(User user);
	
	// To update the User.
	public boolean update(User user);
	
	//delete user on the basis of UserID
	public boolean delete(String id);
	
	
	public boolean validate(String id, String password);

	
	

}
