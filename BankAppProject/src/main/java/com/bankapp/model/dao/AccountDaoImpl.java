package com.bankapp.model.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bankapp.model.exception.AccountNotFoundException;

@Repository
public class AccountDaoImpl implements AccountDao{

	private SessionFactory factory;
	
	@Autowired
	public AccountDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	private Session getSession() {
		System.out.println("----------------------------------------------------");
		return factory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAllAccounts() {
		return getSession().createQuery("from Account").getResultList();
	}


	public Account updateAccount(Account account) {
		 getSession().update(account);
		 return account;
	}

	@Override
	public Account delAccount(int accountId) {
		Account accountToDelete=getAccountById(accountId);
		getSession().delete(accountToDelete);
		return accountToDelete;
	}

	@Override
	public Account addAccount(Account account) {
	getSession().persist(account);
		return account;
	}

	@Override
	public Account getAccountById(int accountId) {
		Account account=getSession().get(Account.class, accountId);
		if(account==null)
		    throw new AccountNotFoundException("Account with id"+accountId+"is not found");
		else 
			return account;
		
	}

}
