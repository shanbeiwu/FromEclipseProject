package com.liuxuan;

/**
 * ����ģʽ����,����ʽ����
 * @author ɽ����
 *
 */
public class Singleton {
	private static Singleton singleton = new Singleton();
	private Singleton(){}
	public static Singleton getInstance(){
		return singleton;
	}
	
}

/**
 * ����ģʽ����������ʽ����
 * @author ɽ����
 *
 */
class Singleton2 {
	private static Singleton2 singleton2 = null;
	private Singleton2(){}
	public static synchronized Singleton2 getInsstace(){
		if(singleton2 == null){
			singleton2 = new Singleton2();
		}
		return singleton2;
	}
}
