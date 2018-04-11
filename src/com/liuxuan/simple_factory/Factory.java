package com.liuxuan.simple_factory;

/**
 * 工厂类
 * @author 山贝戊
 *
 */
public class Factory {
	public BMW createBMW(int type){
		switch (type) {
		
		case 320:
			return new BMW320();

		case 523:
			return new BMW523();
			
		default:
			break;
		}
		return null;
	}
	
}
