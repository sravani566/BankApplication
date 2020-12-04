package com.bankapp.webbeans;

public class WithdrawBeans {

	private int wdAccountId;
	private double wdAmount;
	public WithdrawBeans() {
	}
	public WithdrawBeans(int wdAccountId, double wdAmount) {
		this. wdAccountId=  wdAccountId;
		this.wdAmount = wdAmount;
	}
	public int getWdAccountId() {
		return  wdAccountId;
	}
	public void setWdAccountId(int  wdAccountId) {
		 wdAccountId =  wdAccountId;
	}
	public double getWdAmount() {
		return wdAmount;
	}
	public void setWdAmount(double wdAmount) {
		this.wdAmount = wdAmount;
	}
	
}
