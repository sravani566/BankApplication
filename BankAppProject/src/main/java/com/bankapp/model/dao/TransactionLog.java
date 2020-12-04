package com.bankapp.model.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="transactionlog_table")
public class TransactionLog {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer txId;
	private String txInfo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;
	private Double amount;
	@Enumerated(EnumType.STRING)
	private TxType txtype;
	public TransactionLog() {}
	public TransactionLog(Double amount, TxType txtype) {
		this.timeStamp=new Date();
		this.amount = amount;
		this.txtype = txtype;
	}
	
	public TransactionLog(String txInfo, Double amount, TxType txtype) {
		this.txInfo = txInfo;
		this.amount = amount;
		this.txtype = txtype;
	}
	public Integer getTxId() {
		return txId;
	}
	public void setTxId(Integer txId) {
		this.txId = txId;
	}
	public String getTxInfo() {
		return txInfo;
	}
	public void setTxInfo(String txInfo) {
		this.txInfo = txInfo;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public TxType getTxtype() {
		return txtype;
	}
	public void setTxtype(TxType txtype) {
		this.txtype = txtype;
	}
	
	
	
}
