package com.gmail.hi;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UserService {
	public String emailcheck(String email);
	
	public String nicknamecheck(String nickname);

	public int register(MultipartHttpServletRequest request);
}