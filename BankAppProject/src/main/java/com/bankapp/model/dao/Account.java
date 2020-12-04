package com.bankapp.model.dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;



@Entity
@Table(name="account_table",schema="public")
public class Account{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer accountId;
	private Integer adharCard;
	private String address;
	private AccountType accountType;
	private Double balance;
	private String email;
	private String name;
	private Integer phone;
	private String panNumber;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="account_fid")
    private List<TransactionLog> txlog=new ArrayList<>();

	private AccountStatus accstatus=AccountStatus.ACTIVE;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="account_fid")
	private List<User> user=new ArrayList<>();
	
	public Account() {
	}
	
	public Account(Integer adharCard, String address, AccountType accountType, Double balance, String email, String name,
			Integer phone, String panNumber) {
		this.adharCard = adharCard;
		this.address = address;
		this.accountType = accountType;
		this.balance = balance;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.panNumber = panNumber;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Integer getAdharCard() {
		return adharCard;
	}

	public void setAdharCard(int adharCard) {
		this.adharCard = adharCard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public AccountStatus getAccstatus() {
		return accstatus;
	}

	public void setAccstatus(AccountStatus accstatus) {
		this.accstatus = accstatus;
	}

	

}
