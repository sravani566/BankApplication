package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.dao.TransactionLog;
import com.bankapp.model.dao.TxType;

public interface TransactionLogService {

	public TransactionLog addTransactionLog(int accountId,String txInfo, Double amount, TxType txtype);
	public List<TransactionLog> getAllTransactionLogs();
	public List<TransactionLog> getTransactionLogFromAnAccount();
}
