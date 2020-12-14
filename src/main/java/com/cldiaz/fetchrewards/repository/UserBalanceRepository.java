package com.cldiaz.fetchrewards.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cldiaz.fetchrewards.domain.User;

@Repository
public interface UserBalanceRepository extends CrudRepository<Long, User> {

	public User findUserByName(String name);

	public void save(User user);

}
