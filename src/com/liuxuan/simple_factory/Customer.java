package com.liuxuan.simple_factory;

/**
 * 客户类
 * @author 山贝戊
 *
 */
public class Customer {
	public static void main(String[] args) {
		Factory factory = new Factory();
		BMW builde320 = factory.createBMW(320);
		BMW builde523 = factory.createBMW(523);
	}
}
