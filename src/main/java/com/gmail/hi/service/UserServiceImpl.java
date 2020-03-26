package com.gmail.hi.service;

import java.io.File;
import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gmail.hi.UserService;
import com.gmail.hi.dao.UserDao;
import com.gmail.hi.domain.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public String emailcheck(String email) {
		return userDao.emailcheck(email);
	}

	@Override
	public String nicknamecheck(String nickname) {
		return userDao.nicknamecheck(nickname);
	}

	@Override
	public int register(MultipartHttpServletRequest request) {
		int result = 0;
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String nickname = request.getParameter("nickname");
		MultipartFile image = request.getFile("image");
		String uploadPath = request.getServletContext().getRealPath("/userimage");
		// 파일 이름 만들기
		UUID uemail = UUID.randomUUID();
		String filename = image.getOriginalFilename();
		User user = new User();
		try {
			if (filename.length() > 0) {
				filename = uemail + "_" + filename;
				// 저장된 파일 경로 만들기
				String filepath = uploadPath + "\\" + filename;
				// 파일 업로드
				File file = new File(filepath);
				image.transferTo(file);
			} else {
				filename = "default.png";
			}
			user.setImage(filename);
			user.setEmail(email);
			user.setPw(BCrypt.hashpw(pw, BCrypt.gensalt(10)));
			user.setNickname(nickname);
			System.out.println(user);
			result = userDao.register(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
}