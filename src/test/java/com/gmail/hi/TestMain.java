package com.gmail.hi;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestMain {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		// Date today = new Date(cal.getTimeInMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String strDate = sdf.format(cal.getTime());
		System.out.println(strDate.substring(0,19));
		
		
		//strDate.toString().equals(today.substring(11));

		/*
		for (Board vo : list) {
			if (today.toString().equals(vo.getRegdate().substring(0, 10))) {
				vo.setDispdate(vo.getRegdate().substring(11));
			} else {
				vo.setDispdate(vo.getRegdate().substring(0, 10));
			}
		} */
	}
}
