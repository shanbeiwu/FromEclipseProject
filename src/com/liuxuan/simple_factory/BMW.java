package com.liuxuan.simple_factory;

/**
 * ��Ʒ��
 * @author ɽ����
 *
 */
public abstract class BMW {

	public BMW() {
		
	}
	
}

class BMW320 extends BMW{

	public BMW320() {
		System.out.println("����-->BMW320");
	}
	
}

class BMW523 extends BMW{

	public BMW523() {
		System.out.println("����-->BMW523");
	}
	
}
