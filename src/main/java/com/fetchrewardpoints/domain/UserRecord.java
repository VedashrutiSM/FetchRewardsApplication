package com.fetchrewardpoints.domain;


public class UserRecord {

	private String payerName;
	private int points;
	private String transactionDate;

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public UserRecord() {
	}

	public UserRecord(String payerName, int points, String transactionDate) {
		super();
		this.payerName = payerName;
		this.points = points;
		this.transactionDate = transactionDate;
	}
	
	@Override
	public String toString() {
		return "UserRecord [payerName=" + payerName + ", points=" + points + ", transactionDate=" + transactionDate 
				+ "]";
	}

}
