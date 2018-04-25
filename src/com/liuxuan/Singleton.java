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

/*
class sing {
	private static sing s = new sing();
	private sing() {}
	public static sing getInatance() {
		return s;
	}
}
*/

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

class sing2 {
	private static sing2 s2 = new sing2();
	private sing2() {}
	public static synchronized sing2 getInatance() {
		if (s2 == null) {
			s2 = new sing2();
		}
		return s2;
	}
}
