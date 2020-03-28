package com.gmail.hi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmail.hi.domain.Study;

@Repository
public class StudyDao {
    @Autowired
    private SqlSession sqlSession;

    public void register(Study vo) {
        sqlSession.insert("study.register", vo);
    }
    public List<Study> list() {
        return sqlSession.selectList("study.list");
        }
    public Study detail(int bno) {
        return sqlSession.selectOne("study.detail", bno);
    }

    public void updateReadcnt(int bno) {
        sqlSession.update("study.updateReadcnt", bno);
    }
    public void update(Study vo) {
        sqlSession.update("study.update", vo);
    }

    public void delete(int bno) {
        sqlSession.delete("study.delete", bno);
    }




}

