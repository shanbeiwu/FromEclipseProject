package com.liuxuan.abstract_facyory;

/**
 * 产品类
 * @author 山贝戊
 * 生产发动机以及相应的型号
 */
public interface Engine {
	
}

class EngineA implements Engine{

	public EngineA() {
		System.out.println("制造-->EngineA");
	}
	
}

class EngineB implements Engine{

	public EngineB() {
		System.out.println("制造-->EngineB");
	}
	
}

/**
 * @author 山贝戊
 * 生产空调以及相应的型号
 */
interface Aircondition{
	
}

class AirconditionA implements Aircondition{

	public AirconditionA() {
		System.out.println("制造-->AirconditionA");
	}
	
}

class AirconditionB implements Aircondition{

	public AirconditionB() {
		System.out.println("制造-->AircconditionB");
	}
	
}