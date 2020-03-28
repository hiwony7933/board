package com.gmail.hi;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gmail.hi.domain.Study;

public interface StudyService {
    public void register(HttpServletRequest request);
    
    public List<Study> list();

    //글번호를 가지고 하나의 게시글을 가져오는 메소드
    public Study detail(int bno);

    public Study updateView(int bno);

    public void update(HttpServletRequest request);

    //글번호를 가지고 게시글을 삭제하는 메소드
    public void delete(int bno);




}

