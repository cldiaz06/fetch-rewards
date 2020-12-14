package com.cldiaz.fetchrewards.repository;

import java.util.HashMap;
import java.util.Map;

public class UserAcctMap {

	private Map<String, Integer> userAccts;
	
	public UserAcctMap() {
		this.userAccts = new HashMap<>(20);
	}
	
	
	public void put(String name, int balance) {
		if(userAccts.containsKey(name)) {
			userAccts.replace(name, balance);
		} else {
			userAccts.put(name, balance);
		}
	}
	
	public int getBalance(String name) {
		return userAccts.get(name);
	}
	
	public int getMapSize() {
		return userAccts.size();
	}
	
	public boolean containsKey(String name) {
		return userAccts.containsKey(name);
	}
	
	
	
}
