package com.cldiaz.fetchrewards.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cldiaz.fetchrewards.domain.UserApiRequest;
import com.cldiaz.fetchrewards.domain.UserApiResponse;
import com.cldiaz.fetchrewards.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public void  addBalance(UserApiRequest request) {
		userService.addToBalance(request);
	}
	
	@DeleteMapping("/deduct")
	public UserApiResponse deductBalance(UserApiRequest request) {
		UserApiResponse response = new UserApiResponse();
		
		response.setName(request.getName());
		response.setPoints(request.getPoints());
		response.setUser(userService.deductBalance(request));
		response.setTransactionDate(new Date());
		
		return response;
	}
	
}
