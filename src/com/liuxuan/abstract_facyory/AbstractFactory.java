package com.liuxuan.abstract_facyory;

/**
 * 在此创建工厂类
 * @author 山贝戊
 *
 */
public interface AbstractFactory {
	//制造发动机
	public Engine createEngine();
	//制造空调
	public Aircondition createAircondition();
}

/**
 * 创建生产BMW320的工厂
 * @author 山贝戊
 *
 */
class FactoryBMW320 implements AbstractFactory{

	@Override
	public Engine createEngine() {
		// TODO 为BMW320生产引擎A，返回engine对象
		return new EngineA();
	}

	@Override
	public Aircondition createAircondition() {
		// TODO 为BMW320生产空调A，返回Aircondition对象
		return new AirconditionA();
	}
	
}

/**
 * 创建生产BMW523的工厂
 * @author 山贝戊
 *
 */
class FactoryBMW523 implements AbstractFactory{

	@Override
	public Engine createEngine() {
		// TODO 为BMW523生产引擎B，返回Engine对象
		return new EngineB();
	}

	@Override
	public Aircondition createAircondition() {
		// TODO 为BMW523生产空调B，返回Airccondition对象
		return new AirconditionB();
	}
	
}
