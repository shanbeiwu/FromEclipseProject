package com.liuxuan.thread;

public class ThreadDemo4 implements Runnable {
	
	private int tick = 10;

	private ThreadDemo4() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < tick + 10 ; i++){
			if(this.tick > 0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.sell();
			}
		}
	}
	
	public synchronized void sell(){
		if(this.tick > 0){
			System.out.println(Thread.currentThread().getName() + "ºÅ´°¿ÚÂô³ö£º" + this.tick-- + "ºÅÆ±");
		}
	}

	public static void main(String[] args) {
		ThreadDemo4 td = new ThreadDemo4();
		new Thread(td, "a").start();
		new Thread(td, "b").start();
		new Thread(td, "c").start();
	}
}
