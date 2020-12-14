package com.cldiaz.fetchrewards.domain;

import java.util.Date;

import javax.persistence.Entity;

public class UserApiRequest {

	private String name;
	private int points;
	private Date transactionDate;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}



}