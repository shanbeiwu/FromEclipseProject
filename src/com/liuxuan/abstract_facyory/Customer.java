package com.liuxuan.abstract_facyory;

public class Customer {
	public static void main(String[] args) {
		//生产BMW320
		FactoryBMW320 factory320 = new FactoryBMW320();
		factory320.createEngine();
		factory320.createAircondition();
		
		//生产BMW523
		FactoryBMW523 factory523 = new FactoryBMW523();
		factory523.createEngine();
		factory523.createAircondition();
	}
}
