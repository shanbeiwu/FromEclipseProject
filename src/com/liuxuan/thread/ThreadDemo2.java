package com.liuxuan.thread;

import java.util.Calendar;
import java.util.Date;

public class ThreadDemo2 implements Runnable {
	
	private int time;
	private String name;
	
	private ThreadDemo2() {
		super();
		// TODO Auto-generated constructor stub
	}

	private ThreadDemo2(int time, String name) {
		super();
		this.time = time;
		this.name = name;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			System.out.println(name + ":" + Calendar.getInstance().getTime());
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
//	public static void main(String[] args) {
//		Thread t1 = new Thread(new ThreadDemo2(1000, "1st"));
//		Thread t2 = new Thread(new ThreadDemo2(3000, "2st"));
//		t1.start();
//		t2.start();
//	}

}


class Probe extends Thread{
	public Probe(){}
	public void run(){
		while (true){
			Thread[] x = new Thread[100];
			Thread.enumerate(x);
			for(int i = 0 ; i < 100 ; i++){
				Thread t = x[i];
				if(t == null)
					break;
				else
					System.out.println(t.getName() + "\t" + t.getPriority()
			                + "\t" + t.isAlive() + "\t" + t.isDaemon());
			}
		}
	}
	
	
}
