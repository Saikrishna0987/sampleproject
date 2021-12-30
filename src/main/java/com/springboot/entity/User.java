package com.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int id;
	@Column(name = "email_id", nullable = true,unique=true)
	private String email;
	@Column(nullable = true)
	private String password;
	@Column(nullable = true, name = "confrim_password")
	private String confirmPassword;
	@Column(nullable = true, name = "full_name")
	private String name;
	@Column(nullable = true)
	private String country;
	@Column(nullable = true)
	private String state;
	@Column(nullable = true)
	private String district;
	@Column(name = "pin_code", nullable = true)
	private Integer pinCode;
	@Column(name = "adhar_card", nullable = true)
	private String aadhaarCard;
	@Column(name = "pan_card", nullable = true)
	private String panCard;
	@Column(nullable = true)
	private String city;
	@Column(name = "mobile_no", nullable = false)
	private Long mobileNumber;
	@Column(name = "user_type", nullable = true)
	private String userType;

}
