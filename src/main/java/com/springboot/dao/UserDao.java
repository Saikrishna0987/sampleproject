package com.springboot.dao;

import com.springboot.entity.User;

import java.util.List;

public interface UserDao {

	boolean saveUser(User user);
	User findByEmailId (String email);
	User findUserByAadhaarCardAndPanCard(String aadhaarCard,String panCard);
	boolean isValidUser(String userName,String password);
	User findByUserName(String name);
	User findByCountry(String country);
	User findByState(String state);
}
