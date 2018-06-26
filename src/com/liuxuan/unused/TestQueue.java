package com.liuxuan.unused;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestQueue {
	
	public static void test1() {
		List list = new LinkedList();
		Queue queue = new LinkedList();
		List list2 = new ArrayList();
		Queue queue2 = new ArrayDeque();
	}
	
	public static void queueDemo() {
		Queue<String> queue = new LinkedList<String>();
		
		//添加元素,add()和remove()方法在失败的时候会抛出异常，不推荐使用
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		queue.offer("d");
		queue.offer("e");
		
		for (String q : queue) {
			System.out.println("遍历： " + q);
		}
		
		System.out.println("=========");
		System.out.println("poll = " + queue.poll());//返回第一个元素，并在队列中删除
		
		for (String q : queue) {
			System.out.println("删除后的queue：" + q);
		}
		
		System.out.println("=========");
		System.out.println("element = " + queue.element());//返回第一个元素
		
		for (String q : queue) {
			System.out.println("element返回第一个元素：" + q);
		}
		
		System.out.println("=========");
		System.out.println("peek = " + queue.peek());//返回第一个元素
		
		for (String q : queue) {
			System.out.println("peek返回第一个元素：" + q);
		}
		
		System.out.println("=========");
		System.out.println("添加一个元素a：" + queue.offer("a"));
		
		for (String q : queue) {
			System.out.println("查看添加元素a的位置：" + q);
		}
		
	}
	
	public static void main(String[] args) {
		TestQueue.queueDemo();
	}
}

