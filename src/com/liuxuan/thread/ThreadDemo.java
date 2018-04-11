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
		ThreadDemo td1 = new ThreadDemo("�߳�1");
		ThreadDemo td2 = new ThreadDemo("�߳�2");
		
		Thread t1 = new Thread(td1, "�߳�A");
		Thread t2 = new Thread(td2, "�߳�B");
		
		t1.start();
		t2.start();
	}
	
}
