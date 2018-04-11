package com.liuxuan.abstract_facyory;

/**
 * �ڴ˴���������
 * @author ɽ����
 *
 */
public interface AbstractFactory {
	//���췢����
	public Engine createEngine();
	//����յ�
	public Aircondition createAircondition();
}

/**
 * ��������BMW320�Ĺ���
 * @author ɽ����
 *
 */
class FactoryBMW320 implements AbstractFactory{

	@Override
	public Engine createEngine() {
		// TODO ΪBMW320��������A������engine����
		return new EngineA();
	}

	@Override
	public Aircondition createAircondition() {
		// TODO ΪBMW320�����յ�A������Aircondition����
		return new AirconditionA();
	}
	
}

/**
 * ��������BMW523�Ĺ���
 * @author ɽ����
 *
 */
class FactoryBMW523 implements AbstractFactory{

	@Override
	public Engine createEngine() {
		// TODO ΪBMW523��������B������Engine����
		return new EngineB();
	}

	@Override
	public Aircondition createAircondition() {
		// TODO ΪBMW523�����յ�B������Airccondition����
		return new AirconditionB();
	}
	
}
