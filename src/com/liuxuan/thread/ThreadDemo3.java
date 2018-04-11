package com.liuxuan.thread;

public class ThreadDemo3 implements Runnable {
	
	private int tick = 10;
	
	private ThreadDemo3() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < tick + 10 ; i++){
			synchronized (this) {
				if(this.tick > 0){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "ºÅ´°¿ÚÂô³ö£º" + this.tick-- + "ºÅÆ±");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadDemo3 td = new ThreadDemo3();
		new Thread(td, "a").start();
		new Thread(td, "b").start();
		new Thread(td, "c").start();
	}

}
