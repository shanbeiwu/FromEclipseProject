package com.liuxuan.abstract_facyory;

/**
 * ��Ʒ��
 * @author ɽ����
 * �����������Լ���Ӧ���ͺ�
 */
public interface Engine {
	
}

class EngineA implements Engine{

	public EngineA() {
		System.out.println("����-->EngineA");
	}
	
}

class EngineB implements Engine{

	public EngineB() {
		System.out.println("����-->EngineB");
	}
	
}

/**
 * @author ɽ����
 * �����յ��Լ���Ӧ���ͺ�
 */
interface Aircondition{
	
}

class AirconditionA implements Aircondition{

	public AirconditionA() {
		System.out.println("����-->AirconditionA");
	}
	
}

class AirconditionB implements Aircondition{

	public AirconditionB() {
		System.out.println("����-->AircconditionB");
	}
	
}