package com.cldiaz.fetchrewards.services;

import com.cldiaz.fetchrewards.domain.User;
import com.cldiaz.fetchrewards.domain.UserApiRequest;

public interface UserService {

	public void addToBalance(UserApiRequest req);
	
	public User deductBalance(UserApiRequest req);
	
	public User getUserByName(String name);
}
