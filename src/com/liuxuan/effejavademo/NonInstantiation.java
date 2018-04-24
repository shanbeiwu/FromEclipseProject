package com.liuxuan.effejavademo;

import java.util.UUID;

/**
 * 本类讲述了通过私有构造器强化不可实例化的能力
 * 在大部分的工具类在调用的时候是不希望被实例化的，因为实例化对他没有任何意义
 * 然而，在缺少显示构造器的情况下，jvm会提供一个默认的构造器
 * 因此在当前类不包含显示的构造器时，编译器才会提供默认的构造器，因此只需要将构造器改为是私有的就可以了
 * @author 山贝戊
 *
 */
public class NonInstantiation {
	//TODO 在这里以UUID为例
	
	private NonInstantiation () {
		throw new AssertionError();//这里的异常不是必须的，但是它可以避免不小心在类中调用构造器
	}
	
	public static String getUUID () {
		//TODO 获取UUID
		return UUID.randomUUID().toString();
	}
	
	public static NonInstantiation getInstance () {
		//TODO 在这里尝试返回对象，即对本类进行实例化
		return new NonInstantiation();
	}
	
	public static void main(String[] args) {
		System.out.println(NonInstantiation.getUUID());
		NonInstantiation.getInstance();//在这里尝试获取对象，会有java.lang.AssertionError的异常抛出
	}
}
