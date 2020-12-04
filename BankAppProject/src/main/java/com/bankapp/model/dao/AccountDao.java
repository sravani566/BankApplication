package com.bankapp.model.dao;

import java.util.*;
public interface AccountDao {

	List<Account> getAllAccounts();
	public Account updateAccount(Account account);
	public Account delAccount(int accountId);
	public Account addAccount(Account account);
	public Account getAccountById(int accountId);
}
