package com.springboot.dao;

import com.springboot.Repository.UserRepository;
import com.springboot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean saveUser(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            log.error("Error in saveUser() method ", e);
        }
        return false;
    }

    @Override
    public User findByEmailId(String email) {
        try {
            return userRepository.findByEmail(email);

        } catch (Exception e) {
            log.error("Error in findByEmailId() method !! ", e);
        }
        return null;
    }

    @Override
    public User findUserByAadhaarCardAndPanCard(String aadhaarCard, String panCard) {
        try {
            return userRepository.findUserBYAadhaarCardAndAndPanCard(aadhaarCard, panCard);
        } catch (Exception e) {
            log.error("Error in findByAadhaarCardAndPanCard() method !!", e);
        }
        return null;
    }

    @Override
    public boolean isValidUser(String userName, String password) {
        boolean success=false;
        try{
            User user=userRepository.validUser(userName,password);
            if(user!=null){
                success=true;
            }
        }catch (Exception e){
            log.error("Error in isValidUser() method !!",e);
        }
        return success;
    }

    @Override
    public User findByUserName(String name) {
        try {
            return userRepository.findUserByUserName(name);

        } catch (Exception e) {
            log.error("Error in findByUserName() method !! ", e);
        }
        return null;    }

    @Override
    public User findByCountry(String country) {
        try {
            return userRepository.findUserByCountry(country);

        } catch (Exception e) {
            log.error("Error in findByCountry() method !! ", e);
        }
        return null;    }

    @Override
    public User findByState(String state) {
        try {
            return userRepository.findUserByState(state);

        } catch (Exception e) {
            log.error("Error in findByEmailId() method !! ", e);
        }
        return null;
    }

}
