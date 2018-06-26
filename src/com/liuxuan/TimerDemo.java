package com.liuxuan;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * timer��ʱ���ļ����÷�
 * @author ɽ����
 *
 */

public class TimerDemo {
	//һ���趨ָ������task��ָ����ʱ��timeִ�У� schedule(task, delay)
	public static void timer1() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("������Ϊ����1");
			}
		}, 2000);//�趨ָ�����ӳ�ʱ��time������������2000����
	}
	
	//�����趨ָ������task��ָ���ӳ�delay����н��й̶��ӳ�peroid��ִ��
	//schedule(task, delay, period)
	public static void timer2() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("������ִ�з�����");
			}
		}, 3000, 1000);
	}
	
	//�����趨ָ������task��ָ���ӳ�delay����й̶�Ƶ��peroid��ִ��
	//scheduleAtFixedRate(task, delay, period)
	public static void timer3() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("������ִ�з�����");
			}
		}, 2000, 4000);
	}
	
	//�ġ�����ָ��������task��ָ����ʱ��firstTime��ʼ�����ظ��Ĺ̶�Ƶ��periodִ��
	//schedule(task, firstTime, period)
	public static void timer4() {
		
		Calendar calender = Calendar.getInstance();
		calender.set(Calendar.HOUR_OF_DAY, 15);//����ʱ
		calender.set(Calendar.MINUTE, 48);     //���Ʒ�
		calender.set(Calendar.SECOND, 0);      //������
		
		Date date = calender.getTime();
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("������ִ�е��ĸ�����");
			}
		}, date, 3000);//1000 * 60 * 60 * 24 ÿ��
	}
	
	public static void main(String[] args) {
		TimerDemo.timer1();
	}
}
