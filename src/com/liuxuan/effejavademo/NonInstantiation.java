package com.liuxuan.effejavademo;

import java.util.UUID;

/**
 * ���ི����ͨ��˽�й�����ǿ������ʵ����������
 * �ڴ󲿷ֵĹ������ڵ��õ�ʱ���ǲ�ϣ����ʵ�����ģ���Ϊʵ��������û���κ�����
 * Ȼ������ȱ����ʾ������������£�jvm���ṩһ��Ĭ�ϵĹ�����
 * ����ڵ�ǰ�಻������ʾ�Ĺ�����ʱ���������Ż��ṩĬ�ϵĹ����������ֻ��Ҫ����������Ϊ��˽�еľͿ�����
 * @author ɽ����
 *
 */
public class NonInstantiation {
	//TODO ��������UUIDΪ��
	
	private NonInstantiation () {
		throw new AssertionError();//������쳣���Ǳ���ģ����������Ա��ⲻС�������е��ù�����
	}
	
	public static String getUUID () {
		//TODO ��ȡUUID
		return UUID.randomUUID().toString();
	}
	
	public static NonInstantiation getInstance () {
		//TODO �����ﳢ�Է��ض��󣬼��Ա������ʵ����
		return new NonInstantiation();
	}
	
	public static void main(String[] args) {
		System.out.println(NonInstantiation.getUUID());
		NonInstantiation.getInstance();//�����ﳢ�Ի�ȡ���󣬻���java.lang.AssertionError���쳣�׳�
	}
}
