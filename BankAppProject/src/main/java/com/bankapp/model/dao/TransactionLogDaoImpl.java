package com.bankapp.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionLogDaoImpl implements TransactionLogDao{

private SessionFactory factory;
	
	@Autowired
	public TransactionLogDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	private Session getSession() {
		return factory.getCurrentSession();
	}
	@Override
	public TransactionLog addTransactionLog(int accountId,String txInfo, Double amount, TxType txtype) {
		TransactionLog log=new TransactionLog(txInfo, amount, txtype);
		 getSession().save(log);
		return log;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionLog> getAllTransactionLogs() {
		
		return getSession().createQuery("from TransactionLog").list();
	}

	@Override
	public List<TransactionLog> getTransactionLogFromAnAccount() {
		return null;
	}

}
