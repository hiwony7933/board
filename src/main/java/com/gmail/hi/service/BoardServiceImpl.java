package com.gmail.hi.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.hi.BoardService;
import com.gmail.hi.dao.BoardDao;
import com.gmail.hi.domain.Board;
import com.gmail.hi.domain.User;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	@Override
	public void register(HttpServletRequest request) {
		// 매개변수가 request일 때는 파라미터를 읽습니다.
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		User user = (User) request.getSession().getAttribute("user");
		String email = user.getEmail();
		if (title.length() == 0) {
			title = "무제";
		}
		if (content.length() == 0) {
			content = "냉무";
		}
		// 필요한 데이터를 생성
		String ip = request.getRemoteAddr();
		Board vo = new Board();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setEmail(email);
		vo.setIp(ip);
		// DAO의 메소드를 호출
		boardDao.register(vo);
	}

	@Override
	public List<Board> list() {
		List<Board> list = boardDao.list();
		Calendar cal = Calendar.getInstance();
		// Date today = new Date(cal.getTimeInMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String strDate = sdf.format(cal.getTime());

		for (Board vo : list) {
			if (strDate.toString().equals(vo.getRegdate().substring(0, 10))) {
				vo.setDispdate(vo.getRegdate().substring(11));
			} else {
				vo.setDispdate(vo.getRegdate().substring(0, 10));
			}
		}
		return list;
	}

	@Override
	public Board detail(int bno) {
		boardDao.updateReadcnt(bno);
		return boardDao.detail(bno);
	}

	@Override
	public Board updateView(int bno) {
		return boardDao.detail(bno);
	}

	@Override
	public void update(HttpServletRequest request) {
		// 매개변수가 request일 때는 파라미터를 읽습니다.
		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		if (title.length() == 0) {
			title = "무제";
		}
		if (content.length() == 0) {
			content = "냉무";
		}
		// 필요한 데이터를 생성
		String ip = request.getRemoteAddr();
		Board vo = new Board();
		vo.setBno(bno);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setIp(ip);
		boardDao.update(vo);
	}

	@Override
	public void delete(int bno) {
		boardDao.delete(bno);
	}
}
