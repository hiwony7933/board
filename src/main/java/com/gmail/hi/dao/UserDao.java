package com.gmail.hi.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;

	public String emailcheck(String email) {
		return sqlSession.selectOne("user.emailcheck", email);
	}
}