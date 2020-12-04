package com.bankapp.model.dao;
import java.util.*;
public interface TransactionLogDao {

	public TransactionLog addTransactionLog(int accountId,String txInfo, Double amount, TxType txtype);
	public List<TransactionLog> getAllTransactionLogs();
	public List<TransactionLog> getTransactionLogFromAnAccount();
	
	
}
