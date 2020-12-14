package com.cldiaz.fetchrewards.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cldiaz.fetchrewards.domain.User;
import com.cldiaz.fetchrewards.domain.UserApiRequest;
import com.cldiaz.fetchrewards.repository.UserAcctMap;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserAcctMap userAcct;
	
	public UserServiceImpl() {
		this.userAcct = new UserAcctMap();
	}
	
	@Override
	public void addToBalance(UserApiRequest req) {
		User existingUser = getUserByName(req.getName());
		
		if(existingUser != null) {
			userAcct.put(existingUser.getName(), existingUser.getPoints() + req.getPoints());			
		} else {
			int balance =0;
			if(existingUser.getPoints() > 0) {
				balance = existingUser.getPoints();
			}
			
			userAcct.put(existingUser.getName(), existingUser.getPoints());
		}
		
		userAcct.viewMap();

	}

	@Override
	public User deductBalance(UserApiRequest req) {
		User existingUser = getUserByName(req.getName());
		User updatedUser = new User();
		int newBal = existingUser.getPoints() - req.getPoints();

		if(newBal < 0) {
			newBal = 0;
		}

		updatedUser.setName(existingUser.getName());
		updatedUser.setPoints(newBal);

		userAcct.put(updatedUser.getName(), updatedUser.getPoints());
		
		userAcct.viewMap();
		
		return updatedUser;
	}

	@Override
	public User getUserByName(String name) {
		User user = new User();
		user.setName(name);
		user.setPoints(userAcct.getBalance(name));
		userAcct.viewMap();
		return user;
	}

}
