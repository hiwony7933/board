package com.gmail.hi;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gmail.hi.domain.Board;

public interface BoardService {
	public void register(HttpServletRequest request);

	public List<Board> list();

	// 글번호를 가지고 하나의 게시글을 가져오는 메소드
	public Board detail(int bno);

	// BoardService 인터페이스에 게시글 수정 보기 처리를 위한 메소드 선언
	public Board updateView(int bno);

	public void update(HttpServletRequest request); 
	
	//글번호를 가지고 게시글을 삭제하는 메소드
	public void delete(int bno);
}