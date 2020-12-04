package com.bankapp.webbeans;

public class DepositBeans {
	
	private int DeAccountId;
	private double DeAmount;
	public DepositBeans() {
	}
	public DepositBeans(int deAccountId, double DeAmount) {
		DeAccountId = deAccountId;
		this.DeAmount = DeAmount;
	}
	public int getDeAccountId() {
		return DeAccountId;
	}
	public void setDeAccountId(int deAccountId) {
		DeAccountId = deAccountId;
	}
	public double getDeAmount() {
		return DeAmount;
	}
	public void setAmount(double DeAmount) {
		this.DeAmount = DeAmount;
	}
	
	

}
