package com.liuxuan.effejavademo;

/**
 * ��̬��������
 * @author ɽ����
 *
 */

public class StaticFF {
	private static StaticFF sff = new StaticFF();
	
	public static StaticFF getInstance() {
		return sff;
	} 
	
	public void outputStatic() {
		System.out.println("this is static factory function class");
	}
	
	public static void main(String[] args) {
		StaticFF.getInstance().outputStatic();
	}
}

/*
 ��̬�����빹������Ⱦ�̬�����������и��Ե����ƣ����Ը���׼ȷ�ķ��ض��󣬶���������Ҫ��������ͬ��Ҫ�������еĲ������ֱ治ͬ�Ĺ�����
 �ڶ�������ʹ�þ�̬��������������ÿ�ε��õ�ʱ�򴴽�һ���µĶ��󣬴Ӷ�����ʹ�ô���õ����ߵ��ظ�����
 ���������ڿ��Է���ԭ�������͵��κ�����Ķ���������ѡ�񷵻صĶ�������ʱ������˸���Ŀ�ѡ��
 ���ĵ��ڴ�������������ʵ����ʱ�򣬾�̬����������ø��Ӽ��
 
*/