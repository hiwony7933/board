package com.gmail.hi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.hi.UserService;
import com.gmail.hi.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public String emailcheck(String email) {
		return userDao.emailcheck(email);
	}
}