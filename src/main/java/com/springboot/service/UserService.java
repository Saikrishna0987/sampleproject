package com.springboot.service;

import com.springboot.UserUtility;
import com.springboot.dao.UserDaoImpl;
import com.springboot.entity.User;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserDaoImpl userDao;

    public String createUser(JSONObject jsonObject) {
        try {

            String email = jsonObject.getString("email");
            String password = jsonObject.getString("password");
            String confirmPassword = jsonObject.getString("confirmPassword");
            String name = jsonObject.getString("name");
            String country = jsonObject.getString("country");
            String state = jsonObject.getString("state");
            String district = jsonObject.getString("district");
            Integer pincode = jsonObject.getInt("pincode");
            String adharCard = jsonObject.getString("adharCard");
            String pancard = jsonObject.getString("pancard");
            String city = jsonObject.getString("city");
            Long mobileNumber = jsonObject.getLong("mobileNumber");
            String userType = jsonObject.getString("userType");

            if ((!password.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
                    && !email.matches("^(.+)@(.+)$")) && confirmPassword.equals(password)) {
                return "Invalid email Details";
            }

            if (!pincode.toString().matches("^[1-9]{1}[0-9]{5}$")) {
                return "Enter valid Pincode";
            }
            if (!pancard.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
                return "Enter Valid Pancard";
            }
            if (!mobileNumber.toString().matches("^\\d{10}$")) {
                return "Enter Valid mobile number";
            }

            if (adharCard.matches("^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$")) {
                return "Enter valid Aadhaar card number";
            }

            User user = new User();
            user.setAadhaarCard(adharCard);
            user.setCity(city);
            user.setCountry(country);
            user.setDistrict(district);
            user.setEmail(email);
            user.setMobileNumber(mobileNumber);
            user.setName(name);
            user.setPanCard(pancard);
            user.setPinCode(pincode);
            user.setState(state);
            user.setUserType(userType);
            user.setPassword(UserUtility.base64Encoder(password));
            user.setConfirmPassword(UserUtility.base64Encoder(confirmPassword));
            if (userDao.saveUser(user)) {
                return user.getId() + "is created Successfully";

            } else {
                return "failed to create user!!!";
            }

        } catch (Exception e) {
            log.error("Error in createUser() method !!", e);
        }
        return null;
    }

    public JSONObject getUserBasedOnEmail(String email) {
        JSONObject object = new JSONObject();
        try {
            User list = userDao.findByEmailId(email);
            object.put("response", list);

        } catch (Exception e) {
            log.error("Error in getUser() method !!", e);
        }
        return object;
    }

    public JSONObject getUserBasedOnAadhaarCardAndPanCard(String aadhaarCard, String panCard) {
        JSONObject object = new JSONObject();
        try {
            User list = userDao.findUserByAadhaarCardAndPanCard(aadhaarCard, panCard);
            object.put("response", list);

        } catch (Exception e) {
            log.error("Error in getUserBasedOnAadhaarCardAndPanCard() method !!", e);
        }
        return object;

    }

    public String validateUser(String userName, String password) {
        JSONObject jsonObject = new JSONObject();
        try {
            boolean validUser = userDao.isValidUser(userName, password);
            if (validUser) {
                jsonObject.put("status", "success");
                jsonObject.put("response", "successfully login");
            } else {
                jsonObject.put("status", "failure");
                jsonObject.put("response", "invalid  login credentials");
            }

        } catch (Exception e) {
            log.error("Error in validateUser() method !!", e);
        }
        return jsonObject.toString();
    }

    public JSONObject getUserBasedonName(String userName) {
        JSONObject object = new JSONObject();
        try {
            User list = userDao.findByUserName(userName);
            object.put("response", list);

        } catch (Exception e) {
            log.error("Error in getUserBasedonName() method !!", e);
        }
        return object;
    }

    public JSONObject getUserBasedonCountry(String country) {
        JSONObject object = new JSONObject();
        try {
            User list = userDao.findByCountry(country);
            object.put("response", list);

        } catch (Exception e) {
            log.error("Error in getUserBasedonCountry() method !!", e);
        }
        return object;
    }

    public JSONObject getUserBasedonstate(String state) {
        JSONObject object = new JSONObject();
        try {
            User list = userDao.findByState(state);
            object.put("response", list);

        } catch (Exception e) {
            log.error("Error in getUserBasedonstate() method !!", e);
        }
        return object;
    }
}
