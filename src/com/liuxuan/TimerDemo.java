package com.liuxuan;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * timer定时器的几种用法
 * @author 山贝戊
 *
 */

public class TimerDemo {
	//一·设定指定任务task在指定的时间time执行， schedule(task, delay)
	public static void timer1() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("在这里为方法1");
			}
		}, 2000);//设定指定的延迟时间time，在这里设置2000毫秒
	}
	
	//二·设定指定任务task在指定延迟delay后进行进行固定延迟peroid的执行
	//schedule(task, delay, period)
	public static void timer2() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("在这里执行方法二");
			}
		}, 3000, 1000);
	}
	
	//三·设定指定任务task在指定延迟delay后进行固定频率peroid的执行
	//scheduleAtFixedRate(task, delay, period)
	public static void timer3() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("在这里执行方法三");
			}
		}, 2000, 4000);
	}
	
	//四·安排指定的任务task在指定的时间firstTime开始进行重复的固定频率period执行
	//schedule(task, firstTime, period)
	public static void timer4() {
		
		Calendar calender = Calendar.getInstance();
		calender.set(Calendar.HOUR_OF_DAY, 15);//控制时
		calender.set(Calendar.MINUTE, 48);     //控制分
		calender.set(Calendar.SECOND, 0);      //控制秒
		
		Date date = calender.getTime();
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("在这里执行第四个方法");
			}
		}, date, 3000);//1000 * 60 * 60 * 24 每天
	}
	
	public static void main(String[] args) {
		TimerDemo.timer1();
	}
}
