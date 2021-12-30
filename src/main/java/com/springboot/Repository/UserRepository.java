package com.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>{
    @Query("select u from User u where u.email=?1")
    User findByEmail(String lastname);
    @Query("select u from User u where u.aadhaarCard=?1 and u.panCard=?2 ")
    User findUserBYAadhaarCardAndAndPanCard(String aadhaarCardNumber,String panCard);
    @Query("select u from User u where u.name=?1 and u.password=?2")
    User validUser(String userName,String password);
    @Query("select u from User u where u.country=?1")
    User findUserByCountry(String country);
    @Query("select u from User u where u.state=?1")
    User findUserByState(String state);
    @Query("select u from User u where u.name=?1")
    User findUserByUserName(String name);



}
