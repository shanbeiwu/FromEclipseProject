package com.liuxuan.factory_method;

/**
 * ����������
 * @author ɽ����
 *
 */
public interface FactoryBMW {
	
	/**
	 * ���崴��BMW����ĳ��󷽷�
	 * @return BMW
	 */
	BMW createBMW();
}

class FactoryBMW320 implements FactoryBMW{

	@Override
	public BMW320 createBMW() {
		// TODO ���ش�����BMW320�Ķ���
		return new BMW320();
	}
}

class FactoryBMW523 implements FactoryBMW{

	@Override
	public BMW523 createBMW() {
		// TODO ���ش�����BMW523�Ķ���
		return new BMW523();
	}
	
}