package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.dao.Account;

public interface AccountService {

	List<Account> getAllAccounts();
	public Account updateAccount(Account account);
	public Account  delAccount(int accountId);
	public Account addAccount(Account account);
	public Account getAccountById(int accountId);
	public void  depositMoney(int accountId,double amount);
	public void  withdrawMoney(int accountId,double amount);
	public void  transferMoney(int fromaccountId,int toAccountId,Double amount);
	
}
