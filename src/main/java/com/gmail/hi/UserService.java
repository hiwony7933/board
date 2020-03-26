package com.gmail.hi;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gmail.hi.domain.User;

public interface UserService {
	public String emailcheck(String email);
	
	public String nicknamecheck(String nickname);

	public int register(MultipartHttpServletRequest request);
	
	public User login(User user);

	public int update(MultipartHttpServletRequest request);

	public int secession(HttpServletRequest request);

}