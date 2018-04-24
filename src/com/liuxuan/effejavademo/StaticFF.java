package com.liuxuan.effejavademo;

/**
 * 静态工厂方法
 * @author 山贝戊
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
 静态工厂与构造器相比静态工厂方法具有各自的名称，可以更加准确的返回对象，而构造器需要和类名相同，要依据其中的参数来分辨不同的构造器
 第二点在于使用静态工厂方法不会在每次调用的时候创建一个新的对象，从而可以使得代码得到更高的重复利用
 第三点在于可以返回原返回类型的任何子类的对象，这样在选择返回的对象的类的时候就有了更大的可选性
 第四点在创建参数化类型实例的时候，静态工厂方法变得更加简洁
 
*/