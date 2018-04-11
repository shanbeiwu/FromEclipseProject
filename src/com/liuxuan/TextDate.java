package com.liuxuan;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TextDate {
	public static void main(String[] args) {
		SimpleDateFormat oldFromatter = new SimpleDateFormat("yyyy/MM/dd");
		Date date1 = new Date();
		System.out.println(oldFromatter.format(date1));
		
		//java8
		DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate date2 = LocalDate.now();
		System.out.println(date2.format(newFormatter));
		
		TextDate tt = new TextDate();
		tt.timeSimpl();
		tt.synchronizedlist();
		
	}
	
	public void timeSimpl(){
		Instant instant = Instant.now();
		System.out.println("时间戳"+System.currentTimeMillis());
		System.out.println("时间戳"+instant.atZone(ZoneId.of("Asia/Shanghai")).toInstant().toEpochMilli());
		System.out.println("时间戳"+instant.atZone(ZoneId.of("GMT+08:00")).toInstant().toEpochMilli());
		System.out.println("时间戳"+instant.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
		System.out.println("毫秒数"+Clock.systemDefaultZone().millis());
		//获取前一天的当前时间
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		System.out.println(cal.getTime());
		//Java8实现
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime yesterday = today.minusDays(1);
		System.out.println(yesterday);
	}
	
	//生成线程安全的列表（map一样方法）
	public void synchronizedlist(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("c++");
		list.add("java");
		list.add("python");
		list.add("c#");
		List<String> synlist = Collections.synchronizedList(list);
		Collections.sort(synlist);
		for(String lang : synlist){
			System.out.println("lang . "+lang);
		}
		Iterator<String> it = synlist.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
		ListIterator< String> li = synlist.listIterator(1);
		while(li.hasNext()){
			String str1 = li.next();
			System.out.println("li: " + str1);
		}
	}
}
