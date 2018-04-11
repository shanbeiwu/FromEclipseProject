package com.liuxuan.thread;

public class ThreadDemo implements Runnable {
	
	private String name;
	
	
	
	private ThreadDemo(String name) {
		super();
		this.name = name;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 5 ; i++){
			for(long k = 0 ; k < 10 ; k++){
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(name + ":" + i);
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadDemo td1 = new ThreadDemo("线程1");
		ThreadDemo td2 = new ThreadDemo("线程2");
		
		Thread t1 = new Thread(td1, "线程A");
		Thread t2 = new Thread(td2, "线程B");
		
		t1.start();
		t2.start();
	}
	
}
