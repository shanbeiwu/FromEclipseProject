package com.liuxuan.thread;

public class ThreadSleepDemo implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 100 ; i++){
			if((i) % 10 == 0){
				System.out.println("--------" + i);
			}
			System.out.print(i);
			try {
				Thread.sleep(1);
				System.out.println("Ïß³ÌË¯Ãß1ºÁÃë£¡\n");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new ThreadSleepDemo().run();
	}
}
