package com.cldiaz.fetchrewards.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
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
	
	public void viewMap() {
		System.out.println("*****Names/Point balances****");
		for(String name: userAccts.keySet()) {
			System.out.println(name + ": " + userAccts.get(name));
		}
		System.out.println("************************************");
	}
	
	
	
}
