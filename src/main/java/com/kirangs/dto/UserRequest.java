package com.kirangs.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserRequest {

//	@NotNull(message = "user name required")   // valid input : ""
//	@NotEmpty(message = "user name required")  // valid input : " "
	@NotBlank(message = "user name required")  // valid input : "a"
	private String name;
	
	@Email(message = "please provide valid email address")
	private String email;
	
	@NotNull
	@Pattern(regexp = "^\\d{10}$", message = "please provide valid mobile number")
	private String mobile;
	
	private String gender;
	
	@Min(18)
	@Max(60)
	private Integer age;
	
	@NotBlank(message = "please provide nationality")
	private String nationality;

	public UserRequest() {
		super();
	}

	public UserRequest(String name, String email, String mobile, String gender, Integer age, String nationality) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.age = age;
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "UserRequest [name=" + name + ", email=" + email + ", mobile=" + mobile + ", gender=" + gender + ", age="
				+ age + ", nationality=" + nationality + "]";
	}

}
