package com.liuxuan.effejavademo;

import javax.print.attribute.HashDocAttributeSet;

/**
 * 这个类表示一个复数，除了标准的object方法之外，它还提供了针对实部和虚部的访问方法，以及4种基本的算数算法
 * 注意在这些算数算法是如何创建并返回新的Complex实例，而不是修改这个实例，大多数不可变类都使用了这样的模式
 * 他被称为函数的做法，因为这些方法返回了一个函数结果，这些函数对操作数进行运算而不是修改他
 * @author 山贝戊
 *
 */
public class Complex {
	private final double re;
	private final double em;
	
	public Complex(double re, double em) {
		this.re = re;
		this.em = em;
	}
	
	public double realPart() {//提供访问实部的方法
		return re;
	}
	
	public double imaginaryPart() {//提供访问虚部的方法
		return em;
	} 
	
	public Complex add(Complex c) {
		return new Complex(re + c.re, em + c.em);
	}
	
	public Complex subtract(Complex c) {
		return new Complex(re - c.re, em - c.em);
	}
	
	public Complex multiply(Complex c) {
		return new Complex(re * c.re + em * c.em, 
							re * c.re - em * c.re);
	}
	
	public Complex divide(Complex c) {
		double tmp = c.re * c.re + c.em * c.em;
		return new Complex((re * c.re + em * c.em) / tmp, 
							(em * c.re - re * c.em) /tmp);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Complex))
			return false;
		Complex c = (Complex) o;
		return Double.compare(re, c.re) == 0 && Double.compare(em, c.em) ==0;
	}
	
	@Override
	public int hashCode() {
		int result = 17 + hashDouble(re);
		result = 31 * result + hashDouble(em);
		return result;
	}

	private int hashDouble(double val) {
		long longBits = Double.doubleToLongBits(re);
		return (int) (longBits ^ (longBits >>> 32));
	}
	
	@Override
	public String toString() {
		return "(" + re + " + " + em + "i)";
	}
}
