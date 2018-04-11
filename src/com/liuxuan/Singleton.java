package com.liuxuan;

/**
 * 单利模式用例,饿汉式单例
 * @author 山贝戊
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
 * 单例模式用例，懒汉式单例
 * @author 山贝戊
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
