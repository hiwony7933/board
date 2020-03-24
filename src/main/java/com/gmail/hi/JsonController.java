package com.gmail.hi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "user/emailcheck", method = RequestMethod.GET)
	public Map<String, Object> emailcheck(String email) {
		Map<String, Object> map = new HashMap<String, Object>();
		String result = userService.emailcheck(email);
		map.put("result", result == null);
		return map;
	}
}