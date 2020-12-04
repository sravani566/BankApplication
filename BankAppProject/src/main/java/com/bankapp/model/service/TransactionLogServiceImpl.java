package com.bankapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.TransactionLog;
import com.bankapp.model.dao.TransactionLogDao;
import com.bankapp.model.dao.TxType;

@Service
@Transactional
public class TransactionLogServiceImpl implements TransactionLogService{
	private TransactionLogDao transactionlogdao;
	
  @Autowired
	public TransactionLogServiceImpl(TransactionLogDao transactionlogdao) {
		this.transactionlogdao = transactionlogdao;
	}

	@Override
	public TransactionLog addTransactionLog(int accountId,String txInfo, Double amount, TxType txtype) {
		
		return transactionlogdao.addTransactionLog(accountId,txInfo, amount, txtype);
	}

	@Override
	public List<TransactionLog> getAllTransactionLogs() {
		
		return null;
	}

	@Override
	public List<TransactionLog> getTransactionLogFromAnAccount() {
		
		return null;
	}

}
