package com.gmail.hi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmail.hi.domain.Board;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;

	public void register(Board vo) {
		sqlSession.insert("board.register", vo);
	}

	public List<Board> list() {
		return sqlSession.selectList("board.list");
	}

	public Board detail(int bno) {
		return sqlSession.selectOne("board.detail", bno);
	}

	public void updateReadcnt(int bno) {
		sqlSession.update("board.updateReadcnt", bno);
	}

	public void update(Board vo) {
		sqlSession.update("board.update", vo);
	}

	public void delete(int bno) {
		sqlSession.delete("board.delete", bno);
	}
}