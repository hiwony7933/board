package com.gmail.hi.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmail.hi.domain.User;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;

	public String emailcheck(String email) {
		return sqlSession.selectOne("user.emailcheck", email);
	}
	
	public String nicknamecheck(String nickname) {
		return sqlSession.selectOne("user.nicknamecheck", nickname);
	}
	public int register(User user) {
		return sqlSession.insert("user.register", user);
	}
	public User login(User user) {
		return sqlSession.selectOne("user.login", user);
	}

	public int update(User user) {
		return sqlSession.update("user.update", user);
	}

	public int secession(String email) {
		return sqlSession.update("user.secession", email);
	}

}