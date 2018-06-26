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
		
		//���Ԫ��,add()��remove()������ʧ�ܵ�ʱ����׳��쳣�����Ƽ�ʹ��
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		queue.offer("d");
		queue.offer("e");
		
		for (String q : queue) {
			System.out.println("������ " + q);
		}
		
		System.out.println("=========");
		System.out.println("poll = " + queue.poll());//���ص�һ��Ԫ�أ����ڶ�����ɾ��
		
		for (String q : queue) {
			System.out.println("ɾ�����queue��" + q);
		}
		
		System.out.println("=========");
		System.out.println("element = " + queue.element());//���ص�һ��Ԫ��
		
		for (String q : queue) {
			System.out.println("element���ص�һ��Ԫ�أ�" + q);
		}
		
		System.out.println("=========");
		System.out.println("peek = " + queue.peek());//���ص�һ��Ԫ��
		
		for (String q : queue) {
			System.out.println("peek���ص�һ��Ԫ�أ�" + q);
		}
		
		System.out.println("=========");
		System.out.println("���һ��Ԫ��a��" + queue.offer("a"));
		
		for (String q : queue) {
			System.out.println("�鿴���Ԫ��a��λ�ã�" + q);
		}
		
	}
	
	public static void main(String[] args) {
		TestQueue.queueDemo();
	}
}

