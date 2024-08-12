package com.tejaswi.user.service.userServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejaswi.user.Repo.UserRepo;
import com.tejaswi.user.entity.User;
import com.tejaswi.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public User createUser(User user) {
		System.out.println(user);

		String id = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
		user.setUserId(id);

		return userRepo.save(user);

	}

	@Override
	public User getUser(String email) {

		return (User) userRepo.findByEmail(email);
	}

	@Override
	public List<User> findAllUser() {
	return	this.userRepo.findAll();
		
	}



}
