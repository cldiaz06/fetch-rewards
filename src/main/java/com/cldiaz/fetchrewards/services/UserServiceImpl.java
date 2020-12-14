package com.cldiaz.fetchrewards.services;

import org.springframework.stereotype.Service;

import com.cldiaz.fetchrewards.domain.User;
import com.cldiaz.fetchrewards.domain.UserApiRequest;

@Service
public class UserServiceImpl implements UserService {

	
	
	@Override
	public void addToBalance(UserApiRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public User deductBalance(UserApiRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
