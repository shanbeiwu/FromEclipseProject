package com.liuxuan.simple_factory;

/**
 * �ͻ���
 * @author ɽ����
 *
 */
public class Customer {
	public static void main(String[] args) {
		Factory factory = new Factory();
		BMW builde320 = factory.createBMW(320);
		BMW builde523 = factory.createBMW(523);
	}
}
