package com.gmail.hi.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.hi.StudyService;
import com.gmail.hi.dao.StudyDao;
import com.gmail.hi.domain.Study;
import com.gmail.hi.domain.User;

@Service
public class StudyServiceImpl implements StudyService {

	@Autowired
	private StudyDao studyDao;

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
		Study vo = new Study();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setEmail(email);
		vo.setIp(ip);
		// DAO의 메소드를 호출
		studyDao.register(vo);
	}

	@Override
	public List<Study> list() {
		List<Study> list = studyDao.list();
		Calendar cal = Calendar.getInstance();
		// Date today = new Date(cal.getTimeInMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String strDate = sdf.format(cal.getTime());

		for (Study vo : list) {
			if (strDate.toString().equals(vo.getRegdate().substring(0, 19))) {
				vo.setDispdate(vo.getRegdate().substring(20));
			} else {
				vo.setDispdate(vo.getRegdate().substring(0, 19));
			}
		}
		return list;
	}

	@Override
	public Study detail(int bno) {
		studyDao.updateReadcnt(bno);
		return studyDao.detail(bno);
	}
	
	@Override
	public Study updateView(int bno) {
	return studyDao.detail(bno);
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
        Study vo = new Study();
        vo.setBno(bno);
        vo.setTitle(title);
        vo.setContent(content);
        vo.setIp(ip);
        studyDao.update(vo);
    }
	
	@Override
	public void delete(int bno) {
	    studyDao.delete(bno);
	}






}
