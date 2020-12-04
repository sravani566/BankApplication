package com.bankapp.model.dao;
import java.util.*;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer uid;
	private String username;
	private String password;
	
	@CollectionTable(name="roles")
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> roles=new ArrayList<>();
	private String address;
	private String phone;
	private String email;
	


	public User() {	}

	public User(String username, String password, List<String> roles, String address, String phone, String email
			) {
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.address = address;
		this.phone = phone;
		this.email = email;
		
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
