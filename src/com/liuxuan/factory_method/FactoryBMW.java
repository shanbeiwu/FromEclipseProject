package com.liuxuan.factory_method;

/**
 * 创建工厂类
 * @author 山贝戊
 *
 */
public interface FactoryBMW {
	
	/**
	 * 定义创建BMW对象的抽象方法
	 * @return BMW
	 */
	BMW createBMW();
}

class FactoryBMW320 implements FactoryBMW{

	@Override
	public BMW320 createBMW() {
		// TODO 返回创建的BMW320的对象
		return new BMW320();
	}
}

class FactoryBMW523 implements FactoryBMW{

	@Override
	public BMW523 createBMW() {
		// TODO 返回创建的BMW523的对象
		return new BMW523();
	}
	
}