package com.User.Service.Services;

import java.util.List;

import com.User.Service.Entitys.User;

public interface UserServices {
	User saveUser(User user);

	List<User> getAllUser();

	User getUser(String userId);
}
