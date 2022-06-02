package com.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class GetDate {
	
	public HashMap getDate() {
		HashMap<String,String> map=new HashMap();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String today= df.format(cal.getTime());
		
		map.put("today", today);
		
		cal.add(Calendar.YEAR, -1);
		String yearAgo=df.format(cal.getTime());
		map.put("yearAgo", yearAgo);
		
		return map;
	}
}
