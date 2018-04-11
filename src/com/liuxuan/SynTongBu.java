package com.liuxuan;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class SynTongBu {
	public void fun(){
		synchronized(this){
		
		}
	}
	
	public static void demo1(){
		final Map<String, Integer> count = new ConcurrentHashMap<>();
		final CountDownLatch endLatch = new CountDownLatch(2);
	}
}
