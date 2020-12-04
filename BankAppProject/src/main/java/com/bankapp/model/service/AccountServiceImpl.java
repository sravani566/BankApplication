package com.bankapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService{
	
	private AccountDao accountDao;
	@SuppressWarnings("unused")
	private TransactionLogService transactionallogservice;
	
	@Autowired
	public AccountServiceImpl(AccountDao accountdao, TransactionLogService transactionallogservice) {
		this.accountDao = accountdao;
		this.transactionallogservice = transactionallogservice;
	}

	@Override
	public List<Account> getAllAccounts() {
		
		return accountDao.getAllAccounts();
	}

	

	@Override
	public Account updateAccount(Account account) {
		return accountDao.updateAccount(account);
	}

	@Override
	public Account delAccount(int accountId) {
		
		return accountDao.delAccount(accountId);
	}

	@Override
	public Account addAccount(Account account) {
		
		return accountDao.addAccount(account);
	}

	@Override
	public Account getAccountById(int accountId) {
		return accountDao.getAccountById(accountId);
	}

	@Override
	public void depositMoney(int accountId, double amount) {
		Account accountdeposit=getAccountById(accountId);
		accountdeposit.setBalance(accountdeposit.getBalance()+amount);
		accountDao.updateAccount(accountdeposit);
//		transactionallogservice.addTransactionLog(accountId,"depositing", 500.67, TxType.DEPOSIT);
		
	}

	@Override
	public void withdrawMoney(int accountId, double amount) {
		Account accountwithdraw=getAccountById(accountId);
		accountwithdraw.setBalance(accountwithdraw.getBalance()-amount);
		accountDao.updateAccount(accountwithdraw);
	}

	@Override
	public void transferMoney(int fromaccountId, int toaccountId, Double amount) {
		withdrawMoney(fromaccountId,amount);
		depositMoney(toaccountId,amount);
	}

}
