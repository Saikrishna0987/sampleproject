package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.service.UserService;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/sai")
@Slf4j
public class RestController {
	@Autowired
	private UserService userService;

	@PostMapping("/adduser")
	public String createUser(@RequestBody JSONObject jsonObject) {
		String response = null;
		try {
			response = userService.createUser(jsonObject);
		} catch (Exception e) {
			log.error("Error in createUser() method !!", e);
		}
		return response;

	}
	@PostMapping("/get-user")
	public ResponseEntity<JSONObject> findUserBasedOnEmailAddress(@RequestParam String mail){
		JSONObject object=null;
		try{
			object =userService.getUserBasedOnEmail(mail);

		}catch (Exception e){
			log.error("Error in searchUser() method !!",e);
		}
		return new ResponseEntity<>(object, HttpStatus.OK);
	}
	@PostMapping("/get-user/{aadhaarCard}/{panCard}")
	public ResponseEntity<JSONObject> searchUserBasedOnAadhaarCardAndPanCard(@RequestParam String aadhaarCard,@RequestParam String panCard){

		JSONObject object=null;
		try{
			object =userService.getUserBasedOnAadhaarCardAndPanCard(aadhaarCard,panCard);

		}catch (Exception e){
			log.error("Error in searchUser() method !!",e);
		}
		return new ResponseEntity<>(object, HttpStatus.OK);
	}
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestParam String userName,@RequestParam String password)
	{
		String response="";
		try{
			response=userService.validateUser(userName,password);
		}catch (Exception e){
			log.error("Error in loginUser() method !!",e);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@PostMapping("/email")
	public ResponseEntity<JSONObject> getUserByEmail(@RequestParam String emailId){
		JSONObject object=null;
		try{
			object=userService.getUserBasedOnEmail(emailId);

		}catch (Exception e){
			log.error("Error in getUserByEmail() method !!",e);
		}
		return new ResponseEntity<>(object,HttpStatus.OK);
	}
	@PostMapping("/userName")
	public ResponseEntity<JSONObject>getUserByUserName(@RequestParam String userName){
		JSONObject object=null;
		try{
			object=userService.getUserBasedonName(userName);

		}catch (Exception e){
			log.error("Error in getUserByUserName() method !!",e);
		}
		return new ResponseEntity<>(object,HttpStatus.OK);
	}
	@PostMapping("/country")
	public ResponseEntity<JSONObject>getUserByCountry(@RequestParam String country){
		JSONObject object=null;
		try{
			object=userService.getUserBasedonCountry(country);

		}catch (Exception e){
			log.error("Error in getUserByCountry() method !!",e);
		}
		return new ResponseEntity<>(object,HttpStatus.OK);
	}
	@PostMapping("/state")
	public ResponseEntity<JSONObject>getUserByState(@RequestParam String state){
		JSONObject object=null;
		try{
			object=userService.getUserBasedonstate(state);

		}catch (Exception e){
			log.error("Error in getUserByState() method !!",e);
		}
		return new ResponseEntity<>(object,HttpStatus.OK);
	}


}
