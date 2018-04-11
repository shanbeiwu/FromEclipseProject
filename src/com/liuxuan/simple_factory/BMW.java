package com.liuxuan.simple_factory;

/**
 * 产品类
 * @author 山贝戊
 *
 */
public abstract class BMW {

	public BMW() {
		
	}
	
}

class BMW320 extends BMW{

	public BMW320() {
		System.out.println("制造-->BMW320");
	}
	
}

class BMW523 extends BMW{

	public BMW523() {
		System.out.println("制造-->BMW523");
	}
	
}
