package com.tejaswi.user.service;

import java.util.List;

import com.tejaswi.user.entity.User;

public interface UserService {

	User createUser(User user);

	User getUser(String email);

	List<User> findAllUser();
}
